package com.Healthy.serviceimpl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.UserPicDAO;
import com.Healthy.model.UserPic;
import com.Healthy.service.UserPicService;

@Service
public class UsePicServiceImpl implements UserPicService{
	@Autowired
	private UserPicDAO userpicdao;

	@Override
	public void add(UserPic userpic) {
		userpicdao.add(userpic);
		
	}

	@Override
	public void updatePic(UserPic userpic) {
		userpicdao.updatePic(userpic);
		
	}

	@Override
	public UserPic findById(String userid) {
		// TODO Auto-generated method stub
		return (UserPic) userpicdao.findByUserId(userid).get(0);
	}
	
}
