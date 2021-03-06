package com.example.parser;

import com.example.bean.Excel;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/3.
 */
public class DefaulExcelParserTest {

    @Test
    public void parse() throws Exception {
        ExcelParser parser = new DefaulExcelParser();
        Excel excel = parser.parse(new FileInputStream("D:\\Downloads\\中国历史地名大辞典_工具书.xlsx"));
        System.out.println("totalColumn = " + excel.getColNum());
        List<String> titles = excel.getTitles();
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            System.out.print("title = " + title + "  ");
        }
        System.out.println();
        List<List<String>> rows = excel.getPages(1, 1000);
        for (int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            for(int j = 0; j < row.size(); j++) {
                String v = row.get(j);
                System.out.print(v + "   ");
            }
            System.out.println();
        }
    }
}