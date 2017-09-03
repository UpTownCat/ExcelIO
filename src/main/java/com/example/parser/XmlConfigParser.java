package com.example.parser;

import com.example.bean.Column;
import com.example.bean.Configuration;
import com.example.bean.Table;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 * xml文件解析器
 */
public class XmlConfigParser implements ConfigParser {
    @Override
    public Configuration parse(InputStream inputStream) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        Element tableNode = root.element("table");
        Iterator columnIterator = tableNode.elementIterator();
        List<Column> columns = new ArrayList<>();
        //解析column节点
        while (columnIterator.hasNext()) {
            Element columnNode = (Element)columnIterator.next();
            String name = columnNode.attributeValue("name");
            String value = columnNode.getTextTrim();
            Column column = new Column(name, value);
            columns.add(column);
        }
        //解析table
        String tableName = tableNode.attributeValue("name");
        Integer batch = Integer.parseInt(tableNode.attributeValue("batch"));
        Table table = new Table(tableName, batch, columns);
        return new Configuration(table);
    }
}
