package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;

public interface StadiumMainDAO {
	public void add(StadiumMain stadiummain);
	public List findbyname(String name);
	public List findbyId(String stadiumid);
	public List findbySpId(SportProject sp);
	public void delete(StadiumMain stadiummain);
	public void update(StadiumMain stadiummain);
}
