package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 * excel文件的映射
 */
public class Excel {
    //文件名
    private String name;
    //第一行的标题
    private List<String> titles;
    //行的信息
    private List<List<String>> rows;
    //总记录数
    private Integer totalRows;
    //列数
    private Integer colNum;

    public Excel() {
    }

    public Excel(String name, List<String> titles, List<List<String>> rows, Integer totalRows, Integer colNum) {
        this.name = name;
        this.titles = titles;
        this.rows = rows;
        this.totalRows = totalRows;
        this.colNum = colNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }
}
