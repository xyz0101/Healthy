package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.Page;
import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.UserMain;
import com.Healthy.service.StadiumMainService;
import com.Healthy.dao.StadiumMainDAO;
import com.Healthy.dao.UserMainDAO;

@Service
public class StadiumMainServiceImpl implements StadiumMainService {
	@Autowired
	StadiumMainDAO stadiummaindao;
	@Autowired
	UserMainDAO usermaindao;
	@Override
	public void add(StadiumMain stadiummain) {
			stadiummaindao.add(stadiummain);
	}
	@Override
	public void delete(StadiumMain stadiummain) {
		stadiummaindao.delete(stadiummain);
	}
	@Override
	public void update(StadiumMain stadiummain) {
		stadiummaindao.update(stadiummain);
	}
	@Override
	public StadiumMain findbyname(String name) {
		
		return (StadiumMain) stadiummaindao.findbyname(name).get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StadiumMain> findbySpId(SportProject sp) {
		return stadiummaindao.findbySpId(sp);
	}
	@Override
	public StadiumMain findbyId(String stadiumid) {
		return (StadiumMain) stadiummaindao.findbyId(stadiumid).get(0);
	}
	@Override
	public List findAll() {
		return stadiummaindao.findAll();
	}
	@Override
	public List findByName(String name) {
		return stadiummaindao.findbyname(name);
	}
	@Override
	public List findbyUserId(String userid) {
		UserMain user = (UserMain) usermaindao.findbyId(userid).get(0);
		return stadiummaindao.findbyUserId(user);
	}
	@Override
	public List findWithPage(Page page) {
		return stadiummaindao.findWithPage(page);
	}

}
