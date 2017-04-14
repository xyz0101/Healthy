package com.Healthy.controller;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.service.ImgPlayService;
import com.Healthy.service.SportProjectService;
import com.Healthy.service.StadiumMainService;
import com.Healthy.service.StadiumPlaceService;
import com.Healthy.service.UserDetailService;
import com.Healthy.service.UserMainService;
import com.Healthy.service.UserOperateService;
import com.Healthy.service.UserPicService;

public class SellerController {

	@Autowired
	private UserMainService usermainservice;
	@Autowired
	private StadiumMainService stadiummainservice;
	@Autowired
	private StadiumPlaceService stadiummplaceservice;
	@Autowired
	private UserDetailService userdetailservice;
	@Autowired
	private UserOperateService useroperateservice;
	@Autowired
	private UserPicService userpicservice;
	@Autowired
	private ImgPlayService imgplayservice;
	@Autowired
	private SportProjectService sportprojectservice;
	
	private StadiumMain stamain;
	private StadiumPlace staplace;
	/**
	 * 商家部分
	 * 
	 */
///////运动项目子页面////////
	@RequestMapping("/addStadium")
	public String addStadium(StadiumMain stadiummain){
		stadiummainservice.add(stadiummain);
		return "success";
	}
	@RequestMapping("/toUpdateStadium")
	public @ResponseBody String toUpdateSta( String name){	
		stamain=stadiummainservice.findbyname(name);
		return "updateStadium";
	}
	@RequestMapping("/updateStadium")
	public  String updateStadium(StadiumMain stadiummain){
		stamain.setStadiumPrice(stadiummain.getStadiumPrice());
		stamain.setStadiumLocation(stadiummain.getStadiumLocation());
		stamain.setStadiumIntroduction(stadiummain.getStadiumIntroduction());
		stamain.setStadiumTel(stadiummain.getStadiumTel());
		stamain.setStadiumPhoto(stadiummain.getStadiumPhoto());
		stamain.setStadiumStatus(stadiummain.getStadiumStatus());
		stadiummainservice.update(stamain);
		return "success";
		
	}
	@RequestMapping("/deleteStadium")
	public @ResponseBody JSON deleteStadium(String name){
		JSONArray jsonarray = new JSONArray();
		StadiumMain stadiummain = new StadiumMain();
		stadiummain=stadiummainservice.findbyname(name);
		stadiummainservice.delete(stadiummain);
		return jsonarray;
	}
	@RequestMapping("/addPlace")
	public String addPlace(StadiumPlace stadiumplace){
		stadiummplaceservice.addplace(stadiumplace);
		return "success";
	}
	@RequestMapping("/toUpdatePlace")
	public @ResponseBody String toUpdatePla( String placeid){	
		staplace=(StadiumPlace) stadiummplaceservice.findbyid(placeid);
		return "updatePlace";
	}
	@RequestMapping("/UpdatePlace")
	public String updatePlace(StadiumPlace stadiumplace){
		staplace.setPlaceLocation(stadiumplace.getPlaceLocation());
		staplace.setPlacePhoto(stadiumplace.getPlacePhoto());
		staplace.setPlacePrice(stadiumplace.getPlacePrice());
		staplace.setPlaceStatus(stadiumplace.getPlaceStatus());
		stadiummplaceservice.update(staplace);
		return "success";
		
	}
	@RequestMapping("/deletePlace")
	public @ResponseBody JSON deletePlace(String name){
		JSONArray jsonarray = new JSONArray();
		StadiumPlace stadiumplace = new StadiumPlace();
		stadiumplace=(StadiumPlace) stadiummplaceservice.findbyid(name);
		stadiummplaceservice.delete(stadiumplace);
		return jsonarray;
	}
}
