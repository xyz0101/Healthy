package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.CommentReplyDAO;
import com.Healthy.model.CommentReply;
import com.Healthy.model.StadiumComment;
import com.Healthy.service.CommentReplyService;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
	@Autowired
	CommentReplyDAO commentreplydao;
	@Override
	public List findReply(StadiumComment stadiumcomment) {
		
		return commentreplydao.findReply(stadiumcomment);
	}
	@Override
	public void add(CommentReply commentreply) {
		commentreplydao.add(commentreply);
		
	}
	@Override
	public void delete(CommentReply commentreply) {
		commentreplydao.delete(commentreply);
		
	}
	@Override
	public List<CommentReply> findAll() {
		return commentreplydao.findAll();
	}
	@Override
	public List<CommentReply> findByUserId(String userid) {
		return commentreplydao.findByUserId(userid);
	}
	@Override
	public List<CommentReply> findByDiffDay(String diffday) {
		return commentreplydao.findByDiffDay(diffday);
	}
	@Override
	public List<CommentReply> findByDiffMonth(String diffmonth) {
		return commentreplydao.findByDiffMonth(diffmonth);
	}
	@Override
	public List<CommentReply> findById(String replyid) {
		return commentreplydao.findById(replyid);
	}

}
