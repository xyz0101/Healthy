package com.Healthy.controller;
import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.hibernate.mapping.Collection;
import org.jgroups.tests.UnicastTest.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.interpoter.Token;
import com.Healthy.model.HealthyShow;
import com.Healthy.model.ShowReply;
import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.model.UserOperate;
import com.Healthy.model.UserPic;
import com.Healthy.service.HealthyShowService;
import com.Healthy.service.ImgPlayService;
import com.Healthy.service.ShowReplyService;
import com.Healthy.service.SportProjectService;
import com.Healthy.service.StadiumMainService;
import com.Healthy.service.StadiumPlaceService;
import com.Healthy.service.UserDetailService;
import com.Healthy.service.UserMainService;
import com.Healthy.service.UserOperateService;
import com.Healthy.service.UserPicService;
import com.util.Mycompare;
import com.util.Utils;

@Controller
@SessionAttributes(value={"user1"})
public class UserMainController {
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
	@Autowired
	private HealthyShowService healthyshowservice;
	@Autowired
	private ShowReplyService showreplyservice;
	private String spid;
	private String stid;
			//启动时打开主页
			@RequestMapping({ "/", "" })
			public String tosport(){
				
				return "sport";
			}
			
	@RequestMapping("/Register")
		public String register(UserMain user,UserDetail userdetail,UserOperate useroperate,UserPic userpic
				){
		String s =UUID.randomUUID().toString();
		user.setUserId(s);
		usermainservice.add(user);
		userdetail.setUserMain(user);
		userdetail.setUserId(s);
		userdetailservice.add(userdetail);
		useroperate.setUserMain(user);
		useroperateservice.add(useroperate);
		userpic.setUserId(s);
		userpic.setUserMain(user);
		userpicservice.add(userpic);
		System.out.println(user.getUserId());
			return "success";	
		}
	@RequestMapping("/tologin")
	public String tologin(){
		
		return "login";	
	}
	

	@RequestMapping("/ToRegister")
	public String toregister(){
		return "register";	
	}
	@RequestMapping("/find")
	public String find(String name,Model model){
		System.out.println("name:::"+name);
		UserMain user; 
		user= (UserMain) usermainservice.find(name);
		model.addAttribute("user", user);
		System.out.println(user.getUserId());
		System.out.println(user.getUserPassword());
		return "success";	
	}
	@Token(save=true)
	@RequestMapping("/login")
	public ModelAndView login(String nameorphone,String password,Model model){
		ModelAndView model1 = new ModelAndView();
		System.out.println("名字：：：："+nameorphone);
		boolean isuser = usermainservice.login(nameorphone, password);
		if(isuser){
			UserMain user = (UserMain) usermainservice.find(nameorphone);
			model1.setViewName("sport");
			model.addAttribute("user1", user);
			model.addAttribute("pic", user.getUserPic());
		}else{
			model1.setViewName("error");
		}
		return model1;
	}
	//注销用户
			@RequestMapping("/out")
			public String Out(SessionStatus sessionStatus){
				sessionStatus.setComplete();
				return "redirect:/tosport";
			}
	//登陆检测，判断用户名是否注册
			@RequestMapping("/findname")
			public @ResponseBody JSON findname1(String name){				
				JSONArray jsonarray = new JSONArray();
				int size =usermainservice.findname(name).size();
				System.out.println("有没有：：：："+size);
				jsonarray.add(size);			
				if(size!=0)
				System.out.println(name+"   "+((UserMain) usermainservice.findname(name).get(0)).getUserPassword());
				ModelAndView mv = new ModelAndView();			
				mv.setViewName("login");
				System.out.println("json数组：：："+jsonarray);
				return jsonarray;
			}	
			/////圈子///////
			//发圈子
			@RequestMapping("/upSpace")
			public String upSpace(HealthyShow healthyshow){
				healthyshow.setShowId(UUID.randomUUID().toString());
				healthyshowservice.add(healthyshow);
				return "success";
			}
			//遍历圈子
			@RequestMapping("/toAllSpace")
			public String allSpace(Model model){
				model.addAttribute("allspace", healthyshowservice.findall());
				return "allspace";	
			}
			//删除圈子
			@RequestMapping("/deleteSpace")
			public JSON deleteSpace(String id){
				JSONArray jsa = new JSONArray();
				HealthyShow h = healthyshowservice.findOne(id);
				healthyshowservice.deleteOne(h);
				return jsa;		
			}
	//////所有运动项目////
			@RequestMapping("/Tosportproject")
			public String tospp(Model model){
				model.addAttribute("project", sportprojectservice.findAll());
				return "sportproject";
			}
	//////跳转到具体场馆///
			@RequestMapping("/getspid")
			public @ResponseBody JSON getspid(String spid){
				this.spid=spid;
				JSONArray jsa = new JSONArray();
				jsa.add(spid);
				return jsa;
			}
			@RequestMapping("/getstid")
			public @ResponseBody JSON getstid(String stid){
				this.stid=stid;
				JSONArray jsa = new JSONArray();
				jsa.add(stid);
				return jsa;
			}
			@RequestMapping("/tosport_gym")
			public String tosport_gym(Model model){
				
				System.out.println("----id----"+spid);
				//第一次会为null
				SportProject sp = sportprojectservice.find(spid).get(0);
				System.out.println(sp);
				model.addAttribute("proj", stadiummainservice.findbySpId(sp));
				
				model.addAttribute("type", spid);
				return "sport_gym";
				
			}
			@RequestMapping("/ToStadium_Detail")
			public String tostadium_detail(Model model){
				
				System.out.println("----id----"+stid);
				//第一次会为null	
				StadiumMain sm = (StadiumMain) stadiummainservice.findbyId(stid);	//List splist = stadiummplaceservice.findbyStadiumId(stid);
				
				System.out.println("Stadiummain="+sm.getStadiumName());
				@SuppressWarnings("unchecked")
				List<StadiumPlace> splist = stadiummplaceservice.findbyStadiumMain(sm);
				System.out.println("splist="+stadiummplaceservice.findbyStadiumMain(sm));
				List<StadiumPlace> splist1 =new ArrayList<StadiumPlace>();
				splist1=splist;
				Collections.sort(splist1, new Mycompare());
				model.addAttribute("min", splist1.get(0).getPlacePrice());
				model.addAttribute("max", splist1.get(splist.size()-1).getPlacePrice());
				model.addAttribute("stadium", sm);
				model.addAttribute("splist", splist);
				return "stadium_detail";
				
			}
			
			
	//////圈子回复//////
			/*
			 * doget(userid,showid,content)
			 * dataType:json
			 * data:JSON.stringify({userid:idu,showid:ids})
			 * contentType:"application/json"
			 * */
			@RequestMapping("/reply")
			public @ResponseBody JSON reply(@RequestBody Map map){
				JSONArray j = new JSONArray();
				j.add(1);
				ShowReply showreply = new ShowReply();
				showreply.setUserId((String) map.get("userid"));
				showreply.setReplyContent((String) map.get("content"));	
				showreply.setReplyTime(Utils.dateToTime(new Date()));
				showreply.setReplyId(UUID.randomUUID().toString());
				showreply.setHealthyShow(healthyshowservice.findOne((String) map.get("showid")));
				showreplyservice.add(showreply);
				return j;
			}
}
