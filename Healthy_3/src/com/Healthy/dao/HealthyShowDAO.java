package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.Page;

public interface HealthyShowDAO {
		public void add(HealthyShow healthyshow);
		public List<HealthyShow> find();
		public List<HealthyShow> findByPage(Page page);
		public List<HealthyShow> findByUserId(String userid);
		public List<HealthyShow> findByDiffDay(String diffday);
		public List<HealthyShow> findByDiffMonth(String diffmonth);
		public void delete(HealthyShow healthyshow);
		public List<HealthyShow> findOne(String id);
		
}
