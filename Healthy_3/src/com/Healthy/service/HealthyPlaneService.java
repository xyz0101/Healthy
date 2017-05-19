package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyPlane;

public interface HealthyPlaneService {
	public List findAll();
	public List findById(String id);
	public void delete(HealthyPlane healthyplane  );
	public void update(HealthyPlane healthyplane   );
	public void add(HealthyPlane healthyplane  );
}
