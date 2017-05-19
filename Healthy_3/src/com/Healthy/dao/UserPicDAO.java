package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.UserPic;

public interface UserPicDAO {
	public void add(UserPic userpic);
	public void updatePic(UserPic userpic);
	public List findByUserId(String userid);
	}
