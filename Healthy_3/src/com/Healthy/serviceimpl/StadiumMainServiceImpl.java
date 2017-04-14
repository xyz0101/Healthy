package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;
import com.Healthy.service.StadiumMainService;
import com.Healthy.dao.StadiumMainDAO;

@Service
public class StadiumMainServiceImpl implements StadiumMainService {
	@Autowired
	StadiumMainDAO stadiummaindao;
	@Override
	public void add(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
			stadiummaindao.add(stadiummain);
	}
	@Override
	public void delete(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
		stadiummaindao.delete(stadiummain);
	}
	@Override
	public void update(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public StadiumMain findbyname(String name) {
		// TODO Auto-generated method stub
		
		return (StadiumMain) stadiummaindao.findbyname(name).get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StadiumMain> findbySpId(SportProject sp) {
		// TODO Auto-generated method stub
		return stadiummaindao.findbySpId(sp);
	}
	@Override
	public StadiumMain findbyId(String stadiumid) {
		// TODO Auto-generated method stub
		return (StadiumMain) stadiummaindao.findbyId(stadiumid).get(0);
	}

}
