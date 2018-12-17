package com.le.code.bean;

import java.util.ArrayList;

public class Table {
	private String tableId;
	private String tableName;
	private String tableCode;
	private String tableComment;
	private ArrayList<Column> columns = new ArrayList<Column>();
	private ArrayList<Column> primaryKeys = new ArrayList<Column>();

	/**
	 * 根据Id从Table中获取Column
	 */
	public Column getColumn(String id) throws Exception {
		for (Column column : columns) {
			if (id.equals(column.getColumnId())) {
				return column;
			}
		}
		throw new Exception("Id为：" + id + "对应的列不存在！");
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public ArrayList<Column> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}

	public ArrayList<Column> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(ArrayList<Column> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}
}
