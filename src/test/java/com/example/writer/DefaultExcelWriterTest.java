package com.example.writer;

import com.example.bean.Configuration;
import com.example.parser.ConfigParser;
import com.example.parser.XmlConfigParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/6.
 */
public class DefaultExcelWriterTest {

    @Test
    public void writeTitles() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
        ConfigParser parser = new XmlConfigParser();
        Configuration configuration = parser.parse(inputStream);
        OutputStream outputStream = new FileOutputStream("f:/test.xls");
        ExcelWriter writer = new DefaultExcelWriter();
        writer.writeTitles(configuration.getTable().getColumns(), outputStream);
    }

    @Test
    public void writeContents() throws Exception {

    }

    @Test
    public void appendContents() throws Exception {

    }
}