package com.Healthy.serviceimpl;
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
	
}
