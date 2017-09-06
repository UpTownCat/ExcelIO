package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface Executor {
    /**
     * 执行批量插入
     * @param boundSql
     * @param connection
     * @param rows
     * @throws SQLException
     */
    public void execute(BoundSql boundSql, Connection connection, List<List<String>> rows) throws SQLException;

    /**
     * 如果数据存在的话执行更新， 不存在的话执行插入
     * @param boundSql
     * @param connection
     * @param rows
     * @throws SQLException
     */
    public void executeOrUpdate(BoundSql boundSql, Connection connection, List<List<String>> rows) throws SQLException;
}
