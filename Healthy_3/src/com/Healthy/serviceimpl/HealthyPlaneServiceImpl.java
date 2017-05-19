package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.HealthyPlaneDAO;
import com.Healthy.model.HealthyPlane;
import com.Healthy.service.HealthyPlaneService;
@Service
public class HealthyPlaneServiceImpl implements HealthyPlaneService {
	@Autowired
	HealthyPlaneDAO healthyplanedao;
	@Override
	public List findAll() {
		return healthyplanedao.findAll();
	}
	@Override
	public void delete(HealthyPlane healthyplane) {
		healthyplanedao.delete(healthyplane);
	}
	@Override
	public void update(HealthyPlane healthyplane) {
		healthyplanedao.update(healthyplane);
	}
	@Override
	public void add(HealthyPlane healthyplane) {
		healthyplanedao.add(healthyplane);
	}
	@Override
	public List findById(String id) {
		return healthyplanedao.findById(id);
	}

}
