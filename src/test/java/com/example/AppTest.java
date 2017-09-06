package com.example;

import com.example.bean.BoundSql;
import com.example.bean.Configuration;
import com.example.bean.Excel;
import com.example.executor.BatchExecutor;
import com.example.executor.Executor;
import com.example.parser.ConfigParser;
import com.example.parser.DefaulExcelParser;
import com.example.parser.ExcelParser;
import com.example.parser.XmlConfigParser;
import com.example.util.JdbcUtil;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 * 综合测试
 */
public class AppTest{

    /**
     * 测试插入
     * @throws IOException
     * @throws DocumentException
     * @throws SQLException
     */
    @org.junit.Test
    public void test() throws IOException, DocumentException, SQLException {
//        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
//        ConfigParser parser = new XmlConfigParser();
//        Configuration configuration = parser.parse(inputStream);
//        ExcelParser parser2 = new DefaulExcelParser();
//        Excel excel = parser2.parse(new FileInputStream("D:\\Downloads\\中国历史地名大辞典_工具书.xlsx"));
//        BoundSql boundSql = new BoundSql();
//        boundSql.setTable(configuration.getTable());
//        boundSql.setExcel(excel);
//        Connection connection = JdbcUtil.getConnection(configuration.getDb());
//        Executor executor = new BatchExecutor();
//        for (int i = 1; i < 70; i++) {
//            executor.execute(boundSql, connection, excel.getPages(i, configuration.getTable().getBacth()));
//        }
    }
    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer("jlkjlf");;
        sb.append("hello, world");
        System.out.println(sb.substring(0,sb.length() - 1).toString());
    }
}
