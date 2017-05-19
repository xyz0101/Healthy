package com.Healthy.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Healthy.interpoter.Token;
import com.Healthy.model.CommentReply;
import com.Healthy.model.HealthyShow;
import com.Healthy.model.Page;
import com.Healthy.model.PlaceOrder;
import com.Healthy.model.ShowReply;
import com.Healthy.model.SportAdvice;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.model.UserOperate;
import com.Healthy.model.UserPic;
import com.Healthy.service.CommentReplyService;
import com.Healthy.service.HealthyEquipmentService;
import com.Healthy.service.HealthyMuscleService;
import com.Healthy.service.HealthyPlaneService;
import com.Healthy.service.HealthyShowService;
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
import com.util.Mycompare;
import com.util.MycompareTime;
import com.util.MycompareTimeReply;
import com.util.Utils;
/**
 * 运动吧用户部分
 * @author 周锦
 *
 */
@Controller
@SessionAttributes(value={"user1"})
public class UserMainController {
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
	private SportProjectService sportprojectservice;
	@Autowired
	private HealthyShowService healthyshowservice;
	@Autowired
	private ShowReplyService showreplyservice;
	@Autowired
	private StadiumCommentService stadiumcommentservice;
	@Autowired
	private PlaceOrderService placeorderservice;
	@Autowired
	private SportAdviceService sportadviceservice;
	private String spid;
	private String stid;
	private PlaceOrder po;
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private List<Serializable> orderlist = new ArrayList<Serializable>();
			//启动时打开主页
			@RequestMapping({ "/", "" })
			public String sport(Model model){
				model.addAttribute("advice", (SportAdvice)sportadviceservice.findAll().get(0));
				ArrayList<StadiumMain> stalist = new ArrayList<StadiumMain>(); 
				stalist=  (ArrayList<StadiumMain>) stadiummainservice.findAll();
				for(int i=0;i<stalist.subList(0, 4).size();i++){
					StadiumMain sm = stalist.get(i);
					Set set = sm.getStadiumPlaces();
					String price="";
					List<Integer> in = new ArrayList<Integer>();
					java.util.Iterator<StadiumPlace> it = set.iterator();
					while(it.hasNext()){
						in.add(Integer.parseInt(it.next().getPlacePrice()));
					}
					if(set.size()>0)
					 price=String.valueOf(Utils.getMin(in))+"-"+String.valueOf(Utils.getMax(in));
					sm.setStadiumPrice(price);
				}
				
				
				model.addAttribute("beststadium",stalist);
				return "sport";
			}
			@RequestMapping("/tosport")
			public String tosport(Model model){
				model.addAttribute("advice", (SportAdvice)sportadviceservice.findAll().get(0));
				ArrayList<StadiumMain> stalist = new ArrayList<StadiumMain>(); 
				stalist=  (ArrayList<StadiumMain>) stadiummainservice.findAll();
				for(int i=0;i<stalist.subList(0, 4).size();i++){
					StadiumMain sm = stalist.get(i);
					Set set = sm.getStadiumPlaces();
					String price="";
					List<Integer> in = new ArrayList<Integer>();
					java.util.Iterator<StadiumPlace> it = set.iterator();
					while(it.hasNext()){
						in.add(Integer.parseInt(it.next().getPlacePrice()));
					}
					if(set.size()>0)
					 price=String.valueOf(Utils.getMin(in))+"-"+String.valueOf(Utils.getMax(in));
					sm.setStadiumPrice(price);
				}
				
				
				model.addAttribute("beststadium",stalist);
				return "sport";
			}
			
	@RequestMapping("/Register")
		public String register(UserMain user,UserDetail userdetail,UserOperate useroperate,UserPic userpic
				){
		String s =UUID.randomUUID().toString();
		user.setUserId(s);
		user.setUserStatus("普通用户");
		if(usermainservice.findname(user.getUserNickname()).size()==0){
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
		}
		
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
			model1.setViewName("redirect:/tosport");
			model.addAttribute("user1", user);
			model.addAttribute("pic", user.getUserPic());
		}else{
			model1.setViewName("redirect:/tologin?status=1");
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
			public @ResponseBody String findname1(String name){				
			String msg="";
				int size =usermainservice.findname(name).size();
				System.out.println("有没有：：：："+size);
						System.out.println(name);
				if(size!=0){
					System.out.println(name+"   "+((UserMain) usermainservice.findname(name).get(0)).getUserPassword());	
					msg= "have";
				}else 
				msg="none";
				return msg;
			}	
			@RequestMapping("/findphone")
			public @ResponseBody String findphone(String phone){				
			String msg="";
				int size =userdetailservice.findByUserPhone(phone).size();
				System.out.println("有没有：：：："+size);
						System.out.println(phone);
				if(size!=0){
					System.out.println(phone+"   "+( userdetailservice.findByUserPhone(phone).get(0)));	
					msg= "have";
				}else 
				msg="none";
				return msg;
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
			public String tosport_gym(HttpServletRequest request,Model model){
				
				
				String tid=request.getParameter("id");
				System.out.println(tid);
				System.out.println("-------------");
				
				String id = null;
				try {
					//参数转码
					id = new String(tid.getBytes("iso-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				System.out.println(id);
				
				String page=request.getParameter("page");
				String pageSize="12";
				if(page==null){
					page="1";
				}
				Page p = new Page("stadium_main", pageSize, page, "stadium_id","project_id",id);
				List list = stadiummainservice.findWithPage(p);
				model.addAttribute("spid", id);
				model.addAttribute("proj", list);
				System.out.println(id);
				model.addAttribute("number",stadiummainservice.findbySpId(sportprojectservice.find(id).get(0)).size());
				model.addAttribute("psize",pageSize );
				model.addAttribute("type", id);
				return "sport_gym";
				
			}
			@SuppressWarnings("deprecation")
			@RequestMapping("/toOrderSubmit")
			public @ResponseBody String toOrderSubmit(HttpSession session, Model model,String stadiumplace,String date,
					String time,String interval,String number,String price){
				String msg="error";
				String stid = "";
				UserMain user = (UserMain) session.getAttribute("user1");
				System.out.println("user-----"+user);
				String splace="";
				if(user!=null){
					String userid = user.getUserId();
					System.out.println("StadiumPlace--"+stadiumplace+"--date--"+date+"--time-"+time+"--interval--"+interval+"--number--"+number);
					
					StadiumPlace sp = new StadiumPlace();
					
					
					String[] d = date.split("-");
					String[] t = time.split(":");
				
					 po = new PlaceOrder();
					po.setOrderId(UUID.randomUUID().toString());
					po.setOrderStartTime(new Timestamp(Integer.parseInt(d[0])-1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[2]), Integer.parseInt(t[0]), Integer.parseInt(t[1]), 0, 0));
					po.setOrderEndTime(new Timestamp(Integer.parseInt(d[0])-1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[2]), Integer.parseInt(t[0])+Integer.parseInt(interval), Integer.parseInt(t[1]), 0, 0));
					
					//po.setOrderContents(new );
					po.setOrderPrice(Integer.parseInt(price)*Integer.parseInt(number)*Integer.parseInt(interval));
					po.setOrderNumber(Integer.parseInt(number));
					po.setOrderStatus("待支付");
					po.setOrderComment("未评论");
				//	po.setStadiumPlace(sp);
					Set<StadiumPlace> set = new HashSet<StadiumPlace>();
					if(!stadiumplace.contains(",")){
						
						String str1=stadiumplace.substring(1, stadiumplace.length()-1);
						System.out.println(str1.substring(1,str1.length()-1));
						sp = stadiummplaceservice.findbyid(str1.substring(1,str1.length()-1));
						stid=sp.getStadiumMain().getStadiumId();
						splace=sp.getPlaceName();
						po.setStadiumPlace(sp);
					}
					
					else{
						System.out.println(stadiumplace.substring(1, stadiumplace.length()-1).split(",")[0]);
						for(int i=0;i<stadiumplace.substring(1, stadiumplace.length()-1).split(",").length;i++){
							String str=stadiumplace.substring(1, stadiumplace.length()-1).split(",")[i];
							
							sp = stadiummplaceservice.findbyid(str.substring(1, str.length()-1));
							set.add(sp);
							stid=sp.getStadiumMain().getStadiumId();
							if(i<stadiumplace.substring(1, stadiumplace.length()-1).split(",").length-1)
							splace=splace+sp.getPlaceName()+",";
						}
						splace=splace+sp.getPlaceName();
						po.setStadiumPlaces(set);
					}
					po.setStadiumId(sp.getStadiumMain().getStadiumId());
					po.setUserId(userid);
					po.setOrderTime(new Timestamp(new Date().getTime()));
					po.setOrderPlace(splace);
					placeorderservice.add(po);
					 msg="success";	
					
				}
			
				return msg;
			}
			@RequestMapping("/toIndividual")
			public String toIndividual(Model model,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				UserMain user1 =usermainservice.findId(user.getUserId());
				UserDetail ud =userdetailservice.findByUserId(user.getUserId());
				model.addAttribute("birthday", Utils.dateToString(ud.getUserBirth()));
				model.addAttribute("star", Utils.getConstellation(ud.getUserBirth()));
				model.addAttribute("age", Utils.getAge(ud.getUserBirth()));
				List<PlaceOrder> olist1 = placeorderservice.findByUserId(user.getUserId());
				List<PlaceOrder> olist = new ArrayList<PlaceOrder>();
				List<PlaceOrder> olistpay = new ArrayList<PlaceOrder>();
				for (int i = 0; i < olist1.size(); i++) {
					if(!olist1.get(i).getOrderStatus().equals("已支付")){
					olist.add(olist1.get(i));
					}else{
						
						olistpay.add(olist1.get(i));	
					}
				}
				String pagesize="5";
				List message = commentreplyservice.findAll();
				List message1 = showreplyservice.findAll();
				message.addAll(message1);
				
				int size=0;
				for(int i=0;i<message.size();i++){
					if(message.get(i) instanceof CommentReply){
						if(((CommentReply)message.get(i)).getStadiumComment().getCommentUser().equalsIgnoreCase(user.getUserNickname()))
						size++;
						}
					else if(message.get(i) instanceof ShowReply){
						if(((ShowReply)message.get(i)).getHealthyShow().getShowUser().equalsIgnoreCase(user.getUserNickname()))
							size++;
					}
					}
				
				message.addAll(message1);
				String msize = size+"";
			model.addAttribute("msize", msize);
			model.addAttribute("psize", pagesize);
				model.addAttribute("olistpay",olistpay);
				model.addAttribute("osize",olist.size());
				model.addAttribute("opsize",olistpay.size());
				model.addAttribute("orderlist",olist);	
				model.addAttribute("usermain",user1);
				model.addAttribute("userdetail",ud);
				return "individual";
			}
			
			@RequestMapping(value="/getMessage",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
			public @ResponseBody String getMessage(String page,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				String msgdata="";
				int pagesize=5;
				List message = commentreplyservice.findAll();
				List message1 = showreplyservice.findAll();
				message.addAll(message1);
				int j=0;
				
				int allpage=0;
				int size=0;
				int end=0;
				for(int i=0;i<message.size();i++){
					if(message.get(i) instanceof CommentReply){
						if(((CommentReply)message.get(i)).getStadiumComment().getCommentUser().equalsIgnoreCase(user.getUserNickname()))
						size++;
						}
					else if(message.get(i) instanceof ShowReply){
						if(((ShowReply)message.get(i)).getHealthyShow().getShowUser().equalsIgnoreCase(user.getUserNickname()))
							size++;
					}
					}
				if(size%pagesize>0)
				allpage= size/pagesize+1;
				else allpage= size/pagesize;
				int start=(Integer.parseInt(page)-1)*pagesize;
				if((Integer.parseInt(page))*pagesize>size)
					end=size;
					else 
						end=(Integer.parseInt(page))*pagesize;
					Collections.sort(message, new MycompareTimeReply());
					Collections.reverse(message);
					int a=0;
					for(int i=0;i<message.size();i++){
					String str="";
					
					if(message.get(i) instanceof CommentReply){
						CommentReply cr = (CommentReply) message.get(i);
						if(cr.getStadiumComment().getCommentUser().equalsIgnoreCase(user.getUserNickname())){
							StadiumComment sc = cr.getStadiumComment();
							a++;
						if(j>=start&&j<end)
							 str=" <a style='color:orange;margin-left:2%;'>"+cr.getReplyUser()+":</a>回复了你的评论"
									+ "<br /><span style='margin-left:5%;'>"
									+ df.format(cr.getReplyTime())+ "</span>"
									+ "<div class='comment'>"
								
									+ "<img src='"+user.getUserPic().getUserPic()+"' width='40px' height='40px' />"
									+ "<div class='comment_content'> "
									+ "<div class='content'> "
									+ " <a style='color:orange'>"+sc.getCommentUser()+":&nbsp;&nbsp;</a>"+sc.getCommentContent()+" "
									+ "  </div>   <div class='time'>"
									
									+ "      <div class='comment_time'>"+df.format(sc.getCommentTime())+" "
									+ "<a onclick=\"deleteComment('"+sc.getCommentId()+"')\""
									+ " style='margin-left:48%;font-size:16px;'>删除</a>"
									+ "</div><div class='reply_content'><ul >  "
									+ "<li> <div class='c_reply'>"
									+ " <a style='color:orange'>"+cr.getReplyUser()+":&nbsp;&nbsp;</a>"
									+ cr.getReplyContent()+"</div>  "
									+ " <div class='time'> <div class='comment_time'>"+df.format(cr.getReplyTime())+"</div>"
									+ "  </div> </li>   </ul> </div>  </div>   </div>  </div>";
						
							j++;
						}
						
					}else if(message.get(i) instanceof ShowReply) {
						
						ShowReply sr = (ShowReply) message.get(i);
						
						if(sr.getHealthyShow().getShowUser().equalsIgnoreCase(user.getUserNickname())){
							a++;
							HealthyShow hs = sr.getHealthyShow();
							if(j>=start&&j<end)
							 str=" <a style='color:orange;margin-left:2%;'>"+sr.getReplyUser()+":</a>回复了你的圈子"
								+ "<br /><span style='margin-left:5%;'>"
								+ df.format(sr.getReplyTime())+ "</span>"
								+ "<div class='comment'>"
							
								+ "<img src='"+user.getUserPic().getUserPic()+"' width='40px' height='40px' />"
								+ "<div class='comment_content'> "
								+ "<div class='content'> "
								+ " <a style='color:orange'>"+hs.getShowUser()+":&nbsp;&nbsp;</a>"+hs.getShowContent()+" "
								+ "  </div>   <div class='time'>"
								
								+ "      <div class='comment_time'>"+df.format(hs.getShowTime())+" "
								+ "<a onclick=\"deleteShow('"+hs.getShowId()+"')\""
								+ " style='margin-left:48%;font-size:16px;'>删除</a>"
								+ "</div><div class='reply_content'><ul >  "
								+ "<li> <div class='c_reply'>"
								+ " <a style='color:orange'>"+sr.getReplyUser()+":&nbsp;&nbsp;</a>"
								+ sr.getReplyContent()+"</div>  "
								+ " <div class='time'> <div class='comment_time'>"+df.format(sr.getReplyTime())+"</div>"
								+ "  </div> </li>   </ul> </div>  </div>   </div>  </div>";
					
							j++;
						}
					}
					System.out.println(a);
					msgdata = msgdata+str;
				}
				return msgdata;
			}
			@RequestMapping("/toEditDetail")
			public String toEditDetail(Model model,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				String eid = user.getUserId();
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
				
				
				return "editdetail";
			}
			@RequestMapping("/update")
			public @ResponseBody String toEditDetail(HttpServletRequest request,String userid ,Model model,HttpSession session,String name,String sex,
					String year,String month,String day,String provence,String city
	            	,String emotion,String blood,String signature,String phone,String qq){
				String msg="fail";
				UserMain user=null;
				UserDetail ud=null;
				UserMain user1 = (UserMain) session.getAttribute("user1");
				if(user1!=null){
				user= usermainservice.findId(user1.getUserId());
				 ud =userdetailservice.findByUserId(user.getUserId());
				 System.out.println(sex);
					
					user.setUserSex(sex);
					
					if(name!="")
				user.setUserNickname(name);
				//System.out.println(year+month+day);
				if(year!=""&&month!=""&&day!=""){
					
					ud.setUserBirth(new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day)));
					//System.out.println(ud.getUserBirth());
				}		
					ud.setUserBlood(blood);
					ud.setUserEmotion(emotion);
						if(provence!=""&&city!="")
					ud.setUserLocation(provence+city);
						if(qq!="")
					ud.setUserQq(qq);
						if(phone!="")
					ud.setUserTel(phone);
						if(signature!="")
					ud.setUserSignature(signature.replaceAll("\r|\n", "   "));
					
					usermainservice.update(user);
					userdetailservice.update(ud);
					msg="unfail";
					model.addAttribute("orderlist",placeorderservice.findByUserId(user.getUserId()));
					//获取请求session
					session=request.getSession(false);
					//移除指定session
					session.removeAttribute("user1");
					if(session==null)
						//添加session
						session.setAttribute("user1", user);
				
				}
				else{
					user= usermainservice.findId(userid);
					 ud =userdetailservice.findByUserId(userid);
					 System.out.println(sex);
						
						user.setUserSex(sex);
						
						if(name!="")
					user.setUserNickname(name);
					if(year!=""&&month!=""&&day!=""){						
						ud.setUserBirth(new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day)));	
					}		
						ud.setUserBlood(blood);
						ud.setUserEmotion(emotion);
							if(provence!=""&&city!="")
						ud.setUserLocation(provence+city);
							if(qq!="")
						ud.setUserQq(qq);
							if(phone!="")
						ud.setUserTel(phone);
							if(signature!="")
						ud.setUserSignature(signature.replaceAll("\r|\n", "   "));	
						usermainservice.update(user);
						userdetailservice.update(ud);
						msg="unfail";
				}
				
				
				
				
				
				return msg;
			}
			@RequestMapping(value="/getpage",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
			public @ResponseBody String getPage(String goPage,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				List<PlaceOrder> oist1 = placeorderservice.findByUserId(user.getUserId());
				List<PlaceOrder> oist = new ArrayList<PlaceOrder>();
				for (int i = 0; i < oist1.size(); i++) {
					if(!oist1.get(i).getOrderStatus().equals("已支付")){
					oist.add(oist1.get(i));
					}
				}
				int pageSize=5;
				int totalSize=oist.size();
				int totalPage=pageSize/pageSize;
				if(totalSize%pageSize!=0)
					totalPage++;
				int beginPage=Integer.parseInt(goPage)-1;
				int endPage=Integer.parseInt(goPage);
				int endSize=endPage*pageSize;
				if(endPage*pageSize>=totalSize)
					endSize=totalSize;
				
				String rthtml="";
				System.out.println(totalSize);
				System.out.println(beginPage*pageSize);
				System.out.println(endSize);
					for (int i = beginPage*pageSize; i < endSize; i++) {
					
						PlaceOrder po =oist.get(i);
						
						//String photo = stadiummainservice.findbyId(po.getStadiumId()).getStadiumPhoto();
						String html="<div class='order_table'>"
								+ "<ul class='order'>"+
						           " <li class='order_check'> "+        
						                  "<div class='order_checkbox ' id='"+po.getOrderId()+"'>"+
						                       " <input type='checkbox' checked='checked'>"+
						               " </div>"+
						           " </li>"+
						          "  <li class='order_img'><div class='img_sum'>"
						          + "<div class='img_block'><img src="+po.getOrderPhoto()+"/></div>"
						          + "<div class='summary'>摘要</div></div></li>"+
						           " <li class='order_place'><div class='place'><p>"+po.getOrderPlace()+"</p></div></li>"+
						           " <li class='order_time'><div class='time'><p>"+po.getOrderStartTime()+"</p>"
						           + "<p>"+po.getOrderEndTime()+"</p></div></li>"+
						            "<li class='order_number'><div class='number'><p>"+po.getOrderNumber()+"</p></div></li>"+
						           " <li class='order_price'> <div class='price'><p>"+po.getOrderPrice()+"</p></div></li>"+
						           " <li class='delete_order'><div class='delete'><a onclick=\"deleteo('"+po.getOrderId()+"')\" >删除订单</a></div></li>"+
						           " <li class='pay_order'><div class='pay'><a onclick=\"payo('"+po.getOrderId()+"')\" > 支付订单</a></div></li>"+
						        "</ul>"
						           +"</div>";
								rthtml=rthtml+html;		
					}
					
//					
				return rthtml;
				
			}
			
			
			@RequestMapping(value="/getPaypage",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
			public @ResponseBody String getPayPage(String goPage,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				List<PlaceOrder> oist1 = placeorderservice.findByUserId(user.getUserId());
				List<PlaceOrder> oist = new ArrayList<PlaceOrder>();
				for (int i = 0; i < oist1.size(); i++) {
					if(oist1.get(i).getOrderStatus().equals("已支付")){
					oist.add(oist1.get(i));
					}
				}
				int pageSize=5;
				int totalSize=oist.size();
				int totalPage=pageSize/pageSize;
				if(totalSize%pageSize!=0)
					totalPage++;
				int beginPage=Integer.parseInt(goPage)-1;
				int endPage=Integer.parseInt(goPage);
				int endSize=endPage*pageSize;
				if(endPage*pageSize>=totalSize)
					endSize=totalSize;
				
				String rthtml="";
				System.out.println(totalSize);
				System.out.println(beginPage*pageSize);
				System.out.println(endSize);
					for (int i = beginPage*pageSize; i < endSize; i++) {
					
						PlaceOrder po =oist.get(i);
						String iscomment="";
						if(po.getOrderComment().equals("未评论"))
							iscomment="<a <a onclick=\"comment('"+po.getOrderId()+"')\"  >评价订单</a>";
						else
							iscomment="<a >已评价</a>";
						//String photo = stadiummainservice.findbyId(po.getStadiumId()).getStadiumPhoto();
						String html="<div class='order_table'>"
								+ "<ul class='order'>"+
						           " <li class='order_check'> "+        
						                  "<div class='order_checkbox ' id='"+po.getOrderId()+"'>"+
						                       " <input type='checkbox' checked='checked'>"+
						               " </div>"+
						           " </li>"+
						          "  <li class='order_img'><div class='img_sum'>"
						          + "<div class='img_block'><img src="+po.getOrderPhoto()+"/></div>"
						          + "<div class='summary'>摘要</div></div></li>"+
						           " <li class='order_place'><div class='place'><p>"+po.getOrderPlace()+"</p></div></li>"+
						           " <li class='order_time'><div class='time'><p>"+po.getOrderStartTime()+"</p>"
						           + "<p>"+po.getOrderEndTime()+"</p></div></li>"+
						            "<li class='order_number'><div class='number'><p>"+po.getOrderNumber()+"</p></div></li>"+
						           " <li class='order_price'> <div class='price'><p>"+po.getOrderPrice()+"</p></div></li>"+
						           " <li class='delete_order'><div class='delete'><a onclick=\"deleteo('"+po.getOrderId()+"')\" >删除订单</a></div></li>"+
						           " <li class='pay_order'><div class='pay'>"+iscomment+"</div></li>"+
						        "</ul>"
						           +"</div>";
								rthtml=rthtml+html;		
					}
					
//					
				return rthtml;
				
			}
			@RequestMapping("/commentOrder")
			public @ResponseBody String commentOrder(String oid,String content,HttpSession session){
				String msg="fail";
				UserMain user = (UserMain) session.getAttribute("user1");
				PlaceOrder po = placeorderservice.findById(oid);
				content=content.replaceAll("\r|\n", "   ");
				StadiumComment sc = new StadiumComment();
				System.out.println(oid);
				StadiumMain sa = stadiummainservice.findbyId(placeorderservice.findById(oid).getStadiumId());
				sc.setCommentUser(user.getUserNickname());
				sc.setCommentId(UUID.randomUUID().toString());
				sc.setCommentContent(content);
				sc.setStadiumMain(sa);
				po.setOrderComment("已评价");
				placeorderservice.pay(po);
				stadiumcommentservice.add(sc);
				if(user!=null)
				msg="success";
				return msg;
				
			}
			
			
			@RequestMapping("delete_order")
			public @ResponseBody String delete_order(String id) {
				String msg ="fail";
				System.out.println(id);
				if(id.contains(",")){
					String[] str = id.split(",");
					for (int i = 0; i < str.length; i++) {
						PlaceOrder placeorder = placeorderservice.findById(str[i]);
						placeorderservice.delete(placeorder);
					}
					msg="success";
				}else{
						placeorderservice.delete(placeorderservice.findById(id));
						msg="success";
				}
			
				return msg;
				
			}
			@RequestMapping("pay_order")
			public @ResponseBody String pay_order(String id) {
				String msg ="fail";
				if(id.contains(",")){
					String[] str = id.split(",");
					for (int i = 0; i < str.length; i++) {
						PlaceOrder placeorder = placeorderservice.findById(str[i]);
						placeorder.setOrderStatus("已支付");
						placeorderservice.pay(placeorder);
					}
					msg="success";
				}else{
					PlaceOrder placeorder = placeorderservice.findById(id);
					placeorder.setOrderStatus("已支付");
						placeorderservice.pay(placeorder);
						msg="success";
				}
			
				return msg;
				
			}
			
			@RequestMapping("/toOrderDetail")
			public  String toOrderSubmit(Model model,HttpSession session){
				UserMain user = (UserMain) session.getAttribute("user1");
				 String userid = user.getUserId();
					System.out.println(placeorderservice.findByUserId(userid));
				model.addAttribute("orderlist",placeorderservice.findByUserId(userid));
				System.out.println("哈哈哈哈");
			//model.addAttribute("order",po );
				return "ordersuccess";
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
				ArrayList<StadiumComment> commentlist = new ArrayList<StadiumComment>();
				commentlist=(ArrayList<StadiumComment>) stadiumcommentservice.findComment(sm);
				for (int i = 0; i < commentlist.size(); i++) {
					model.addAttribute(commentlist.get(i).getCommentUser()+"_pic", userPicService.findById(((UserMain)usermainservice.findname(commentlist.get(i).getCommentUser()).get(0)).getUserId()).getUserPic());
					model.addAttribute(commentlist.get(i).getCommentId(), commentreplyservice.findReply(commentlist.get(i)));
				System.out.println("reply-----------"+commentreplyservice.findReply(commentlist.get(i)));
				}
				
				//HashMap<Integer, List> cmap = new HashMap<Integer, List>();
				
				model.addAttribute("commentlist", commentlist);
				return "stadium_detail";
				
			}
			@RequestMapping(value="/getCommentReply",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
			public @ResponseBody String getCommentReply(String commentId,String pageNext,HttpSession session ){
				UserMain user = (UserMain) session.getAttribute("user1");
				String msgdata = "";
				List<CommentReply> replylist = commentreplyservice.findReply(stadiumcommentservice.findById(commentId));
				String de = "";
				int pagesize=3;
				int goPage=Integer.parseInt(pageNext);
				int allPage=replylist.size()/pagesize;
				if(replylist.size()%pagesize>0)
					allPage+=1;
				int end=pagesize*goPage;
				if(end>=replylist.size())
					end = replylist.size();
				if(goPage<=allPage)
				for(int i=pagesize*(goPage-1);i<end;i++){
					CommentReply cr = replylist.get(i);
					if(cr.getReplyUser().equals(user.getUserNickname()))
					de="<a onclick=\"deleteReply('"+cr.getReplyId()+"')\" style='font-size:16px;margin-left:70%;'>删除</a>";
					else 
						de="";
					msgdata=msgdata+" <li><div class= 'c_reply '><a style= 'color:orange '>"
							+cr.getReplyUser()+ ":&nbsp;&nbsp;</a>"
							+cr.getReplyContent()+ "</div>"
							+ "<div class= 'time '><div class= 'comment_time ' > "
							+ df.format(cr.getReplyTime())+de+"</div></div></li>";
					
				}
				
				return msgdata;
			}
			
			@RequestMapping("/deleteMyComment")
			public @ResponseBody String deleteComment(String id) {
				String msg="fail";
			StadiumComment sc = stadiumcommentservice.findOne(id).get(0);
			stadiumcommentservice.delete(sc);
				msg="success";
				return msg;
			}
			@RequestMapping("/deleteMyReply")
			public @ResponseBody String deleteReply(String id) {
				String msg="fail";
			CommentReply cr = commentreplyservice.findById(id).get(0);
			commentreplyservice.delete(cr);
				msg="success";
				return msg;
			}
			@RequestMapping("/deleteMyShow")
			public @ResponseBody String deleteShow(String id) {
				String msg="fail";
			HealthyShow hs = healthyshowservice.findOne(id);
			healthyshowservice.delete(hs);
				msg="success";
				return msg;
			}
			@RequestMapping("/deleteSReply")
			public @ResponseBody String deleteSReply(String id) {
				String msg="fail";
			ShowReply sr = showreplyservice.findById(id);
			showreplyservice.delete(sr);
				msg="success";
				return msg;
			}
			@RequestMapping("/ToStadium_Detail1")
			public String tostadium_detail(Model model,HttpServletRequest request){
				
				System.out.println("----id----"+stid);
				//第一次会为null	
				String id = request.getParameter("id");
				StadiumMain sm = (StadiumMain) stadiummainservice.findbyId(id);	//List splist = stadiummplaceservice.findbyStadiumId(stid);
				System.out.println(id);
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
				ArrayList<StadiumComment> commentlist = new ArrayList<StadiumComment>();
				commentlist=(ArrayList<StadiumComment>) stadiumcommentservice.findComment(sm);
				for (int i = 0; i < commentlist.size(); i++) {
					model.addAttribute(commentlist.get(i).getCommentUser()+"_pic", userPicService.findById(((UserMain)usermainservice.findname(commentlist.get(i).getCommentUser()).get(0)).getUserId()).getUserPic());
					model.addAttribute(commentlist.get(i).getCommentId(), commentreplyservice.findReply(commentlist.get(i)));
				System.out.println("reply-----------"+commentreplyservice.findReply(commentlist.get(i)));
				}
				ArrayList<StadiumMain> relative = new ArrayList<StadiumMain>();
				for(int i=0;i<stadiummainservice.findAll().size();i++){
					StadiumMain sm1 = (StadiumMain) stadiummainservice.findAll().get(i);
					if(sm1!=sm&&sm1.getUserMain().getUserId().equalsIgnoreCase(sm1.getUserMain().getUserId()))
						relative.add(sm1);
				}
				model.addAttribute("relative", relative);
				model.addAttribute("commentlist", commentlist);
				return "stadium_detail";
				
			}
			@RequestMapping("/replyComment")
			public @ResponseBody String toReplyComment(String content,String commentId,HttpSession session){
				String msg ="";
				 UserMain user = (UserMain) session.getAttribute("user1");
				 if(user==null)
					 msg="error";
				 CommentReply commentreply = new CommentReply();
				 commentreply.setReplyId(UUID.randomUUID().toString());
				 commentreply.setReplyContent(content.replaceAll("\r|\n", "   "));
				 commentreply.setStadiumComment(stadiumcommentservice.findById(commentId));
				 commentreply.setReplyUser(user.getUserNickname());
				 commentreplyservice.add(commentreply);
				 msg="success";
				return msg;
				
			}
			@RequestMapping("/UpHead")
			public String updatepic(MultipartFile file, HttpSession session,HttpServletRequest request,Model model){
			
				UserMain user = (UserMain) session.getAttribute("user1");
				Utils.uploadFile(request, file, "head", user.getUserId());
		      
		        UserPic upic = new UserPic();
		        upic.setUserId(user.getUserId());
		        upic.setUserMain(user);
		        upic.setUserPic("./head/"+user.getUserId());
		        
		        user.setUserPic(upic);
		        userpicservice.updatePic(upic);
		        usermainservice.update(user);

		       
		      //  model.addAttribute("fileUrl", "./head/"+fileName);  			        
		        return "redirect:/toEditDetail"; 
			}
			
			@RequestMapping("/toHealthyKnow")
			public String toHealthyKnow(Model model){
				model.addAttribute("equipment", healthyequipmentservice.findAll());
				model.addAttribute("muscle", healthymuscleservice.findAll());
				model.addAttribute("plane", healthyplaneservice.findAll());
				
				return "sport_know";
			}
			/**
			 * 未实现，待修改
			 * @param file
			 * @param session
			 * @param request
			 * @param model
			 * @return
			 */
			@RequestMapping("/q_picUpload")
			public String q_picUpload(MultipartFile file, HttpSession session,HttpServletRequest request,Model model){
				String path = request.getSession().getServletContext().getRealPath("head");
			
				UserMain user = (UserMain) session.getAttribute("user1");
				String fileName = file.getOriginalFilename();

					fileName = user.getUserId()+"myHead";

		        File targetFile = new File(path, fileName); 
		        System.out.println(path+"--------"+fileName);
		       
		      
		        UserPic upic = new UserPic();
		        upic.setUserId(user.getUserId());
		        upic.setUserMain(user);
		        upic.setUserPic("./head/"+fileName);
		        
		        user.setUserPic(upic);
		        userpicservice.updatePic(upic);
		        usermainservice.update(user);

		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        } 
		        try {  			        
		            file.transferTo(targetFile); 		            			            
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		      //  model.addAttribute("fileUrl", "./head/"+fileName);  			        
		        return "editdetail"; 
			}
			
	
					//发圈子
					@RequestMapping("/upSpace")
					public @ResponseBody String upSpace(HealthyShow healthyshow ,String content,HttpSession session){
						String msg="fail";
						healthyshow.setShowId(UUID.randomUUID().toString());
						healthyshow.setShowContent(content);
						 UserMain user = (UserMain) session.getAttribute("user1");
						healthyshow.setShowUser(user.getUserNickname());
						healthyshowservice.add(healthyshow);
						msg="success";
						return msg;
					}
					//遍历圈子
					@RequestMapping("/toAllSpace")
					public String allSpace(Model model,HttpServletRequest request){
						String index=request.getParameter("index");
						String pageSize="10";
						String pageNow="";
						String allpage="";
						int size = healthyshowservice.findall().size();
						allpage=size+"";
						if(index==null)
							pageNow="1";
						else
						 pageNow=index;
						List<HealthyShow> showlist = new ArrayList<HealthyShow>();
						showlist=healthyshowservice.findByPage(new Page("healthy_show", pageSize, pageNow, "show_id"));
						Collections.sort(showlist, new MycompareTime());
						Collections.reverse(showlist);
						for (int i = 0; i < showlist.size(); i++) {
							model.addAttribute(showlist.get(i).getShowUser()+"_pic", userPicService.findById(((UserMain)usermainservice.findname(showlist.get(i).getShowUser()).get(0)).getUserId()).getUserPic());
							if(showreplyservice.findByShow(showlist.get(i)).size()>0){
								List<ShowReply> replylist =showreplyservice.findByShow(showlist.get(i));
								Collections.sort(replylist, new MycompareTimeReply());
								Collections.reverse(replylist);
								model.addAttribute(showlist.get(i).getShowId()+"_reply", replylist);
							}
							if(showlist.get(i).getShowImage()!=null){
								List<String> imglist = new ArrayList<String>();
								String[] arr = showlist.get(i).getShowImage().split(";");
								for (int j = 0; j < arr.length; j++) {
									imglist.add(arr[j]);
								}
							model.addAttribute(showlist.get(i).getShowId(), imglist);
							}	
						}
						model.addAttribute("pagesize",pageSize );

						model.addAttribute("allpage",allpage );
						model.addAttribute("allspace",showlist );
						
						return "quanzi";	
					}
					@RequestMapping(value="/getReply",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
					public @ResponseBody String getReply(String showId,String pageNext,HttpSession session){
						UserMain user = (UserMain) session.getAttribute("user1");
						String msgdata = "";
						String de="";
						List<ShowReply> replylist = showreplyservice.findByShow(healthyshowservice.findOne(showId));
						Collections.sort(replylist, new MycompareTimeReply());
						Collections.reverse(replylist);
						int pagesize=4;
						int goPage=Integer.parseInt(pageNext);
						int allPage=replylist.size()/pagesize;
						if(replylist.size()%pagesize>0)
							allPage+=1;
						int end=pagesize*goPage;
						if(end>=replylist.size())
							end = replylist.size();
						if(goPage<=allPage)
						for(int i=pagesize*(goPage-1);i<end;i++){
							if(replylist.get(i).getReplyUser().equals(user.getUserNickname()))
							de="<a onclick=\"deleteReply('"+replylist.get(i).getReplyId()+"')\" style='font-size:16px;margin-left:70%;'>删除</a>";
							msgdata=msgdata+"<li><div class='c_reply'>"
									+ "<a style='color:orange'>"+replylist.get(i).getReplyUser()+":&nbsp;&nbsp;</a>"
									+ replylist.get(i).getReplyContent()+"</div>"
									+ "<div class='time'><div class='comment_time' > "+
									df.format(replylist.get(i).getReplyTime())
									+"</div></div></li>";
							
						}
						
						return msgdata;
					}
					
					//删除圈子
					@RequestMapping("/deleteSpace")
					public JSON deleteSpace(String id){
						JSONArray jsa = new JSONArray();
						HealthyShow h = healthyshowservice.findOne(id);
						healthyshowservice.delete(h);
						return jsa;		
					}
			//////所有运动项目////
					@RequestMapping("/Tosportproject")
					public String tospp(Model model,HttpServletRequest request){
						String id=request.getParameter("id");
						String pageSize="9";
						if(id==null){
							id="1";
						}
						Page page = new Page("sport_project", pageSize, id, "project_id");
						List list = sportprojectservice.findByPage(page);
						model.addAttribute("project",list );
						model.addAttribute("number",sportprojectservice.findAll().size() );
						model.addAttribute("psize",pageSize );
						return "sportproject";
					}
			
			@RequestMapping("/reply")
			public @ResponseBody String reply(String content,String showId ,HttpSession session){
				String msg="";
				UserMain user = (UserMain) session.getAttribute("user1");
				if(user==null){
					msg="error";
				}else{
					ShowReply showreply = new ShowReply();
				showreply.setReplyUser(user.getUserNickname());
				showreply.setReplyContent(content.replaceAll("\r|\n", "   "));	
				showreply.setReplyTime(Utils.dateToTime(new Date()));
				showreply.setReplyId(UUID.randomUUID().toString());
				showreply.setHealthyShow(healthyshowservice.findOne(showId));
				showreplyservice.add(showreply);
				System.out.println("哈哈哈");
				msg="success";
				}
				
				return msg;
			}
			
			
			
}
