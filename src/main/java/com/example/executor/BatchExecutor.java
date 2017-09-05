package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/9/4.
 * 批量导入数据执行器
 */
public class BatchExecutor implements Executor{
    @Override
    public void execute(BoundSql boundSql, Connection connection) throws SQLException {
        long start = System.currentTimeMillis();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(boundSql.createInsertSql());
        long end = System.currentTimeMillis();
        System.out.println("成功写入" + result + "条数据， 耗时" + (end - start) + "毫秒。");
    }
}
