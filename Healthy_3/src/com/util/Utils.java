package com.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Healthy.model.StadiumPlace;



public class Utils{
	public static Timestamp dateToTime(Date date ){
		
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String str = df.format(date);
	Timestamp time = new Timestamp(System.currentTimeMillis());
	time=time.valueOf(str);
	return time;
	}
	
	
}
