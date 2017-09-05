package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface Executor {
    public void execute(BoundSql boundSql, Connection connection) throws SQLException;
}
