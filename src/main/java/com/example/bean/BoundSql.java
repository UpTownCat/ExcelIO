package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 * 根据数据表和excel内容生成sql
 */
public class BoundSql {
    private Table table;
    private Excel excel;
    private String insertSql;
    private String selectSql;
    private String updateSql;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel excel) {
        this.excel = excel;
    }

    public String getInsertSql() {
        return  insertSql;
    }

    public void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

    public String getUpdateSql() {
        return updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }


    /**
     * 构造批量导入的sql
     * @return
     */
    public String createInsertSql(List<List<String>> rows) {
        Integer bacth = table.getBacth();
        String tableName = table.getName();
        List<Column> columns = table.getColumns();
        StringBuffer sb = new StringBuffer("insert into " + tableName);
        sb.append(" (");
        //设置列名
        for(int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            if(i == columns.size() - 1) {
                sb.append(column.getName());
            }else {
                sb.append(column.getName() + ",");
            }
        }
        sb.append(") values");
        //设置值
//         = excel.getRows();
        for(int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            sb.append(" (");
            for (int j = 0; j < row.size(); j++) {
//                sb.append("'");
                if(j == row.size() - 1) {
                    sb.append("'" + row.get(j) + "'");
                }else {
                    sb.append("'" +row.get(j) + "'" + ",");
                }

            }
            sb.append(")");
            if(i != rows.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
