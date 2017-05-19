package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyMuscle;
import com.Healthy.model.HealthyPlane;

public interface HealthyPlaneDAO {
	public List findAll();
	public List findById(String id);
	public void delete(HealthyPlane healthyplane  );
	public void update(HealthyPlane healthyplane   );
	public void add(HealthyPlane healthyplane  );
}
