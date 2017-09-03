package com.example.parser;

import com.example.bean.Column;
import com.example.bean.Configuration;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/3.
 */
public class XmlConfigParserTest {

    @Test
    public void parse() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test\\ExcelIO\\src\\main\\resources\\config.xml");
        ConfigParser parser = new XmlConfigParser();
        Configuration configuration = parser.parse(inputStream);
        System.out.println("the table name is " + configuration.getTable().getName() + " , batch is : " + configuration.getTable().getBacth() );
        List<Column> columns = configuration.getTable().getColumns();
        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            System.out.println("name : " + column.getName() + " , value : " + column.getValue());
        }
    }
}