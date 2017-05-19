package com.Healthy.service;
import java.util.List;

import net.sf.json.JSON;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
public interface UserDetailService {
	public void add(UserDetail userdetail);
	public void update(UserDetail userdetail);
	public UserDetail findByUserId(String userid);
	public List findByUserPhone(String phone);
	public List findAll();
}
