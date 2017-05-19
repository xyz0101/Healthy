package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyEquipment;
import com.Healthy.model.HealthyMuscle;

public interface HealthyMuscleDAO {
	public List findAll();
	public List findById(String id);
	public void delete(HealthyMuscle healthymuscle );
	public void update(HealthyMuscle healthymuscle  );
	public void add(HealthyMuscle healthymuscle  );
	
}
