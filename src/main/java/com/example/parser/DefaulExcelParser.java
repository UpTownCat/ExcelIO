package com.example.parser;

import com.example.bean.Excel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 * 默认的解析器
 */
public class DefaulExcelParser implements ExcelParser {
    /**
     * 解析Excel
     * @param inputStream
     * @return
     * @throws IOException
     */
    @Override
    public Excel parse(InputStream inputStream) throws IOException {
//        Workbook
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception ex) {
            // 解决read error异常
            workbook = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        //获得总行数
        int totalRows = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        //获得列数
        int colNum = row.getLastCellNum();

        return new Excel("", totalRows, colNum, sheet);
    }

}
