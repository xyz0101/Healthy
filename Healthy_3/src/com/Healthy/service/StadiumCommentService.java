package com.Healthy.service;

import java.util.List;

import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;

public interface StadiumCommentService {
	public void add(StadiumComment sc);
	public List<StadiumComment> findAll();
	public List<StadiumComment> findByUserId(String userid);
	public List<StadiumComment> findByDiffDay(String diffday);
	public List<StadiumComment> findByDiffMonth(String diffmonth);
	public void delete(StadiumComment stadiumcomment);
	public List<StadiumComment> findOne(String id);
	public List findComment(StadiumMain stadiumId);
	public StadiumComment findById(String commentId);
}
