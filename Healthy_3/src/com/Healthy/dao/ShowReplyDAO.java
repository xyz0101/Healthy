package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.ShowReply;

public interface ShowReplyDAO {
	public List<ShowReply> findByUserId(String userid);
	public List<ShowReply> findByDiffDay(String diffday);
	public List<ShowReply> findByDiffMonth(String diffmonth);
	public List<ShowReply> findAll();
	public List<ShowReply> findById(String replyid);
		public void add(ShowReply showreply);
		public void delete(ShowReply showreply);
		public List findByShow(HealthyShow healthyshow);
}
