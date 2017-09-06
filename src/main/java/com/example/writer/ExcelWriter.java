package com.example.writer;

import com.example.bean.Column;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface ExcelWriter {
    /**
     * 写标题
     * @param columns
     */
    public void writeTitles(List<Column> columns, OutputStream outputStream) throws IOException;

    /**
     * 直接写内容
     * @param contents
     */
    public void writeContents(List<List<String>> contents, OutputStream outputStream);

    /**
     * 已拼接的方式写内容
     * @param contents
     */
    public void appendContents(List<List<String>> contents, OutputStream outputStream);
}
