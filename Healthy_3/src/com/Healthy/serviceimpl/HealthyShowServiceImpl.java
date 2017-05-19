package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.Page;
import com.Healthy.service.HealthyShowService;
import com.Healthy.dao.HealthyShowDAO;
@Service
public class HealthyShowServiceImpl implements HealthyShowService {
	@Autowired
	HealthyShowDAO healthyshowdao;
	@Override
	public void add(HealthyShow healthyshow) {
		healthyshowdao.add(healthyshow);
	}
	@Override
	public List<HealthyShow> findall() {
		return healthyshowdao.find();
	}
	@Override
	public HealthyShow findOne(String id) {
		return (HealthyShow) healthyshowdao.findOne(id).get(0);
	}
	
	
	@Override
	public List<HealthyShow> findByUserId(String userid) {
		return healthyshowdao.findByUserId(userid);
	}
	@Override
	public List<HealthyShow> findByDiffDay(String diffday) {
		return healthyshowdao.findByDiffDay(diffday);
	}
	@Override
	public List<HealthyShow> findByDiffMonth(String diffmonth) {
		return healthyshowdao.findByDiffMonth(diffmonth);
	}
	@Override
	public void delete(HealthyShow healthyshow) {
		 healthyshowdao.delete(healthyshow);
		
	}
	@Override
	public List<HealthyShow> findByPage(Page page) {
		return healthyshowdao.findByPage(page);
	}
	

}
