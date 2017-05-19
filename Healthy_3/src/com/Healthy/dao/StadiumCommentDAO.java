package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;

public interface StadiumCommentDAO {
	public List<StadiumComment> findAll();
	public void add(StadiumComment sc);
	public List<StadiumComment> findByUserId(String userid);
	public List<StadiumComment> findByDiffDay(String diffday);
	public List<StadiumComment> findByDiffMonth(String diffmonth);
	public void delete(StadiumComment stadiumcomment);
	public List<StadiumComment> findOne(String id);
	public List<StadiumComment> findComment(StadiumMain stadiumId);
	public List<StadiumComment> findById(String commentId);
}
