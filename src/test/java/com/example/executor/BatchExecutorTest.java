package com.example.executor;

import com.example.bean.BoundSql;
import com.example.bean.Configuration;
import com.example.bean.Excel;
import com.example.parser.ConfigParser;
import com.example.parser.DefaulExcelParser;
import com.example.parser.ExcelParser;
import com.example.parser.XmlConfigParser;
import com.example.util.JdbcUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/6.
 */
public class BatchExecutorTest {

    @Test
    public void execute() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
        ConfigParser parser = new XmlConfigParser();
        Configuration configuration = parser.parse(inputStream);
        ExcelParser parser2 = new DefaulExcelParser();
        Excel excel = parser2.parse(new FileInputStream("D:\\Downloads\\中国历史地名大辞典_工具书.xlsx"));
        BoundSql boundSql = new BoundSql();
        boundSql.setTable(configuration.getTable());
        boundSql.setExcel(excel);
        Connection connection = JdbcUtil.getConnection(configuration.getDb());
        Executor executor = new BatchExecutor();
        for (int i = 1; i < 70; i++) {
            executor.execute(boundSql, connection, excel.getPages(i, configuration.getTable().getBacth()));
        }
    }

    @Test
    public void executeOrUpdate() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
        ConfigParser parser = new XmlConfigParser();
        Configuration configuration = parser.parse(inputStream);
        ExcelParser parser2 = new DefaulExcelParser();
        Excel excel = parser2.parse(new FileInputStream("D:\\Downloads\\中国历史地名大辞典_工具书.xlsx"));
        BoundSql boundSql = new BoundSql();
        boundSql.setTable(configuration.getTable());
        boundSql.setExcel(excel);
        Connection connection = JdbcUtil.getConnection(configuration.getDb());
        Executor executor = new BatchExecutor();
        for (int i = 1; i < 70; i++) {
            executor.executeOrUpdate(boundSql, connection, excel.getPages(i, configuration.getTable().getBacth()));
        }
    }
}