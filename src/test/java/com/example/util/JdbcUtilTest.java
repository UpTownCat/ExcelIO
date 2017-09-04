package com.example.util;

import com.example.bean.Configuration;
import com.example.parser.ConfigParser;
import com.example.parser.XmlConfigParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/4.
 */
public class JdbcUtilTest {

    @Test
    public void getConnection() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
        ConfigParser parser = new XmlConfigParser();
        Configuration configuration = parser.parse(inputStream);
        Connection connection = JdbcUtil.getConnection(configuration.getDb());
        assertNotNull(connection);
    }
}