package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.HealthyerDAO;
import com.Healthy.model.Healthyer;
import com.Healthy.service.HealthyerService;
@Service
public class HealthyerServiceImpl implements HealthyerService {
		@Autowired
		HealthyerDAO healthyerdao;
	@Override
	public Healthyer find(String name) {
		// TODO Auto-generated method stub
		Healthyer h = new Healthyer();
		if( healthyerdao.find(name).size()==0)
			return null;
		else
		return (Healthyer) healthyerdao.find(name).get(0);
	}

}
