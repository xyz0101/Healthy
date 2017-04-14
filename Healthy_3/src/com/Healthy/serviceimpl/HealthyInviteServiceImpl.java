package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.HealthyInvite;
import com.Healthy.service.HealthyInviteService;
import com.Healthy.dao.HealthyInviteDAO;
@Service
public class HealthyInviteServiceImpl implements HealthyInviteService {
	@Autowired
	HealthyInviteDAO healthyinvitedao;
	@Override
	public void add(HealthyInvite healthyinvite) {
		// TODO Auto-generated method stub
	
		healthyinvitedao.add(healthyinvite);
	}

}
