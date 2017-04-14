package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyShow;

public interface HealthyShowDAO {
		public void add(HealthyShow healthyshow);
		public List<HealthyShow> find();
		public void delete(HealthyShow healthyshow);
		public List<HealthyShow> findOne(String id);
}
