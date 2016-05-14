package cn.rookie.pool;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.cn.rookie.pool
 * Description:
 */
public class TestMyPool {
    private MyPool myPool;
    @Before
    public void setUp() {
        this.myPool = new MyPool();
    }

    @Test
    public void testGet() {
        System.out.println("初始化的大小 : "+this.myPool.getInit_count());
        System.out.println("连接池的大小 : "+this.myPool.getPool().size());

        this.myPool.getConnection();
        Assert.assertEquals(3,this.myPool.getInit_count());
        Assert.assertEquals(2,this.myPool.getPool().size());
        System.out.println("获取一个连接后 : " + this.myPool.toString());

        this.myPool.getConnection();
        this.myPool.getConnection();
        this.myPool.getConnection();
        Assert.assertEquals(3,this.myPool.getInit_count());
        Assert.assertEquals(0,this.myPool.getPool().size());
        System.out.println("获取四个连接后 : "+this.myPool.toString());

    }

    @Test
    public void testRelase() throws SQLException {

        System.out.println(this.myPool.toString());

        Connection con1 = this.myPool.getConnection();
        Connection con2 = this.myPool.getConnection();
        Connection con3 = this.myPool.getConnection();
        Connection con4 = this.myPool.getConnection();
        Connection con5 = this.myPool.getConnection();
        Connection con6 = this.myPool.getConnection();
        System.out.println(this.myPool.toString());
        this.myPool.realeaseConnection(con1);
        System.out.println(this.myPool.toString());
        this.myPool.realeaseConnection(con2);
        System.out.println(this.myPool.toString());
        this.myPool.realeaseConnection(con3);
        this.myPool.realeaseConnection(con4);
        this.myPool.realeaseConnection(con5);
        this.myPool.realeaseConnection(con6);

        System.out.println(this.myPool.toString());
    }

    @Test
    public void testClose() throws SQLException {
        System.out.println(this.myPool.toString());

        Connection con1 = this.myPool.getConnection();
        Connection con2 = this.myPool.getConnection();
        Connection con3 = this.myPool.getConnection();
        Connection con4 = this.myPool.getConnection();
        Connection con5 = this.myPool.getConnection();
        Connection con6 = this.myPool.getConnection();
        con1.close();
        con2.close();
        con3.close();
        con4.close();
        con5.close();
        con6.close();
        System.out.println(this.myPool.toString());
        /**
         * 这里可以直接关闭此连接，但是因为有线程池的概念，因此在关闭的时候要增加原来的线程池大小。
         */


    }
}
