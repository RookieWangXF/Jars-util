package cn.rookie.dbcp;

import cn.rookie.pool.MyPool;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.dbcp
 * Description:
 */
public class TestDbcp {
    private Dbcp dbcp;
    private Connection conn;
    @Before
    public void setUp() {
        this.dbcp = new Dbcp();
    }

    @Test
    public void testGetConnection() throws SQLException {
        conn = dbcp.getConnection();
        ResultSet set = conn.prepareStatement("Select * from admin").executeQuery();
        while (set.next()) {
            System.out.print("id: " + set.getInt(1));
            System.out.print(" name: " + set.getString(2));
            System.out.print(" age: " + set.getInt(3));
            System.out.println();
        }
    }

    @Test
    public void testGetConnectionBy() throws Exception {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("src/main/resources/dbcp.properties");
        prop.load(in);

        // 根据配置，直接创建数据源对象
        DataSource dataSouce = BasicDataSourceFactory.createDataSource(prop);


        conn = dataSouce.getConnection();
        ResultSet set = conn.prepareStatement("Select * from admin").executeQuery();
        System.out.println("getConnectionBy");
        while (set.next()) {
            System.out.print("id: " + set.getInt(1));
            System.out.print(" name: " + set.getString(2));
            System.out.print(" age: " + set.getInt(3));
            System.out.println();
        }    }

        @After
        public void close() throws SQLException {
            this.conn.close();
        }
}
