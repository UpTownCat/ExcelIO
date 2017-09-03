package com.example.parser;

import com.example.bean.Excel;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/3.
 */
public interface ExcelParser {
    public Excel parse(InputStream inputStream) throws IOException;
}
