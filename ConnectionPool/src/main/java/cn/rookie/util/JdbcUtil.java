package cn.rookie.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Rookie on 2016/4/23.
 * Package name is cn.rookie.util
 * Description:
 */
public class JdbcUtil {
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
