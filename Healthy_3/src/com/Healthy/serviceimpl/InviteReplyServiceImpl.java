package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.InviteReply;
import com.Healthy.service.InviteReplyService;
import com.Healthy.dao.InviteReplyDAO;
@Service
public class InviteReplyServiceImpl implements InviteReplyService {
	@Autowired
		InviteReplyDAO invitereplydao;
	@Override
	public void add(InviteReply invitereply) {
		// TODO Auto-generated method stub
			invitereplydao.add(invitereply);
	}

}
