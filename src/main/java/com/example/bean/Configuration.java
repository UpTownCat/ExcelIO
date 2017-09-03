package com.example.bean;

/**
 * Created by Administrator on 2017/9/3.
 * 配置文件映射的类
 */
public class Configuration {
    //对应的数据表
    private Table table;
    //数据库相关信息
    private DB db;

    public Configuration() {
    }

    public Configuration(Table table, DB db) {
        this.table = table;
        this.db = db;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
