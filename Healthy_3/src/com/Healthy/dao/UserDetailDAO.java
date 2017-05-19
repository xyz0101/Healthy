package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.UserDetail;

public interface UserDetailDAO {
	public void add(UserDetail userdetail);
	public void update(UserDetail userdetail);
	public List findByUserId(String userid);
	public List findbyphone(String phone);
	public List findAll();
}
