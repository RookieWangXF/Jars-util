package cn.rookie.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.cn.rookie.pool
 * Description: 自定义连接池，管理连接
 */
public class MyPool {
    /**
     *   1.  MyPool.java  连接池类，
         2.  指定全局参数：  初始化数目、最大连接数、当前连接、  连接池集合
         3.  构造函数：循环创建3个连接
         4.  写一个创建连接的方法
         5.  获取连接
         ------>  判断： 池中有连接， 直接拿
         ------>                池中没有连接，
         ------>                 判断，是否达到最大连接数； 达到，抛出异常；没有达到最大连接数，
         创建新的连接
         6. 释放连接
     */

    private int init_count = 3;  //初始化连接数目
    private int max_count = 6;  //最大连接数
    private int current_count;  //记录当前连接数
    //连接池，（存放所有的初始化连接）
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**
     * 构造函数中，初始化连接放入连接池
     */
    public MyPool() {
        for (int i = 0; i < init_count; i++) {
            current_count++;
            pool.addLast(createConnection());
        }
    }

    /**
     * 创建一个新的连接，使用代理对象进行监控
     * @return
     */
    public Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc_demo","root","root");
            /**
             * 为conn指定代理对象
             */
            Connection proxy = (Connection) Proxy.newProxyInstance(
                    conn.getClass().getClassLoader(),  //类加载器
                    //conn.getClass().getInterfaces(),  conn是类的时候可以使用这个方法
                    new Class[]{Connection.class},//目标对象实现的接口,因为其本身也是一个接口
                    new InvocationHandler() { //当调用conn对象方法的时候，会自动触发
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            Object result = null;
                            String methodName = method.getName();
                            if ("close".equals(methodName)) {
                                //当线程池的大小比初始化小的时候才会放入线程池
                                if (pool.size() < init_count) {
                                    System.out.println("begin:当前执行close方法开始！");
                                    pool.addLast(conn);
                                    System.out.println("end: 当前连接已经放入连接池了！");
                                } else {
                                    current_count--;
                                }

                            } else {
                                result = method.invoke(conn, args);
                            }
                            return result;
                        }
                    }
            );
            return proxy;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     * @return
     */
    public Connection getConnection() {
        //如果连接池中剩余连接，则直接给就可以
        if (pool.size() > 0) {
            return pool.removeFirst();
        }
        //如果连接池中没有连接，那么创建新的连接
        if (current_count < max_count) {
            current_count++;
            return createConnection();
        }
        //当连接数量达到最大时候，停止建立连接
        throw new RuntimeException("当前连接数目已经达到最大");
    }

    /**
     * 释放连接
     * @param connection
     */
    public void realeaseConnection(Connection connection) {
        /**
         * 当连接的数量小于初始化连接池时候，将释放的连接放入连接池中
         * 反之将连接释放即可
         */

        if (pool.size() < init_count) {
            pool.addLast(connection);
        } else {
            try {
                current_count--;
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getInit_count() {
        return init_count;
    }

    public void setInit_count(int init_count) {
        this.init_count = init_count;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public int getCurrent_count() {
        return current_count;
    }

    public void setCurrent_count(int current_count) {
        this.current_count = current_count;
    }

    public LinkedList<Connection> getPool() {
        return pool;
    }

    public void setPool(LinkedList<Connection> pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "当前有连接数current_count = "+ getCurrent_count()
                +"; 最大连接数max_count = "+ getMax_count()
                +"; 初始化大小init_count = "+ getInit_count()
                +"; 连接池剩余连接pool = "+ getPool().size();
    }
}
