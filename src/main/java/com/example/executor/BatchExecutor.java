package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/9/4.
 */
public class BatchExecutor implements Executor{
    @Override
    public void execute(BoundSql boundSql, Connection connection) throws SQLException {
//        Statement statement = connection.createStatement();
//        statement.ba
        Statement statement = connection.createStatement();
        boolean result = statement.execute(boundSql.createInsertSql());
//        connection.commit();
        System.out.println(result);
    }
}
