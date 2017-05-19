package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.HealthyEquipment;

public interface HealthyEquipmentDAO {
	public List findAll();
	public List findById(String id);
	public void delete(HealthyEquipment healthyequipment);
	public void update(HealthyEquipment healthyequipment);
	public void add(HealthyEquipment healthyequipment);
	
}
