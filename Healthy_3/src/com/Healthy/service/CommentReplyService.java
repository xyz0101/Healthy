package com.Healthy.service;

import java.util.List;

import com.Healthy.model.CommentReply;
import com.Healthy.model.StadiumComment;

public interface CommentReplyService {
	public List<CommentReply> findAll();
	public List<CommentReply> findByUserId(String userid);
	public List<CommentReply> findByDiffDay(String diffday);
	public List<CommentReply> findByDiffMonth(String diffmonth);
	public List<CommentReply> findById(String replyid);
	
	public List findReply(StadiumComment stadiumcomment);
	public void add(CommentReply commentreply);
	 public void delete(CommentReply commentreply);
}
