package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.UserOperate;
import com.Healthy.service.UserOperateService;
import com.Healthy.dao.UserOperateDAO;
@Service
public class UseOperateServiceImpl implements UserOperateService{
	@Autowired
	private UserOperateDAO useroperatedao;

	@Override
	public void add(UserOperate useroperate) {
		useroperatedao.add(useroperate);	
	}	
}
