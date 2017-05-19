package com.Healthy.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.UserDetail;
import com.Healthy.service.UserDetailService;
import com.Healthy.dao.UserDetailDAO;


@Service
public class UserDetailServiceImpl implements UserDetailService{
	@Autowired
	private UserDetailDAO userdetaildao;

	@Override
	public void add(UserDetail userdetail) {
		userdetaildao.add(userdetail);
		
	}

	@Override
	public UserDetail findByUserId(String userid) {
		// TODO Auto-generated method stub
		return (UserDetail) userdetaildao.findByUserId(userid).get(0);
	}

	@Override
	public List findByUserPhone(String phone) {
		return userdetaildao.findbyphone(phone);
	}

	@Override
	public void update(UserDetail userdetail) {
		userdetaildao.update(userdetail);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return userdetaildao.findAll();
	}
	
}
