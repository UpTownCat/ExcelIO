package com.example.bean;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 * excel文件的映射
 */
public class Excel {
    //文件名
    private String name;
    //总记录数
    private Integer totalRows;
    //列数
    private Integer colNum;
    //表单
    private Sheet sheet;

    public Excel() {
    }

    public Excel(String name, Integer totalRows, Integer colNum, Sheet sheet) {
        this.name = name;
        this.totalRows = totalRows;
        this.colNum = colNum;
        this.sheet = sheet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
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
    public List<String> getTitles() {
        Row row = sheet.getRow(0);
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

    /**
     * 解析excel的所有内容（谨慎用，文件的记录太多会造成内存溢出）
     * @return
     */
    public List<List<String >> getAllRows() {
        return getPages(1, Integer.MAX_VALUE);
    }

    /**
     * 分页读取内容
     * @param index 下标（从一点开始）
     * @param size 每一页的数量
     * @return
     */
    public List<List<String>> getPages(int index, int size) {
        List<List<String>> result = new ArrayList<>();
        int begin = (index - 1) * size + 1;
        int end = Math.min((index * size + 1), totalRows);
        for(int i = begin; i < end; i++) {
            Row row = sheet.getRow(i);
            List<String> list = new ArrayList<>();
            for (int j = 0; j < colNum; j++) {
                String value = getCellFormatValue(row.getCell(j));
                list.add(value);
            }
            result.add(list);
        }
        return result;
    }

}
