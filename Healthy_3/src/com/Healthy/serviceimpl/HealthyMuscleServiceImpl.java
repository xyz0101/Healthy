package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.HealthyMuscleDAO;
import com.Healthy.model.HealthyMuscle;
import com.Healthy.service.HealthyMuscleService;
@Service
public class HealthyMuscleServiceImpl implements HealthyMuscleService {
	@Autowired
	HealthyMuscleDAO healthymuscledao;
	@Override
	public List findAll() {
		return healthymuscledao.findAll();
	}
	@Override
	public void delete(HealthyMuscle healthymuscle) {
		healthymuscledao.delete(healthymuscle);
	}
	@Override
	public void update(HealthyMuscle healthymuscle) {
		healthymuscledao.update(healthymuscle);
	}
	@Override
	public void add(HealthyMuscle healthymuscle) {
		healthymuscledao.add(healthymuscle);
		
	}
	@Override
	public List findById(String id) {
		return healthymuscledao.findById(id);
	}

}
