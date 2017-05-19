package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.Page;

public interface HealthyShowService {
	public List<HealthyShow> findByPage(Page page);
	public void add(HealthyShow healthyshow);
	public List<HealthyShow> findByUserId(String userid);
	public List<HealthyShow> findByDiffDay(String diffday);
	public List<HealthyShow> findByDiffMonth(String diffmonth);
	public List<HealthyShow> findall();
	public HealthyShow findOne(String id);
	public void delete(HealthyShow healthyshow);
}
