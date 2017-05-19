package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.ShowReply;
import com.Healthy.service.ShowReplyService;
import com.Healthy.dao.ShowReplyDAO;

@Service
public class ShowReplyServiceImpl implements ShowReplyService {
	@Autowired
	ShowReplyDAO showreplydao;
	@Override
	public void add(ShowReply showreply) {
			showreplydao.add(showreply);
	}
	@Override
	public List findByShow(HealthyShow healthyshow) {
		return showreplydao.findByShow(healthyshow);
	}
	@Override
	public List<ShowReply> findByUserId(String userid) {
		return showreplydao.findByUserId(userid);
	}
	@Override
	public List<ShowReply> findByDiffDay(String diffday) {
		return showreplydao.findByDiffDay(diffday);
	}
	@Override
	public List<ShowReply> findByDiffMonth(String diffmonth) {
		return showreplydao.findByDiffMonth(diffmonth);
	}
	@Override
	public List<ShowReply> findAll() {
		return showreplydao.findAll();
	}
	@Override
	public void delete(ShowReply showreply) {
		showreplydao.delete(showreply);
	}
	@Override
	public ShowReply findById(String replyid) {
		return showreplydao.findById(replyid).get(0);
	}

}
