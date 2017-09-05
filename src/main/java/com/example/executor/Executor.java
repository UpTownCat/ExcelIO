package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface Executor {
    public void execute(BoundSql boundSql, Connection connection, List<List<String>> rows) throws SQLException;
}
