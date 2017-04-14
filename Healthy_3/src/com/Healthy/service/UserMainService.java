package com.Healthy.service;
import java.util.List;

import net.sf.json.JSON;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
public interface UserMainService {
	public void add(UserMain user);
	public void delete(UserMain user);
	public UserMain find(String name);
	public UserMain findId(String id);
	public boolean login(String nameorphone,String password );
	public boolean loginadmin(String nameorphone,String password );
	public String register(UserMain user , UserDetail userdetail);
	public List findname(String name);	
	public List findAll();
	
}
