package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.ShowReply;
import com.Healthy.service.ShowReplyService;
import com.Healthy.dao.ShowReplyDAO;

@Service
public class ShowReplyServiceImpl implements ShowReplyService {
	@Autowired
	ShowReplyDAO showreplydao;
	@Override
	public void add(ShowReply showreply) {
		// TODO Auto-generated method stub
			showreplydao.add(showreply);
	}

}
