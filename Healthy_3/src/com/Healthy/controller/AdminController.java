package com.Healthy.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.model.Healthyer;
import com.Healthy.model.SportProject;
import com.Healthy.model.UserMain;
import com.Healthy.service.HealthyerService;
import com.Healthy.service.ImgPlayService;
import com.Healthy.service.SportProjectService;
import com.Healthy.service.StadiumMainService;
import com.Healthy.service.StadiumPlaceService;
import com.Healthy.service.UserDetailService;
import com.Healthy.service.UserMainService;
import com.Healthy.service.UserOperateService;
import com.Healthy.service.UserPicService;
@Controller
@SessionAttributes(value={"admin"})
public class AdminController {
	@Autowired
	private UserMainService usermainservice;
	@Autowired
	private UserPicService userpicservice;
	@Autowired
	private ImgPlayService imgplayservice;
	@Autowired
	private SportProjectService sportprojectservice;
	@Autowired
	private HealthyerService healthyerservice;
	String imgId=null;
	UserMain user1;
	
	/**
	 * 管理员部分
	 */

	@RequestMapping("/toAdmin")
	public String toAdmin(){
		return "loginadm";
	}
	@RequestMapping("/loginadmin")
	public ModelAndView loginadmin(Healthyer healthyer,Model model){
		ModelAndView model1 = new ModelAndView();		
		if(healthyerservice.find(healthyer.getAdminName())!=null){
			model1.setViewName("admin");//管理员页面
			model.addAttribute("admin", healthyer);
		}else{
			model1.setViewName("error");
		}
		return model1;
	}
	//更新滚动图片
	@RequestMapping("/toUpdatePic")
	public String toUpdatePic(){
		return "updatepic";
	}
	@RequestMapping("updatePic")
	public String updatepic(String tittle,@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,Model model){
		String path = request.getSession().getServletContext().getRealPath("img");
		String fileName = file.getOriginalFilename();  
        File targetFile = new File(path, fileName); 
        imgplayservice.update(imgId, tittle, "./head/"+fileName);
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  			        
            file.transferTo(targetFile); 		            			            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", "./head/"+fileName);  			        
        return "success";  
    }  
		
	@RequestMapping("/findId")
	public @ResponseBody JSON findId(int id){
		imgId=""+id;
		return null;
	}
	///////用户/////
	@RequestMapping("/allUser")
	public ModelAndView allUser(){
		ModelAndView model = new ModelAndView();
		model.addObject("alluser", usermainservice.findAll());
		model.setViewName("alluser");
		return model;
	}
	//删除用户
	@RequestMapping("/deleteUser")
	public @ResponseBody JSON deleteUser(String userid){
		ModelAndView model = new  ModelAndView();
		System.out.println("这是id：：："+userid);
		JSONArray j = new JSONArray();
		j.add(1);
		user1=usermainservice.findId(userid);
		usermainservice.delete(user1);
		model.setViewName("alluser");
		return j;
	}
	
	
	/////增删运动项目/////
	@RequestMapping("/addSport")
	public String addSport(SportProject sportproject){
		sportprojectservice.add(sportproject);
		return "success";
	}
	@RequestMapping("/deleteSport")
	public String deleteSport(String id){
		sportprojectservice.delete(id);
		return "success";
	}
}
