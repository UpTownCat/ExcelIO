package com.example.writer;

import com.example.bean.Column;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
public class DefaultExcelWriter implements ExcelWriter {


    /**
     * 写标题
     * @param columns
     */
    @Override
    public void writeTitles(List<Column> columns, OutputStream outputStream) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet0");
        HSSFRow row = sheet.createRow(0);
        for(int i = 0; i < columns.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(columns.get(i).getValue());
        }
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();
    }
    /**
     * 直接写内容
     * @param contents
     */
    @Override
    public void writeContents(List<List<String>> contents, OutputStream outputStream) {

    }
    /**
     * 已拼接的方式写内容
     * @param contents
     */
    @Override
    public void appendContents(List<List<String>> contents, OutputStream outputStream) {

    }
}
