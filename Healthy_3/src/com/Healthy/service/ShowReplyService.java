package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.ShowReply;

public interface ShowReplyService {
		public List<ShowReply> findByUserId(String userid);
		public List<ShowReply> findByDiffDay(String diffday);
		public List<ShowReply> findByDiffMonth(String diffmonth);
		public List<ShowReply> findAll();
		public ShowReply findById(String replyid);
		public void delete(ShowReply showreply);
		public void add(ShowReply showreply);
		public List findByShow(HealthyShow healthyshow);
}	
