package cn.rookie.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.c3p0
 * Description:学习C3p0连接池
 */
public class C3p0 {
    /**
     * 硬编码方式实现连接池
     * @return 连接对象
     */
    public Connection getConnection() throws SQLException, PropertyVetoException {
        // C3p0连接池核心类
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置连接参数：url、驱动、用户密码、初始连接数、最大连接数
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setInitialPoolSize(3);
        dataSource.setMaxPoolSize(6);
        dataSource.setMaxIdleTime(1000);

        return dataSource.getConnection();
    }

    /**
     * 由于无法读取内部的文件，因此写到了test中
     * @return
     * @throws FileNotFoundException
     */
    public Connection getConnByXml() throws FileNotFoundException {
        InputStream in = new FileInputStream("src\\main\\java\\cn\\rookie\\c3p0\\c3p0.xml");
        return null;
    }

}
