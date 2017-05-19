package com.util;

import java.sql.Timestamp;
import java.util.Comparator;

import com.Healthy.model.CommentReply;
import com.Healthy.model.ShowReply;

public class MycompareTimeReply implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Timestamp t1 = null;
		Timestamp t2 = null;
		if(o1 instanceof ShowReply){
			o1=(ShowReply)o1;
			t1=((ShowReply) o1).getReplyTime();
		}	
		else if(o1 instanceof CommentReply){
			o1=(CommentReply)o1;
			t1=((CommentReply) o1).getReplyTime();
		}
		if(o2 instanceof ShowReply){
			o2=(ShowReply)o2;
			t2=((ShowReply) o2).getReplyTime();
		}
		else if(o2 instanceof CommentReply) {
			o2=(CommentReply)o2;
			t2=((CommentReply) o2).getReplyTime();
		}
		int result =t1.compareTo(t2);
		return result;
	}

}
