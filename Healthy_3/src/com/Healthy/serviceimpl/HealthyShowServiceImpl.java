package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.HealthyShow;
import com.Healthy.service.HealthyShowService;
import com.Healthy.dao.HealthyShowDAO;
@Service
public class HealthyShowServiceImpl implements HealthyShowService {
	@Autowired
	HealthyShowDAO healthyshowdao;
	@Override
	public void add(HealthyShow healthyshow) {
		// TODO Auto-generated method stub
		healthyshowdao.add(healthyshow);
	}
	@Override
	public List<HealthyShow> findall() {
		// TODO Auto-generated method stub
		return healthyshowdao.find();
	}
	@Override
	public HealthyShow findOne(String id) {
		// TODO Auto-generated method stub
		return (HealthyShow) healthyshowdao.findOne(id);
	}
	@Override
	public void deleteOne(HealthyShow healthyshow) {
		// TODO Auto-generated method stub
		healthyshowdao.delete(healthyshow);
	}
	

}
