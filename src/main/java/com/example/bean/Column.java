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
    //数据类型
    private String type;

    public Column() {
    }

    public Column(String name, String value, String type) {

        this.name = name;
        this.value = value;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
