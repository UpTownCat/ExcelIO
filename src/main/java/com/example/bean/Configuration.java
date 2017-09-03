package com.example.bean;

/**
 * Created by Administrator on 2017/9/3.
 * 配置文件映射的类
 */
public class Configuration {
    //对应的数据表
    private Table table;

    public Configuration() {
    }

    public Configuration(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
