package com.Healthy.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.model.CommentReply;
import com.Healthy.model.HealthyEquipment;
import com.Healthy.model.HealthyMuscle;
import com.Healthy.model.HealthyPlane;
import com.Healthy.model.HealthyShow;
import com.Healthy.model.Healthyer;
import com.Healthy.model.PlaceOrder;
import com.Healthy.model.ShowReply;
import com.Healthy.model.SportAdvice;
import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.model.UserPic;
import com.Healthy.service.CommentReplyService;
import com.Healthy.service.HealthyEquipmentService;
import com.Healthy.service.HealthyMuscleService;
import com.Healthy.service.HealthyPlaneService;
import com.Healthy.service.HealthyShowService;
import com.Healthy.service.HealthyerService;
import com.Healthy.service.ImgPlayService;
import com.Healthy.service.PlaceOrderService;
import com.Healthy.service.ShowReplyService;
import com.Healthy.service.SportAdviceService;
import com.Healthy.service.SportProjectService;
import com.Healthy.service.StadiumCommentService;
import com.Healthy.service.StadiumMainService;
import com.Healthy.service.StadiumPlaceService;
import com.Healthy.service.UserDetailService;
import com.Healthy.service.UserMainService;
import com.Healthy.service.UserOperateService;
import com.Healthy.service.UserPicService;
import com.util.Utils;
/**
 * 管理员controller部分
 * @author 周锦
 *
 */
@Controller
@SessionAttributes(value={"admin"})
public class AdminController {
	
	
	@Autowired
	private UserMainService usermainservice;
	@Autowired
	private CommentReplyService commentreplyservice;
	@Autowired
	private UserPicService userPicService;
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
	private HealthyEquipmentService healthyequipmentservice;
	@Autowired
	private HealthyMuscleService healthymuscleservice;
	@Autowired
	private HealthyPlaneService healthyplaneservice;
	@Autowired
	private HealthyShowService healthyshowservice;
	@Autowired
	private ShowReplyService showreplyservice;
	@Autowired
	private StadiumCommentService stadiumcommentservice;
	@Autowired
	private PlaceOrderService placeorderservice;
	@Autowired
	private SportProjectService sportprojectservice;
	@Autowired
	private HealthyerService healthyerservice;
	@Autowired
	private SportAdviceService sportadviceservice;
	String imgId=null;
	UserMain user1;
	String eid;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 管理员部分
	 */

	@RequestMapping("/toMain")
	public String toAdmin(){
		return "main";
	}
	@RequestMapping("/toLoginAdmin")
	public String toLoginAdmin(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "admin_login";
	}
	@RequestMapping("/loginadmin")
	public @ResponseBody String loginadmin(String adminName,String adminPassword,Model model){
		String msg="";
		Healthyer healthyer = healthyerservice.find(adminName);
		if(healthyer!=null&&adminPassword.equals(healthyer.getAdminPassword())){
			msg="ok";
			model.addAttribute("admin", healthyer);
		}else{
			msg="fail";
		}
		return msg;
	}
	@RequestMapping("/toNav")
	public String toNav(HttpSession session){
		if(session.getAttribute("admin")!=null)
		return "nav";
		else 
			return "error";
	}
	//更新滚动图片
	@RequestMapping("/toUpdatePic")
	public String toUpdatePic(){
		return "updatepic";
	}
	
	
	
	/**
	 * 编辑用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/to_edit")
	public String to_edit(Model model ,HttpSession session){
		UserMain user = usermainservice.findId(eid);
		UserDetail ud = userdetailservice.findByUserId(eid);
		UserPic up = userpicservice.findById(eid);
		model.addAttribute("euser", user);
		model.addAttribute("eud", ud);
		model.addAttribute("epic", up);
		if(ud.getUserBirth()!=null){
			String[] bir = df.format(ud.getUserBirth()).split("-");
			model.addAttribute("year", bir[0]);
			model.addAttribute("month", bir[1]);
			model.addAttribute("day", bir[2].substring(0, 2).trim());
		}if(ud.getUserLocation()!=null){
			
			model.addAttribute("pro",ud.getUserLocation().substring(0,2) );
			model.addAttribute("city",ud.getUserLocation().substring(2,4) );
		}
		if(session.getAttribute("admin")!=null)
		return "edit_user";
		else return "error";
	}
	/**
	 * 
	 * @param userid
	 * @param model
	 * @return 编辑用户需要的ID
	 */
	@RequestMapping("/send_id")
	public @ResponseBody String send_id(String id,Model mode,HttpSession session){
		String msg="fail";
		if(session.getAttribute("admin")!=null)
		eid=id;
		msg="success";
		if(session.getAttribute("admin")!=null)
		return msg;
		else return "none";
	}
	/**
	 * 所有用户信息
	 * @param kind
	 * @param model
	 * @return
	 */
	@RequestMapping("/touser_table")
	public String touser_table(String kind,Model model,HttpSession session,HttpServletRequest request){
		String msg="fail";
		UserMain user = new UserMain();
		UserDetail ud = new UserDetail();
		List<UserMain> userlist1 = new ArrayList<UserMain>();
		List dlist = new ArrayList();
		String pageSize="10";
		userlist1=usermainservice.findAll();
		List<UserMain> userlist = new ArrayList<UserMain>();
		userlist=Utils.getPageList(request, userlist1, pageSize);
		for(int i=0;i<userlist.size();i++){
			user=userlist.get(i);
			String id=user.getUserId();
			ud = userdetailservice.findByUserId(id);
			
			String phone= ud.getUserTel();
			String nickname= user.getUserNickname();
			//String name=ud.
			String sex = user.getUserSex();
			String qq = ud.getUserQq();
			String blood = ud.getUserBlood();
			String sig = ud.getUserSignature();
			if(sig!=null)
				sig=sig.replaceAll("\r|\n", "   ");
			String location = ud.getUserLocation();
			String btime="";
			if(ud.getUserBirth()==null)
				 btime="";
			else
				 btime= df.format(ud.getUserBirth());
			String statu = user.getUserStatus();
			if(sex==null)
				sex="";
			if(qq==null)
				qq="";
			if(blood==null)
				blood="";
				if(sig==null)
					sig="";
			if(location==null)
				location="";
			Object[] str = new Object[]{id,phone,nickname,sex,qq,blood,sig,location,btime,statu};
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",userlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("alluser", dlist);
		}
	
		//msg="success";
		//return msg;
		return "user_table";
	}
	/**
	 * 获得运动常识列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toknow_table")
	public String toknow_table(Model model,HttpSession session,HttpServletRequest request){		
		String pageSize="10";
		List knowlist1 = new ArrayList();
		List dlist = new ArrayList();
		knowlist1=healthyequipmentservice.findAll();
		knowlist1.addAll(healthymuscleservice.findAll());
		knowlist1.addAll(healthyplaneservice.findAll());
		List knowlist = new ArrayList();
		knowlist=Utils.getPageList(request, knowlist1, pageSize);
		System.out.println(knowlist);
		if(knowlist.size()>0)
		for(int i=0;i<knowlist.size();i++){
			String attr="";
			String title="";
			String url="";
			String img="";
			String id="";
			Object[] str = null ;
			if(knowlist.get(i) instanceof HealthyEquipment){
				HealthyEquipment he = (HealthyEquipment) knowlist.get(i);
				id=String.valueOf(he.getEquipmentId());
				attr=he.getEquipmentAttr();
				title=he.getEquipmentName();
				url=he.getEquipmentUrl();
				img=he.getEquipmentImg();
				str = new Object[]{id,attr,title,url,img};
			}else if(knowlist.get(i) instanceof HealthyMuscle){
				HealthyMuscle hm = (HealthyMuscle) knowlist.get(i);
				id=String.valueOf(hm.getMuscleId());
				attr=hm.getMuscleAttr();
				title=hm.getMuscleName();
				url=hm.getMuscleUrl();
				img=hm.getMuscleImg();
				str = new Object[]{id,attr,title,url,img};
			}else if(knowlist.get(i) instanceof HealthyPlane){
				HealthyPlane hp = (HealthyPlane) knowlist.get(i);
						id=String.valueOf(hp.getPlaneId());
						attr=hp.getPlaneAttr();
						title=hp.getPlaneTitle();
						url=hp.getPlaneUrl();
						img=hp.getPlaneImg();
						str = new Object[]{id,attr,title,url,img};
			}
			
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
				model.addAttribute("allknow", dlist);
				model.addAttribute("allsize",knowlist1.size() );
				model.addAttribute("pagesize",pageSize);
		}
	
		return "know_table";
	}
	/**
	 * 初始化编辑运动常识页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit_Know" )
	public  String  toedit_Know(Model model,HttpSession session){
		String msg="fail";
		String str[] = eid.split(",");
		if(str[0].equals("器材百科")){
			HealthyEquipment he = (HealthyEquipment)healthyequipmentservice.findById(str[1]).get(0);
			if(session.getAttribute("admin")!=null)
			model.addAttribute("equipment", he);
		}	
		else if(str[0].equals("人体肌肉百科")){
				HealthyMuscle hm =(HealthyMuscle)healthymuscleservice.findById(str[1]).get(0);
				if(session.getAttribute("admin")!=null)
				model.addAttribute("muscle", hm);
		}
		else if(str[0].equals("健身计划推荐")){
			HealthyPlane hp = (HealthyPlane)healthyplaneservice.findById(str[1]).get(0);
			if(session.getAttribute("admin")!=null)
			model.addAttribute("plan", hp);
		}
		if(session.getAttribute("admin")!=null)
		model.addAttribute("nowtype", str[0]);
	
		return "edit_know";
		
	}
	@RequestMapping("/toaddKnow")
	public String toaddKnow(){
		return "add_know";
	}
	/**
	 * 添加健身常识
	 * @param type 类型
	 * @param name 标题
	 * @param img 图片
	 * @param url 连接
	 * @param request
	 * @return 页面
	 */
	@RequestMapping("/addKnow")
	public String addKnow(String type,String name,MultipartFile img,String url,HttpServletRequest request,HttpSession session){
		HealthyEquipment he = new HealthyEquipment();
		HealthyMuscle hm = new HealthyMuscle();
		HealthyPlane hp = new HealthyPlane();
		String path = request.getSession().getServletContext().getRealPath("photo");
		String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/photo/"; 
		String imgName = UUID.randomUUID().toString();
		File file = new File(path, imgName);
		File file1 = new File(path1, imgName);
		FileOutputStream fos=null;
        try {
        	fos = new FileOutputStream(file1);
        	InputStream is = img.getInputStream();
        	byte[] b = new byte[1024];
			while(is.read(b)!=-1){
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		 if(!file.exists()){  
			 file.mkdirs();  
	        } 
	        try {  		
	        	if(session.getAttribute("admin")!=null)
	            img.transferTo(file); 	
	         
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
		if(type.equals("器材百科")){
			he.setEquipmentAttr(type);
			he.setEquipmentName(name);
			he.setEquipmentImg("./photo/"+imgName);
			he.setEquipmentUrl(url);
			if(session.getAttribute("admin")!=null)
			healthyequipmentservice.add(he);
		}else 
			if(type.equals("人体肌肉百科")){
				hm.setMuscleAttr(type);
				hm.setMuscleName(name);
				hm.setMuscleImg("./photo/"+imgName);
				hm.setMuscleUrl(url);
				if(session.getAttribute("admin")!=null)
				healthymuscleservice.add(hm);
			}else 
				if(type.equals("健身计划推荐")){
					hp.setPlaneAttr(type);
					hp.setPlaneTitle(name);
					hp.setPlaneImg("./photo/"+imgName);
					hp.setPlaneUrl(url);
					if(session.getAttribute("admin")!=null)
					healthyplaneservice.add(hp);
				}
		return "redirect:/toknow_table";
	}
	/**
	 * 编辑健身常识
	 * @param type 类型
	 * @param name 标题
	 * @param img 图片
	 * @param url 连接
	 * @param request
	 * @return 页面
	 */
	@RequestMapping("/editKnow")
	public String editKnow(String type,String name,MultipartFile img,String url,HttpServletRequest request,HttpSession session){
		String path = request.getSession().getServletContext().getRealPath("photo");
		String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/photo/"; 
		String imgName = UUID.randomUUID().toString();
		File file = new File(path, imgName);
		File file1 = new File(path1, imgName);
		FileOutputStream fos=null;
        try {
        	fos = new FileOutputStream(file1);
        	InputStream is = img.getInputStream();
        	byte[] b = new byte[1024];
			while(is.read(b)!=-1){
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		 if(!file.exists()){  
			 file.mkdirs();  
	        } 
	        try {  
	        	if(session.getAttribute("admin")!=null)
	            img.transferTo(file); 	
	         
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
		if(type.equals("器材百科")){
			HealthyEquipment he = (HealthyEquipment) healthyequipmentservice.findById(eid.split(",")[1]).get(0);
			he.setEquipmentAttr(type);
			he.setEquipmentName(name);
			he.setEquipmentImg("./photo/"+imgName);
			he.setEquipmentUrl(url);
			if(session.getAttribute("admin")!=null)
			healthyequipmentservice.update(he);
		}else 
			if(type.equals("人体肌肉百科")){
				HealthyMuscle hm = (HealthyMuscle) healthymuscleservice.findById(eid.split(",")[1]).get(0);

				hm.setMuscleAttr(type);
				hm.setMuscleName(name);
				hm.setMuscleImg("./photo/"+imgName);
				hm.setMuscleUrl(url);
				if(session.getAttribute("admin")!=null)
				healthymuscleservice.update(hm);
			}else 
				if(type.equals("健身计划推荐")){
					HealthyPlane hp = (HealthyPlane) healthyplaneservice.findById(eid.split(",")[1]).get(0);

					hp.setPlaneAttr(type);
					hp.setPlaneTitle(name);
					hp.setPlaneImg("./photo/"+imgName);
					hp.setPlaneUrl(url);
					if(session.getAttribute("admin")!=null)
					healthyplaneservice.update(hp);
				}
		return "redirect:/toknow_table";
	}
	/**
	 * 删除健身常识
	 * @param id 健身常识ID
	 * @return 结果
	 */
	@RequestMapping("/deleteKnow")
	public @ResponseBody String  deleteKnow(String id,HttpSession session){
		String msg="fail";
		String str[] = id.split(",");
		if(session.getAttribute("admin")!=null){
		if(str[0].equals("器材百科"))
			healthyequipmentservice.delete(((HealthyEquipment)healthyequipmentservice.findById(str[1]).get(0)));
		else if(str[0].equals("人体肌肉百科"))
			healthymuscleservice.delete(((HealthyMuscle)healthymuscleservice.findById(str[1]).get(0)));
		else if(str[0].equals("健身计划推荐"))
			healthyplaneservice.delete(((HealthyPlane)healthyplaneservice.findById(str[1]).get(0)));
		msg="success";
		}
		return msg;
		
	}
	
	
	/**
	 * 获取运动推荐列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toadvice_table")
	public String toadvice_table(Model model,HttpSession session,HttpServletRequest request){
		List advicelist1 = new ArrayList();
		List dlist = new ArrayList();
		advicelist1=sportadviceservice.findAll();
		String pageSize="10";
		List advicelist = new ArrayList();
		advicelist=Utils.getPageList(request, advicelist1, pageSize);
		for(int i=0;i<advicelist.size();i++){
			String id="";
			String content="";
			String title="";
			String img="";
			String time="";
			Object[] str = null ;
				SportAdvice sa = (SportAdvice) advicelist.get(i);
						id=sa.getAdviceId();
						title=sa.getAdviceTitle();
						img=sa.getAdviceImg();
						content=sa.getAdviceContent();
						time=df.format(sa.getAdviceTime());
						str = new Object[]{id,title,img,content,time};
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",advicelist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("alladvice", dlist);
		}
		
		return "advice_table";
	}
	
	@RequestMapping("/toaddAdvice")
	public String toaddAdvice(){
		return "add_advice";
	}
	@RequestMapping("/addAdvice")
	public String addAdvice(String title, String content,MultipartFile img ,HttpServletRequest request,HttpSession session){
		SportAdvice sa = new SportAdvice();
		String path = request.getSession().getServletContext().getRealPath("img");
		String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/img/"; 
		String imgName = UUID.randomUUID().toString();
		File file = new File(path, imgName);
		File file1 = new File(path1, imgName);
		FileOutputStream fos=null;
        try {
        	fos = new FileOutputStream(file1);
        	InputStream is = img.getInputStream();
        	byte[] b = new byte[1024];
			while(is.read(b)!=-1){
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sa.setAdviceId(UUID.randomUUID().toString());
		sa.setAdviceContent(content.replaceAll("\r|\n", "   "));
		sa.setAdviceTitle(title);
		sa.setAdviceImg("./img/"+imgName);
		 if(!file.exists()){  
			 file.mkdirs();  
	        } 
	        try {  	
	        	if(session.getAttribute("admin")!=null)
	            img.transferTo(file); 	
	         
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        if(session.getAttribute("admin")!=null)
		sportadviceservice.add(sa);
		return "redirect:/toadvice_table";
	}
	
	/**
	 * 删除运动推荐
	 * @param id 运动推荐id
	 * @return 结果
	 */
	@RequestMapping("/deleteAdvice")
	public @ResponseBody String deleteAdvice(String id,HttpSession session){
		String msg="fail";
		if(session.getAttribute("admin")!=null)
		sportadviceservice.delete(((SportAdvice)sportadviceservice.findById(id).get(0)));	
		msg="success";
		return msg;
		
	}
	/**
	 * 获取运动项目列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toproject_table")
	public String toproject_table(Model model,HttpSession session,HttpServletRequest request){
		List projectlist1 = new ArrayList();
		List dlist = new ArrayList();
		String pageSize="10";
		projectlist1=sportprojectservice.findAll();
		List projectlist = new ArrayList();
		projectlist=Utils.getPageList(request, projectlist1, pageSize);
		for(int i=0;i<projectlist.size();i++){
			String title="";
			String img="";
			Object[] str = null ;
				SportProject sp = (SportProject) projectlist.get(i);
						title=sp.getProjectId();
						img=sp.getPorjectPic();
						str = new Object[]{title,img};
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",projectlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allproject", dlist);
		}
		
		return "project_table";
	}
	
	
	/**
	 * 查找运动项目是否已存在
	 * @param id 项目ID
	 * @return 结果
	 */
	@RequestMapping("/findProject")
	public @ResponseBody String findProject(String id){
		
		String msg="fail";
		if(sportprojectservice.find(id).size()>0){
			msg="fail";
			return msg;
		}
			
		else if(sportprojectservice.find(id).size()==0){
			msg="success";
		System.out.println(sportprojectservice.find(id).size());
		return msg;
		}
		return msg;
	}
	
	
	/**
	 * 添加加一个运动项目
	 * @param id 名称
	 * @param img	图片
	 * @return
	 */
	@RequestMapping("/addProject")
	public  String addProject(String id,MultipartFile img ,HttpServletRequest request,HttpSession session){
		String msg="fail";
		String path = request.getSession().getServletContext().getRealPath("photo");
		String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/photo/"; 
		String imgName = UUID.randomUUID().toString();
		File file = new File(path, imgName);
		File file1 = new File(path1, imgName);
		FileOutputStream fos=null;
        try {
        	fos = new FileOutputStream(file1);
        	InputStream is = img.getInputStream();
        	byte[] b = new byte[1024];
			while(is.read(b)!=-1){
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SportProject sp = new SportProject();
		sp.setPorjectPic("./photo/"+imgName);
		sp.setProjectId(id);
		 if(!file.exists()){  
			 file.mkdirs();  
	        } 
	        try {  	
	        	if(session.getAttribute("admin")!=null)
	            img.transferTo(file); 	
	         
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println("好"+"_--"+sportprojectservice.find(id).size());
		if(sportprojectservice.find(id).size()==0){
			if(session.getAttribute("admin")!=null)
			sportprojectservice.add(sp);;
			
			return "redirect:/toproject_table";
		}else{
			return "redirect:/toaddProject";
		}
		
	}
	/**
	 * 修改运动项目图片
	 * @param img
	 * @param request
	 * @return
	 */
	@RequestMapping("/editProject")
	public  String editProject(MultipartFile img ,HttpServletRequest request,HttpSession session){
		String msg="fail";
		SportProject sp = sportprojectservice.find(eid).get(0);
		if(img!=null){
		String path = request.getSession().getServletContext().getRealPath("photo");
		String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/photo/"; 
		String imgName = UUID.randomUUID().toString();
		File file = new File(path, imgName);
		File file1 = new File(path1, imgName);
		FileOutputStream fos=null;
        try {
        	fos = new FileOutputStream(file1);
        	InputStream is = img.getInputStream();
        	byte[] b = new byte[1024];
			while(is.read(b)!=-1){
				fos.write(b);
			}
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		sp.setPorjectPic("./photo/"+imgName);
		if(session.getAttribute("admin")!=null)
		sportprojectservice.update(sp);;
		
		 if(!file.exists()){  
			 file.mkdirs();  
	        } 
	        try {  		
	        	if(session.getAttribute("admin")!=null)
	            img.transferTo(file); 	
	         
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  	     
		}
		
		return "redirect:/toproject_table";
	}
	
	
	/**
	 * 前往添加运动项目页面
	 * @return 添加页面
	 */
	@RequestMapping("/toaddProject")
	public String toaddProject(){
		return "add_project";
	}
	/**
	 * 删除运动项目
	 * @param id 项目id
	 * @return 结果
	 */
	@RequestMapping("/deleteProject")
	public @ResponseBody String deleteProject(String id,HttpSession session){
		String msg="fail";
		if(session.getAttribute("admin")!=null)
		sportprojectservice.delete(id);
		msg="success";
		return msg;
	}
	
	
	/**
	 * 初始化所有用户订单
	 * @param kind
	 * @param diff
	 * @param model
	 * @return
	 */
	@RequestMapping("/toorder_table")
	public  String toorder_table(String kind,String diff,Model model,HttpSession session,HttpServletRequest request){
		
		PlaceOrder order = new PlaceOrder();
		UserMain user = new UserMain();
		UserDetail ud = new UserDetail();
		List olist = new ArrayList();
		String pageSize="10";
		List<PlaceOrder> orderlist1 = new ArrayList<PlaceOrder>();
		List<PlaceOrder> orderlist = new ArrayList<PlaceOrder>();
			orderlist1=placeorderservice.findAll();
			orderlist=Utils.getPageList(request, orderlist1, pageSize);
		for(int i=0;i<orderlist.size();i++){
			order=orderlist.get(i);
			String oid=order.getOrderId();
			String uid = order.getUserId();
			user=usermainservice.findId(uid);
			ud = userdetailservice.findByUserId(order.getUserId());
			String sid = stadiummainservice.findbyId(order.getStadiumId()).getUserMain().getUserId();
			String uphone= ud.getUserTel();
			String sphone= userdetailservice.findByUserId(sid).getUserTel();
			String unickname= user.getUserNickname();
			String snickname=usermainservice.findId(sid).getUserNickname();
			String price = String.valueOf(order.getOrderPrice());
			String ordertime = df.format(order.getOrderTime());
			String status = order.getOrderStatus();
			Object[] str = new Object[]{oid,unickname,uphone,snickname,sphone,price,ordertime,status};
			olist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",orderlist1.size() );
			model.addAttribute("pagesize",pageSize);
		model.addAttribute("allorder", olist);
		
		}
		return "order_table";
	}
	/**
	 * 删除订单
	 * @param orderid
	 * @return 
	 */
	@RequestMapping("/deleteOrder")
	public @ResponseBody String deleteOrder(String orderid,HttpSession session){
		String msg="fail";
		System.out.println(orderid);
		PlaceOrder po = new PlaceOrder();
		po=placeorderservice.findById(orderid);
		if(session.getAttribute("admin")!=null)
		placeorderservice.delete(po);
		msg="success";
		return msg;
		
	}
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有用户的订单
	 */
	@RequestMapping(value="/getorder_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getorder_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		PlaceOrder order = new PlaceOrder();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> olist = new ArrayList<String[]>();
		List<PlaceOrder> orderlist = new ArrayList<PlaceOrder>();
		if(kind.equals("month")){
			orderlist=placeorderservice.findByDiffMonth(diff);	
		}else if(kind.equals("week")){
			orderlist=placeorderservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
		}else	if(kind.equals("day"))	
			orderlist=placeorderservice.findByDiffDay(diff);
		else if(kind.equals("appoint")){
			user1=(UserMain) usermainservice.findname(diff).get(0);
			orderlist=placeorderservice.findByUserId(user1.getUserId());
		}
		else if(kind.equals("all")) orderlist=placeorderservice.findAll();
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(orderlist.size());
		for(int i=0;i<orderlist.size();i++){
			order=orderlist.get(i);
			String oid=order.getOrderId();
			String uid = order.getUserId();
			user=usermainservice.findId(uid);
			ud = userdetailservice.findByUserId(order.getUserId());
			String sid = stadiummainservice.findbyId(order.getStadiumId()).getUserMain().getUserId();
			String uphone= ud.getUserTel();
			String sphone= userdetailservice.findByUserId(sid).getUserTel();
			String unickname= user.getUserNickname();
			String snickname=usermainservice.findId(sid).getUserNickname();
			String price = String.valueOf(order.getOrderPrice());
			String ordertime = df.format(order.getOrderTime());
			String status = order.getOrderStatus();
			String[] str = new String[]{oid,unickname,uphone,snickname,sphone,price,ordertime,status};
			olist.add(str);
		}
		String res="";
		if(orderlist.size()!=0){
			for(int i =0;i<olist.size()-1;i++){
			res=res+ Utils.getStr(olist.get(i))+"*"; 
		}
		
		res=res+ Utils.getStr(olist.get(olist.size()-1));
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allorder", olist);
		msgdata=res;
		}
		
		return msgdata;
	}
	/**
	 * 初始化所有圈子
	 * @param model
	 * @return
	 */
	@RequestMapping("/toquanzi_table")
	public String getquanzi_table(Model model,HttpSession session,HttpServletRequest request){
		HealthyShow show = new HealthyShow();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		String pageSize="10";
		List<String[]> slist = new ArrayList<String[]>();
		List<HealthyShow> showlist1 = new ArrayList<HealthyShow>();
		List<HealthyShow> showlist = new ArrayList<HealthyShow>();
		showlist1=healthyshowservice.findall();
		showlist=Utils.getPageList(request, showlist1, pageSize);
		System.out.println(showlist.size());
		for(int i=0;i<showlist.size();i++){
			show=showlist.get(i);
			String unickname = show.getShowUser();
			String rnumber = String.valueOf(showreplyservice.findByShow(show).size());
			user=(UserMain) usermainservice.findname(unickname).get(0);
			ud = userdetailservice.findByUserId(user.getUserId());
			String sid = show.getShowId();
			String scontent=show.getShowContent().replaceAll("\r|\n", "   ");
			String uphone= ud.getUserTel();
			String showtime = df.format(show.getShowTime());
			String[] str = new String[]{sid,unickname,uphone,scontent,showtime,rnumber};
			slist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",showlist1.size() );
			model.addAttribute("pagesize",pageSize);
				model.addAttribute("sinit", slist);
		}
	
		return "quanzi_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有用户的圈子
	 */
	@RequestMapping(value="/getquanzi_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getquanzi_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		HealthyShow show = new HealthyShow();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> slist = new ArrayList<String[]>();
		List<HealthyShow> showlist = new ArrayList<HealthyShow>();
		if(kind.equals("month")){
			showlist=healthyshowservice.findByDiffMonth(diff);	
		}else if(kind.equals("week")){
			showlist=healthyshowservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
		}else	if(kind.equals("day"))	
			showlist=healthyshowservice.findByDiffDay(diff);
		else if(kind.equals("appoint")){
			
			showlist=healthyshowservice.findByUserId(diff);
		}
		else if(kind.equals("all")) showlist=healthyshowservice.findall();
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(showlist.size());
		for(int i=0;i<showlist.size();i++){
			show=showlist.get(i);
			String unickname = show.getShowUser();
			String rnumber = String.valueOf(showreplyservice.findByShow(show).size());
			user=(UserMain) usermainservice.findname(unickname).get(0);
			ud = userdetailservice.findByUserId(user.getUserId());
			String sid = show.getShowId();
			String scontent=show.getShowContent().replaceAll("\r|\n", "   ");
			String uphone= ud.getUserTel();
			String showtime = df.format(show.getShowTime());
			String[] str = new String[]{sid,unickname,uphone,scontent,showtime,rnumber};
			slist.add(str);
		}
		String res="";
		if(showlist.size()!=0){
			for(int i =0;i<slist.size()-1;i++){
			res=res+ Utils.getStr(slist.get(i))+"*"; 
		}
		res=res+ Utils.getStr(slist.get(slist.size()-1));
		}
		if(session.getAttribute("admin")!=null){
		model.addAttribute("allshow", slist);
		msgdata=res;
		}
		return msgdata;
	}
	/**
	 * 初始化所有圈子回复
	 * @param model
	 * @return
	 */
	@RequestMapping("/toquanzi_reply_table")
	public String toquanzi_reply_table(Model model,HttpSession session,HttpServletRequest request){
		ShowReply sreply = new ShowReply();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		String pageSize="10";
		List<String[]> srlist = new ArrayList<String[]>();
		List<ShowReply> showreplylist1 = new ArrayList<ShowReply>();
		showreplylist1=showreplyservice.findAll();
		List<ShowReply> showreplylist =Utils.getPageList(request, showreplylist1, pageSize);
		System.out.println(showreplylist.size());
		for(int i=0;i<showreplylist.size();i++){
			sreply=showreplylist.get(i);
			HealthyShow show = sreply.getHealthyShow();
			String showcontent = show.getShowContent().replaceAll("\r|\n", "   ");
			String showuser=show.getShowUser();
			String showtime = df.format(show.getShowTime());
			String relpyuser = sreply.getReplyUser();
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(sreply.getReplyUser()).get(0)).getUserId());
			String rid = sreply.getReplyId();
			String replycontent=sreply.getReplyContent().replaceAll("\r|\n", "   ");
			String replytime = df.format(sreply.getReplyTime());
			String[] str = new String[]{rid,replycontent,relpyuser,replytime,showcontent,showuser,showtime,};
			srlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",showreplylist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("srinit", srlist);
		}
		
		return "quanzi_reply_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 圈子的所有回复
	 */
	@RequestMapping(value="/getquanzi_reply_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getquanzi_reply_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		ShowReply sreply = new ShowReply();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> srlist = new ArrayList<String[]>();
		List<ShowReply> showreplylist = new ArrayList<ShowReply>();
		if(kind.equals("month")){
			showreplylist=showreplyservice.findByDiffMonth(diff);	
		}else if(kind.equals("week")){
			showreplylist=showreplyservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
		}else	if(kind.equals("day"))	
			showreplylist=showreplyservice.findByDiffDay(diff);
		else if(kind.equals("appoint")){
		
			showreplylist=showreplyservice.findByUserId(diff);
		}
		else if(kind.equals("all")) showreplylist=showreplyservice.findAll();
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(showreplylist.size());
		for(int i=0;i<showreplylist.size();i++){
			sreply=showreplylist.get(i);
			HealthyShow show = sreply.getHealthyShow();
			String showcontent = show.getShowContent().replaceAll("\r|\n", "   ");
			String showuser=show.getShowUser();
			String showtime = df.format(show.getShowTime());
			String relpyuser = sreply.getReplyUser();
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(sreply.getReplyUser()).get(0)).getUserId());
			String rid = sreply.getReplyId();
			String replycontent=sreply.getReplyContent().replaceAll("\r|\n", "   ");
			String replytime = df.format(sreply.getReplyTime());
			String[] str = new String[]{rid,replycontent,relpyuser,replytime,showcontent,showuser,showtime,};
			srlist.add(str);
		}
		String res="";
		if(showreplylist.size()!=0){
			for(int i =0;i<srlist.size()-1;i++){
			res=res+ Utils.getStr(srlist.get(i))+"*"; 
		}
		
		res=res+ Utils.getStr(srlist.get(srlist.size()-1));
		}
		if(session.getAttribute("admin")!=null){
		model.addAttribute("allshowreply", srlist);
		msgdata=res;
	}
		return msgdata;
	}
	/**
	 * 初始化所有场馆评论
	 * @param model
	 * @return
	 */
	@RequestMapping("/tocomment_table")
	public String tocomment_table(Model model,HttpSession session,HttpServletRequest request){
		StadiumComment comment = new StadiumComment();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		String pageSize="10";
		List<String[]> clist = new ArrayList<String[]>();
		List<StadiumComment> commentlist1 = new ArrayList<StadiumComment>();
		List<StadiumComment> commentlist = new ArrayList<StadiumComment>();
		 commentlist1=stadiumcommentservice.findAll();
		commentlist=Utils.getPageList(request, commentlist1, pageSize);
		System.out.println(commentlist.size());
		for(int i=0;i<commentlist.size();i++){
			comment=commentlist.get(i);
			String commentuser = comment.getCommentUser();
			String replynumber = String.valueOf(commentreplyservice.findReply(comment).size());
			user=(UserMain) usermainservice.findname(comment.getCommentUser()).get(0);
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(comment.getCommentUser()).get(0)).getUserId());
			String cid = comment.getCommentId();
			String commentcontent=comment.getCommentContent().replaceAll("\r|\n", "   ");
			String userphone= ud.getUserTel();
			String commentstadium = comment.getStadiumMain().getStadiumName();
			String commenttime = df.format(comment.getCommentTime());
			String[] str = new String[]{cid,commentcontent,commentuser,userphone,commentstadium,commenttime,replynumber};
			clist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",commentlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("cinit", clist);
		}
		
		return "comment_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有场馆评论
	 */
	@RequestMapping(value="/getcomment_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getcomment_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		StadiumComment comment = new StadiumComment();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> clist = new ArrayList<String[]>();
		List<StadiumComment> commentlist = new ArrayList<StadiumComment>();
		if(kind.equals("month")){
			commentlist=stadiumcommentservice.findByDiffMonth(diff);	
		}else if(kind.equals("week")){
			commentlist=stadiumcommentservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
		}else	if(kind.equals("day"))	
			commentlist=stadiumcommentservice.findByDiffDay(diff);
		else if(kind.equals("appoint")){
			
			commentlist=stadiumcommentservice.findByUserId(diff);
		}
		else if(kind.equals("all")) commentlist=stadiumcommentservice.findAll();
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(commentlist.size());
		for(int i=0;i<commentlist.size();i++){
			comment=commentlist.get(i);
			String commentuser = comment.getCommentUser();
			String replynumber = String.valueOf(commentreplyservice.findReply(comment).size());
			user=(UserMain) usermainservice.findname(comment.getCommentUser()).get(0);
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(comment.getCommentUser()).get(0)).getUserId());
			String cid = comment.getCommentId();
			String commentcontent=comment.getCommentContent().replaceAll("\r|\n", "   ");
			String userphone= ud.getUserTel();
			String commentstadium = comment.getStadiumMain().getStadiumName();
			String commenttime = df.format( comment.getCommentTime());
			String[] str = new String[]{cid,commentcontent,commentuser,userphone,commentstadium,commenttime,replynumber};
			clist.add(str);
		}
		String res="";
		if(commentlist.size()!=0){
			for(int i =0;i<clist.size()-1;i++){
				res=res+ Utils.getStr(clist.get(i))+"*"; 
			}
			
			res=res+ Utils.getStr(clist.get(clist.size()-1));	
		}
		if(session.getAttribute("admin")!=null){
		model.addAttribute("allcomment", clist);
		msgdata=res;
		}
		return msgdata;
	}
	/**
	 * 初始化所有场馆评论回复
	 * @param model
	 * @return
	 */
	@RequestMapping("/tocomment_reply_table")
	public String tocomment_reply_table(HttpServletRequest request,Model model,HttpSession session){
		CommentReply creply = new CommentReply();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		String pageSize="10";
		List<String[]> crlist = new ArrayList<String[]>();
		List<CommentReply> commentreplylist1 = new ArrayList<CommentReply>();
		commentreplylist1=commentreplyservice.findAll();
		List<CommentReply> commentreplylist = new ArrayList<CommentReply>();
		commentreplylist=Utils.getPageList(request, commentreplylist1, pageSize);
		System.out.println(commentreplylist.size());
		for(int i=0;i<commentreplylist.size();i++){
			creply=commentreplylist.get(i);
			StadiumComment sc = creply.getStadiumComment();
			String commentcontent = sc.getCommentContent().replaceAll("\r|\n", "   ");
			String commentuser=sc.getCommentUser();
			String commenttime = df.format(sc.getCommentTime());
			String commentstadium = sc.getStadiumMain().getStadiumName();
			String relpyuser = creply.getReplyUser();
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(creply.getReplyUser()).get(0)).getUserId());
			String rid = creply.getReplyId();
			String replycontent=creply.getReplyContent().replaceAll("\r|\n", "   ");
			String uphone= ud.getUserTel();
			String unickname= user.getUserNickname();
			String replytime = df.format(creply.getReplyTime());
			String[] str = new String[]{rid,replycontent,relpyuser,replytime,commentcontent,commentuser,commentstadium,commenttime,};
			crlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",commentreplylist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("crinit", crlist);
		}
	
		return "comment_reply_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有场馆评论回复
	 */
	@RequestMapping(value="/getcomment_reply_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getcomment_reply_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		CommentReply creply = new CommentReply();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> crlist = new ArrayList<String[]>();
		List<CommentReply> commentreplylist = new ArrayList<CommentReply>();
		if(kind.equals("month")){
			commentreplylist=commentreplyservice.findByDiffMonth(diff);	
		}else if(kind.equals("week")){
			commentreplylist=commentreplyservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
		}else	if(kind.equals("day"))	
			commentreplylist=commentreplyservice.findByDiffDay(diff);
		else if(kind.equals("appoint")){
			//user1=(UserMain) usermainservice.findname(diff).get(0);
			commentreplylist=commentreplyservice.findByUserId(diff);
		}
		else if(kind.equals("all")) commentreplylist=commentreplyservice.findAll();
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(commentreplylist.size());
		for(int i=0;i<commentreplylist.size();i++){
			creply=commentreplylist.get(i);
			StadiumComment sc = creply.getStadiumComment();
			String commentcontent = sc.getCommentContent().replaceAll("\r|\n", "   ");
			String commentuser=sc.getCommentUser();
			String commenttime = df.format(sc.getCommentTime());
			String commentstadium = sc.getStadiumMain().getStadiumName();
			String relpyuser = creply.getReplyUser();
			ud = userdetailservice.findByUserId(((UserMain)usermainservice.findname(creply.getReplyUser()).get(0)).getUserId());
			String rid = creply.getReplyId();
			String replycontent=creply.getReplyContent().replaceAll("\r|\n", "   ");
			String uphone= ud.getUserTel();
			String unickname= user.getUserNickname();
			String replytime = df.format(creply.getReplyTime());
			String[] str = new String[]{rid,replycontent,relpyuser,replytime,commentcontent,commentuser,commentstadium,commenttime,};
			crlist.add(str);
		}
		String res="";
		if(commentreplylist.size()!=0){
			for(int i =0;i<crlist.size()-1;i++){
				res=res+ Utils.getStr(crlist.get(i))+"*"; 
			}
			
			res=res+ Utils.getStr(crlist.get(crlist.size()-1));
		}
		if(session.getAttribute("admin")!=null){
		model.addAttribute("allcommentreply", crlist);
		msgdata=res;
		}
		return msgdata;
	}
	
	@RequestMapping("/deleteShow")
	public @ResponseBody String deleteShow(String showid ,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("admin")!=null)
		healthyshowservice.delete(healthyshowservice.findOne(showid));
		msg="success";
		return msg;
	}
	@RequestMapping("/deleteShowReply")
	public @ResponseBody String deleteShowReply(String replyid ,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("admin")!=null)
		showreplyservice.delete(showreplyservice.findById(replyid));
		msg="success";
		return msg;
	}
	@RequestMapping("/deleteComment")
	public @ResponseBody String deleteComment(String commentid,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("admin")!=null)
		stadiumcommentservice.delete(stadiumcommentservice.findById(commentid));
		msg="success";
		return msg;
	}
	@RequestMapping("/deleteCommentReply")
	public @ResponseBody String deleteCommentReply(String replyid,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("admin")!=null)
		commentreplyservice.delete(commentreplyservice.findById(replyid).get(0));
		msg="success";
		return msg;
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
	/**
	 * 初始化所有场馆
	 * @param model
	 * @return
	 */
	@RequestMapping("/tostadium_table")
	public String tostadium_table(HttpServletRequest request,Model model,HttpSession session){
		List stadiumlist1 = new ArrayList();
		List dlist = new ArrayList();
		String pageSize="10";
		stadiumlist1=stadiummainservice.findAll();
		List stadiumlist = new ArrayList();
		stadiumlist=Utils.getPageList(request, stadiumlist1, pageSize);
		for(int i=0;i<stadiumlist.size();i++){
			String id="";
			String type="";
			String name="";
			String nickname="";
			String phone="";
			String price="0-0";
			String introduce="";
			String img="";
			String location="";
			Object[] str = null ;
			StadiumMain sm = (StadiumMain) stadiumlist.get(i);
			id=sm.getStadiumId();
			type=sm.getSportProject().getProjectId();
			name=sm.getStadiumName();
			nickname=sm.getUserMain().getUserNickname();
			phone=sm.getUserMain().getUserDetail().getUserTel();
			Set set = sm.getStadiumPlaces();
			List<Integer> in = new ArrayList<Integer>();
			java.util.Iterator<StadiumPlace> it = set.iterator();
			while(it.hasNext()){
				in.add(Integer.parseInt(it.next().getPlacePrice()));
			}
			if(set.size()>0)
			price=String.valueOf(Utils.getMin(in))+"-"+String.valueOf(Utils.getMax(in));
			introduce = sm.getStadiumIntroduction();
			if(introduce!=null)
			introduce = sm.getStadiumIntroduction().replaceAll("\r|\n", "   ");
			img=sm.getStadiumPhoto();
			location=sm.getStadiumLocation();
			str = new Object[]{id,type,name,nickname,phone,price,introduce,img,location};		
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",stadiumlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allstadium", dlist);
		}
		
		return "stadium_table";
	}
	@RequestMapping("/deleteStadium")
	public @ResponseBody String deleteStadium(String id,HttpSession session){
		String msg ="fail";
		if(session.getAttribute("admin")!=null){
			
				stadiummainservice.delete(stadiummainservice.findbyId(id));
		}

		msg="success";
		return msg;
	}
	
	/**
	 * 根据关键字搜索场馆
	 * @param diff
	 * @param model
	 * @return 场馆数据
	 */
	@RequestMapping(value="/getstadium_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getstadium_table(String diff,Model model,HttpSession session){
		String msgdata="fail";
		List stadiumlist = new ArrayList();
		List<String[]> dlist = new ArrayList<String[]>();
		if(diff.equals("全部"))
			stadiumlist=stadiummainservice.findAll();
		else
		stadiumlist=stadiummainservice.findByName(diff);
		for(int i=0;i<stadiumlist.size();i++){
			String id="";
			String type="";
			String name="";
			String nickname="";
			String phone="";
			String price="";
			String introduce="";
			String img="";
			String location="";
			String[] str = null ;
			StadiumMain sm = (StadiumMain) stadiumlist.get(i);
			id=sm.getStadiumId();
			type=sm.getSportProject().getProjectId();
			name=sm.getStadiumName();
			nickname=sm.getUserMain().getUserNickname();
			phone=sm.getUserMain().getUserDetail().getUserTel();
			Set set = sm.getStadiumPlaces();
			List<Integer> in = new ArrayList<Integer>();
			java.util.Iterator<StadiumPlace> it = set.iterator();
			while(it.hasNext()){
				in.add(Integer.parseInt(it.next().getPlacePrice()));
			}
			if(in.size()>0)
			price=String.valueOf(Utils.getMin(in))+"-"+String.valueOf(Utils.getMax(in));
			introduce = sm.getStadiumIntroduction();
			if(introduce!=null)
			introduce = sm.getStadiumIntroduction().replaceAll("\r|\n", "   ");
			img=sm.getStadiumPhoto();
			location=sm.getStadiumLocation();
			str = new String[]{id,type,name,nickname,phone,price,introduce,img,location};		
			dlist.add(str);
		}
		String res="";
		if(stadiumlist.size()!=0){
			for(int i =0;i<dlist.size()-1;i++){
			res=res+ Utils.getStr(dlist.get(i))+"*"; 
		}
		res=res+ Utils.getStr(dlist.get(dlist.size()-1));
		}
	//	model.addAttribute("allshowreply", dlist);
		if(session.getAttribute("admin")!=null)
		msgdata=res;
		return msgdata;
	
	}
	/**
	 * 初始化场地列表
	 * @param model
	 * @return 场地数据
	 */
	@RequestMapping("/toplace_table")
	public String toplace_table(Model model,HttpSession session,HttpServletRequest request){
		List placelist1 = new ArrayList();
		List dlist = new ArrayList();
		String pageSize="10";
		List placelist = new ArrayList();
		placelist1=stadiummplaceservice.findAll();
		placelist=Utils.getPageList(request, placelist1, pageSize);
		for(int i=0;i<placelist.size();i++){
			String id="";
			String type="";
			String name="";
			String price="";	
			String img="";
			String location="";
			Object[] str = null ;
			StadiumPlace sp = (StadiumPlace) placelist.get(i);
			id=sp.getPlaceId();
			type=sp.getStadiumMain().getStadiumName();
			name=sp.getPlaceName();
			price=sp.getPlacePrice();
			img=sp.getPlacePhoto();
			location=sp.getPlaceLocation();
			str = new Object[]{id,name,price,type,img,location};		
			dlist.add(str);
		}
		if(session.getAttribute("admin")!=null){
			model.addAttribute("allsize",placelist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allplace", dlist);
		}
	
		return "place_table";
	}
	/**
	 * 通过关键词搜索场地
	 * @param diff
	 * @param model
	 * @return 场地数据
	 */
	@RequestMapping(value="/getplace_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getplace_table(String diff,Model model,HttpSession session){
		String msgdata="fail";
		List placelist = new ArrayList();
		List<String[]> dlist = new ArrayList<String[]>();
		if(diff.equals("全部"))	
		placelist=stadiummplaceservice.findAll();
		else 
			placelist=stadiummplaceservice.findByname(diff);
		for(int i=0;i<placelist.size();i++){
			String id="";
			String type="";
			String name="";
			String price="";	
			String img="";
			String location="";
			String[] str = null ;
			StadiumPlace sp = (StadiumPlace) placelist.get(i);
			id=sp.getPlaceId();
			type=sp.getStadiumMain().getStadiumName();
			name=sp.getPlaceName();
			price=sp.getPlacePrice();
			img=sp.getPlacePhoto();
			location=sp.getPlaceLocation();
			str = new String[]{id,name,type,price,img,location};		
			dlist.add(str);
		}
		String res="";
		if(placelist.size()!=0){
			for(int i =0;i<dlist.size()-1;i++){
			res=res+ Utils.getStr(dlist.get(i))+"*"; 
		}
		res=res+ Utils.getStr(dlist.get(dlist.size()-1));
		}
		//model.addAttribute("allshowreply", dlist);
		if(session.getAttribute("admin")!=null){
			
		}
		msgdata=res;
		return msgdata;
	
	}
	@RequestMapping("/deletePlace")
	public @ResponseBody String deletePlace(String id,HttpSession session){
			String msg="fail";
			if(session.getAttribute("admin")!=null){
			stadiummplaceservice.delete(stadiummplaceservice.findbyid(id));
			msg="success";
		}
		return msg;
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
	public @ResponseBody String deleteUser(String userid,HttpSession session){
		String msg="fail";
		System.out.println("这是id：：："+userid);
		JSONArray j = new JSONArray();
		j.add(1);
		user1=usermainservice.findId(userid);
		if(session.getAttribute("admin")!=null)
		usermainservice.delete(user1);
		msg="success";
		return msg;
	}
	
	
	/////增删运动项目/////
	/*
	 * 添加场馆
	 */
//	List<String> list = new ArrayList<String>();
//	for(int i=0;i<sportprojectservice.findAll().size();i++){
//		list.add(sportprojectservice.findAll().get(i).getProjectId());
//	}	model.addAttribute("type", list);
	@RequestMapping("/addSport")
	public String addSport(SportProject sportproject,HttpSession session){
		if(session.getAttribute("admin")!=null)
		sportprojectservice.add(sportproject);
		return "success";
	}
	@RequestMapping("/deleteSport")
	public String deleteSport(String id,HttpSession session){
		if(session.getAttribute("admin")!=null)
		sportprojectservice.delete(id);
		return "success";
	}
}
