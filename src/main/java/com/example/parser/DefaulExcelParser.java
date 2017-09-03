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

        return new Excel("", parseTitles(row), parseRows(sheet), totalRows, colNum);
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    /**
     * 解析列标题
     * @param row
     * @return
     */
    public List<String> parseTitles(Row row) {
        int colNum = row.getLastCellNum();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < colNum; i++) {
            String titleStr = getCellFormatValue(row.getCell(i));
            titles.add(titleStr);
        }
        return titles;
    }

    /**
     * 解析内容
     * @param sheet
     * @return
     */
    public List<List<String>> parseRows(Sheet sheet) {
        int total = sheet.getLastRowNum();
        List<List<String>> rows = new ArrayList<>();
        for(int i = 1; i <= 1000; i++) {
            Row row = sheet.getRow(i);
            int colNum = row.getLastCellNum();
            List<String> rowValue = new ArrayList<>();
            for (int j = 0; j < colNum; j++) {
                String value = getCellFormatValue(row.getCell(j));
                rowValue.add(value);
            }
            rows.add(rowValue);
        }
        return rows;
    }
}
