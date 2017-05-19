package com.Healthy.model;

public class Page {
	private String table;
	private String pageSize;
	private String pageNow;
	private String colName;
	private String conditionClo;
	private String condition;
	
	public Page(String table, String pageSize, String pageNow, String colName,
			String conditionClo, String condition) {
		super();
		this.table = table;
		this.pageSize = pageSize;
		this.pageNow = pageNow;
		this.colName = colName;
		this.conditionClo = conditionClo;
		this.condition = condition;
	}
	public Page(String table, String pageSize, String pageNow, String colName) {
		super();
		this.table = table;
		this.pageSize = pageSize;
		this.pageNow = pageNow;
		this.colName = colName;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getPageNow() {
		return pageNow;
	}
	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getConditionClo() {
		return conditionClo;
	}
	public void setConditionClo(String conditionClo) {
		this.conditionClo = conditionClo;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
