package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.service.UserMainService;
import com.Healthy.dao.UserMainDAO;

@Service
public class UserMainServiceImpl implements UserMainService{
	@Autowired
	private UserMainDAO usermaindao;
	@Override
	public void add(UserMain user) {
	usermaindao.add(user);	
	}
	@Override
	public UserMain find(String name) {
		UserMain user = (UserMain) usermaindao.findbyname(name).get(0);
		System.out.println("ID:::"+user.getUserId());
		return user;
	}
	@Override
	public boolean login(String nameorphone, String password ) {
		System.out.println("Ãû×Ö2£º£º£º£º£º£º"+nameorphone);
		UserMain user = find(nameorphone);
		System.out.println("ID:::"+user.getUserId());
		if(password.equals(user.getUserPassword()))
		return true;
		return false;
	}
	@Override
	public String register(UserMain user, UserDetail userdetail) {
		usermaindao.add(user);
		return null;
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List findname(String name) {
		return usermaindao.findbyname(name);
	}
	@Override
	public boolean loginadmin(String nameorphone, String password) {
		if(password.equals("123456")&&nameorphone.equals("admin"))
		return true;
		return false;
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return usermaindao.findAll();
	}
	@Override
	public void delete(UserMain user) {
		// TODO Auto-generated method stub
		usermaindao.delete(user);
	}
	@Override
	public UserMain findId(String id) {
		// TODO Auto-generated method stub
		return (UserMain) usermaindao.findbyId(id).get(0);
	}

}
