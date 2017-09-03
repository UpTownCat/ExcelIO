package com.example.bean;

/**
 * Created by Administrator on 2017/9/3.
 * 列
 */
public class Column {
    //数据库对应的列名
    private String name;
    //excel文件对应的列名
    private String value;

    public Column() {
    }

    public Column(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
