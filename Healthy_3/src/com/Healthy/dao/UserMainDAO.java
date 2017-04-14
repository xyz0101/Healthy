package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.UserMain;

public interface UserMainDAO {
	public void add(UserMain user);
	public List findbyname(String name);
	public List findbyId(String id);
	public List findAll();
	public void delete(UserMain user);
}
