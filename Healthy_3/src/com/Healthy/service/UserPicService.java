package com.Healthy.service;
import java.util.List;

import net.sf.json.JSON;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.model.UserPic;
public interface UserPicService {
	public void add(UserPic userpic);	
}
