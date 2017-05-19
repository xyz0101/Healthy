package com.Healthy.service;

import java.util.List;

import com.Healthy.model.HealthyEquipment;

public interface HealthyEquipmentService {
	public List findById(String id);
	public List findAll();
	public void delete(HealthyEquipment healthyequipment);
	public void update(HealthyEquipment healthyequipment);
	public void add(HealthyEquipment healthyequipment);
	
}
