package cn.rookie.c3p0;

import cn.rookie.dbcp.Dbcp;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.c3p0
 * Description:
 */
public class TestC3p0 {

    private C3p0 c;
    private Connection conn;
    @Before
    public void setUp() {
        this.c = new C3p0();
    }

    @Test
    public void testGetConnection() throws SQLException, PropertyVetoException {
        conn = c.getConnection();
        ResultSet set = conn.prepareStatement("Select * from admin").executeQuery();
        while (set.next()) {
            System.out.print("id: " + set.getInt(1));
            System.out.print(" name: " + set.getString(2));
            System.out.print(" age: " + set.getInt(3));
            System.out.println();
        }
    }

    @Test
    public void testGetConnByXml() throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource("src/main/resources/c3p0.properties");
        conn = dataSource.getConnection();
        ResultSet set = conn.prepareStatement("Select * from admin").executeQuery();
        while (set.next()) {
            System.out.print("id: " + set.getInt(1));
            System.out.print(" name: " + set.getString(2));
            System.out.print(" age: " + set.getInt(3));
            System.out.println();
        }
    }
    @After
    public void close() throws SQLException {
        this.conn.close();
    }
}
