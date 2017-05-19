package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyMuscle;

public interface HealthyMuscleService {
	public List findAll();
	public List findById(String id);
	public void delete(HealthyMuscle healthymuscle );
	public void update(HealthyMuscle healthymuscle  );
	public void add(HealthyMuscle healthymuscle  );
}
