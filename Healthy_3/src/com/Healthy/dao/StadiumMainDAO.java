package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.Page;
import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.UserMain;

public interface StadiumMainDAO {
	public void add(StadiumMain stadiummain);
	public List findbyname(String name);
	public List findbyId(String stadiumid);
	public List findbyUserId(UserMain user);
	public List findbySpId(SportProject sp);
	public List findWithPage(Page page);
	public void delete(StadiumMain stadiummain);
	public void update(StadiumMain stadiummain);
	public List findAll();
}
