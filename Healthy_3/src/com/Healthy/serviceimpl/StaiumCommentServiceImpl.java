package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.StadiumCommentDAO;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;
import com.Healthy.service.StadiumCommentService;
@Service
public class StaiumCommentServiceImpl implements StadiumCommentService {
	@Autowired
	StadiumCommentDAO stadiumcommentdao;
	@Override
	public List findComment(StadiumMain stadiumId) {
		return stadiumcommentdao.findComment(stadiumId);
	}
	@Override
	public StadiumComment findById(String commentId) {
		return (StadiumComment) stadiumcommentdao.findById(commentId).get(0);
	}
	@Override
	public List<StadiumComment> findAll() {
		return stadiumcommentdao.findAll();
	}
	@Override
	public List<StadiumComment> findByUserId(String userid) {
		return stadiumcommentdao.findByUserId(userid);
	}
	@Override
	public List<StadiumComment> findByDiffDay(String diffday) {
		return stadiumcommentdao.findByDiffDay(diffday);
	}
	@Override
	public List<StadiumComment> findByDiffMonth(String diffmonth) {
		return stadiumcommentdao.findByDiffMonth(diffmonth);
	}
	@Override
	public void delete(StadiumComment stadiumcomment) {
		stadiumcommentdao.delete(stadiumcomment);
	}
	@Override
	public List<StadiumComment> findOne(String id) {
		return stadiumcommentdao.findOne(id);
	}
	@Override
	public void add(StadiumComment sc) {
		stadiumcommentdao.add(sc);
	}

}
