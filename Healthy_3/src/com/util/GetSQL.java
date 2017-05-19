package com.util;

import com.Healthy.model.Page;

public class GetSQL {
public static String getSQLwithWhere(Page page){
		String spageNow=String.valueOf((Integer.parseInt(page.getPageNow())-1)*Integer.parseInt(page.getPageSize()));
		
		String SQL="SELECT * from "
				+  page.getTable()+" where "
				+ page.getConditionClo()+"='"+page.getCondition()+"' and "
				+ page.getColName()+" not in(select "
				+page.getColName()+ " from (select * from "
				+ page.getTable()+" where "
				+ page.getConditionClo()+"='"+page.getCondition()+"'LIMIT "
				+ spageNow+") as t)   limit "+page.getPageSize();
		return SQL;
	}
	public static String getSQL(Page page){
		String spageNow=String.valueOf((Integer.parseInt(page.getPageNow())-1)*Integer.parseInt(page.getPageSize()));
		
		String SQL="SELECT * from "
				+ page.getTable()+" where "
				+ page.getColName()+" not in(select "
				+ page.getColName()+" from (select * from "
				+ page.getTable()+" LIMIT "
				+spageNow+ ") as t) limit "+page.getPageSize();
		return SQL;
	}
}
