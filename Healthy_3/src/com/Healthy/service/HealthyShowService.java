package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyShow;

public interface HealthyShowService {
	public void add(HealthyShow healthyshow);
	public List<HealthyShow> findall();
	public HealthyShow findOne(String id);
	public void deleteOne(HealthyShow healthyshow);
}
