package com.example.parser;

import com.example.bean.Excel;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/3.
 */
public interface ExcelParser {
    /**
     * 解析excel
     * @param inputStream
     * @return
     * @throws IOException
     */
    public Excel parse(InputStream inputStream) throws IOException;
}
