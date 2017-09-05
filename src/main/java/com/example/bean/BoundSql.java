package com.example.bean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4.
 * 根据数据表和excel内容生成sql
 */
public class BoundSql {
    private Table table;
    private Excel excel;

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

    /**
     * 构造批量导入的sql
     * @return
     */
    public String createInsertSql(List<List<String>> rows) {
        String tableName = table.getName();
        List<Column> columns = table.getColumns();
        StringBuffer sb = new StringBuffer("insert into " + tableName);
        sb.append(" (");
        //设置列名
        for(int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            sb.append(column.getName() + ",");
        }
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
        sb.append(") values");
        //设置值
        for(int i = 0; i < rows.size(); i++) {
            List<String> row = rows.get(i);
            sb.append(" (");
            for (int j = 0; j < row.size(); j++) {
                sb.append("'" +row.get(j) + "'" + ",");

            }
            sb = new StringBuffer(sb.substring(0, sb.length() - 1));
            sb.append("),");
        }
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
        return sb.toString();
    }

    /**
     * 把map 构造成 key = value形式
     * @param condictions
     * @return
     */
    private String mapToCondictionStr(Map<String, String> condictions) {
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = condictions.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append( " " + next.getKey() + "=" + next.getValue() + ",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * 获取判断记录是否存在的sql
     * @param condictions
     * @return
     */
    public String createSelectSql(Map<String, String> condictions) {
        StringBuffer sb = new StringBuffer("select count(1) from " + table.getName() + "where ");
        return sb.append(mapToCondictionStr(condictions)).toString();
    }

    /**
     * 获取更新的sql
     * @param row
     * @param condictions
     * @return
     */
    public String createUpdateSql(List<String> row, Map<String, String> condictions) {
        StringBuffer sb = new StringBuffer("update " + table.getName() + " set");
        List<Column> columns = table.getColumns();
        for(int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i).getName() + "=" + row.get(i) + ",");
        }
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
        sb.append(mapToCondictionStr(condictions));
        return sb.toString();
    }
}
