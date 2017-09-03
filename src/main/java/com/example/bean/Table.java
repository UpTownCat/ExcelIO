package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 */
public class Table {
    //表名
    private String name;
    //一次出入数据表的数据的数量
    private Integer bacth;
    //数据表的列
    private List<Column> columns;

    public Table() {
    }

    public Table(String name, Integer bacth, List<Column> columns) {
        this.name = name;
        this.bacth = bacth;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBacth() {
        return bacth;
    }

    public void setBacth(Integer bacth) {
        this.bacth = bacth;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
