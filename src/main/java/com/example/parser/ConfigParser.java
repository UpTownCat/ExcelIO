package com.example.parser;

import com.example.bean.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/3.
 * 配置文件转换接口
 */
public interface ConfigParser {
    //转换为configuration对象
    public Configuration parse(InputStream inputStream) throws DocumentException;
}
