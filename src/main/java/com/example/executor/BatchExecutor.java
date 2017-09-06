package com.example.executor;

import com.example.bean.BoundSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Administrator on 2017/9/4.
 * 批量导入数据执行器
 */
public class BatchExecutor implements Executor{

    /**
     * 执行批量插入
     * @param boundSql
     * @param connection
     * @param rows
     * @throws SQLException
     */
    @Override
    public void execute(BoundSql boundSql, Connection connection, List<List<String>> rows) throws SQLException {
        long start = System.currentTimeMillis();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate(boundSql.createInsertSql(rows));
        long end = System.currentTimeMillis();
        System.out.println("成功写入" + result + "条数据， 耗时" + (end - start) + "毫秒。");
        rows = null;
        try {

        }finally {
            connection.close();
        }
    }
    /**
     * 如果数据存在的话执行更新， 不存在的话执行插入
     * @param boundSql
     * @param connection
     * @param rows
     * @throws SQLException
     */
    @Override
    public void executeOrUpdate(BoundSql boundSql, Connection connection, List<List<String>> rows) throws SQLException {
        List<List<String>> insertRows = new ArrayList<>();
        Statement statement = connection.createStatement();
        for (int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            Map<String , String > condictions = new HashMap<>();
            condictions.put("content", "'" + row.get(4) + "'");
            String selectSql = boundSql.createSelectSql(condictions);
            ResultSet resultSet = statement.executeQuery(selectSql);
            resultSet.next();
            int result = resultSet.getInt(1);
            if(result == 0) {
                insertRows.add(row);
            }else {
                String updateSql = boundSql.createUpdateSql(row, condictions);
                statement.addBatch(updateSql);
            }
        }
        Long start = System.currentTimeMillis();
        statement.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println("成功更新批量更新" + (rows.size() - insertRows.size()) +"条记录，耗时" + (end - start) + "ms");
        statement.close();
        if(insertRows.size() > 0) {
            //执行插入数据
            execute(boundSql, connection, insertRows);
        }
    }
}
