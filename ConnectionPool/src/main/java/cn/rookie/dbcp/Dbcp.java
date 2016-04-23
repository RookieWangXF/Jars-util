package cn.rookie.dbcp;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.dbcp
 * Description:学习使用DBCP连接池
 */
public class Dbcp {
    /**
     * 硬编码方式实现连接池
     * @return 连接对象
     */
    public Connection getConnection() throws SQLException {
        // DBCP连接池核心类
        BasicDataSource dataSouce = new BasicDataSource();

        // 连接池参数配置：初始化连接数、最大连接数 / 连接字符串、驱动、用户、密码
        dataSouce.setUrl("jdbc:mysql:///mybatis");			//数据库连接字符串
        dataSouce.setDriverClassName("com.mysql.jdbc.Driver");  //数据库驱动
        dataSouce.setUsername("root");							//数据库连接用户
        dataSouce.setPassword("root"); 							//数据库连接密码
        dataSouce.setInitialSize(3);  // 初始化连接
        dataSouce.setMaxActive(6);	  // 最大连接
        dataSouce.setMaxIdle(3000);   // 最大空闲时间

        return dataSouce.getConnection();
    }

    /**
     * 通过配置文件获取连接参数
     * @return 连接对象
     */
    public Connection getConnectionBy() throws Exception {
        Properties prop = new Properties();
        InputStream in = Dbcp.class.getResourceAsStream("");
        prop.load(in);

        // 根据配置，直接创建数据源对象
        DataSource dataSouce = BasicDataSourceFactory.createDataSource(prop);

        return dataSouce.getConnection();
    }


}
