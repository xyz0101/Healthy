package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.HealthyEquipmentDAO;
import com.Healthy.model.HealthyEquipment;
import com.Healthy.service.HealthyEquipmentService;
@Service
public class HealthyEquipmentServiceImpl implements HealthyEquipmentService {
@Autowired
HealthyEquipmentDAO healthyequipmentdao;
	@Override
	public List findAll() {
		return healthyequipmentdao.findAll();
	}
	@Override
	public void delete(HealthyEquipment healthyequipment) {
		healthyequipmentdao.delete(healthyequipment);
	}
	@Override
	public void update(HealthyEquipment healthyequipment) {
		healthyequipmentdao.update(healthyequipment);
	}
	@Override
	public void add(HealthyEquipment healthyequipment) {
		healthyequipmentdao.add(healthyequipment);
	}
	@Override
	public List findById(String id) {
		return healthyequipmentdao.findById(id);
	}

}
