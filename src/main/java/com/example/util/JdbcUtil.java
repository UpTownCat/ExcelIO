package com.example.util;

import com.example.bean.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/4.
 * jdbc工具类
 */
public class JdbcUtil {
    private JdbcUtil(){};

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static final Connection getConnection(DB db) throws SQLException {
        try {
            Class.forName(db.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
        return connection;
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static final void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
