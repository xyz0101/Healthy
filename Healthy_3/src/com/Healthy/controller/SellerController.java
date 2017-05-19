package com.Healthy.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletRequest;
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

import com.Healthy.model.CommentReply;
import com.Healthy.model.Healthyer;
import com.Healthy.model.PlaceOrder;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.model.UserDetail;
import com.Healthy.model.UserMain;
import com.Healthy.service.CommentReplyService;
import com.Healthy.service.ImgPlayService;
import com.Healthy.service.PlaceOrderService;
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
 * 卖家部分
 * @author 周锦
 *
 */
@Controller
@SessionAttributes(value={"seller"})
public class SellerController {

		
	@Autowired
	private UserMainService usermainservice;
	@Autowired
	private StadiumPlaceService stadiumplaceservice;
	@Autowired
	private PlaceOrderService placeorderservice;
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
	private StadiumCommentService stadiumcommentservice;
	@Autowired
	private CommentReplyService commentreplyservice;
	private String eid="";
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	/**
	 * 商家部分
	 * 
	 */
	
	@RequestMapping("/seller_send_id")
	public @ResponseBody String send_id(String id,Model mode,HttpSession session){
		String msg="fail";
		if(session.getAttribute("seller")!=null)
		eid=id;
		msg="success";
		if(session.getAttribute("seller")!=null)
		return msg;
		else return "none";
	}
	

	@RequestMapping("/tosellerMain")
	public String toseller(){
		return "seller_main";
	}
	@RequestMapping("/toLoginSeller")
	public String toLoginseller(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "seller_login";
	}
	@RequestMapping("/loginseller")
	public @ResponseBody String loginseller(String sellerName,String sellerPassword,Model model){
		String msg="";
		UserMain  seller = usermainservice.find(sellerName);
		if(seller!=null&&seller.getUserPassword().equals(sellerPassword)&&seller.getUserStatus().equals("商家")){
			msg="ok";
			model.addAttribute("seller", seller);
		}else{
			msg="fail";
		}
		return msg;
	}
	@RequestMapping("/tosellerNav")
	public String toNav(HttpSession session){
		if(session.getAttribute("seller")!=null)
		return "seller_nav";
		else 
			return "error";
	}
	
	
	@RequestMapping("/seller_toorder_table")
	public  String toorder_table(String kind,String diff,Model model,HttpServletRequest request,HttpSession session){
		UserMain seller = (UserMain) session.getAttribute("seller");
		PlaceOrder order = new PlaceOrder();
		UserMain user = new UserMain();
		UserDetail ud = new UserDetail();
		List olist = new ArrayList();
		String pageSize="10";
		List<PlaceOrder> orderlist1 = new ArrayList<PlaceOrder>();
		List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findAll();
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
				getUserMain().getUserId().equals(seller.getUserId()))
					orderlist1.add(slist.get(i));
			}
			List<PlaceOrder> orderlist = new ArrayList<PlaceOrder>();
			orderlist=Utils.getPageList(request, orderlist1, pageSize);
			System.out.println(orderlist);
		for(int i=0;i<orderlist.size();i++){
			if(orderlist.size()>0){
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
		}
		if(seller!=null){
			model.addAttribute("allsize",orderlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allorder", olist);
		}
	
		
		return "seller_order_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有用户的订单
	 */
	@RequestMapping(value="/seller_getorder_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getorder_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		UserMain seller = (UserMain) session.getAttribute("seller");
		PlaceOrder order = new PlaceOrder();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		List<String[]> olist = new ArrayList<String[]>();
		List<PlaceOrder> orderlist = new ArrayList<PlaceOrder>();
		if(kind.equals("month")){
			List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findByDiffMonth(diff);
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
						getUserMain().getUserId().equals(seller.getUserId()))
					orderlist.add(slist.get(i));
			}
		}else if(kind.equals("week")){
			List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findByDiffDay(String.valueOf(Integer.parseInt(diff)*7));
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
						getUserMain().getUserId().equals(seller.getUserId()))
					orderlist.add(slist.get(i));
			}
		}else	if(kind.equals("day"))	{
			List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findByDiffDay(diff);
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
						getUserMain().getUserId().equals(seller.getUserId()))
					orderlist.add(slist.get(i));
		}
		}
		else if(kind.equals("appoint")){
			user1=(UserMain) usermainservice.findname(diff).get(0);
			
			List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findByUserId(user1.getUserId());
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
						getUserMain().getUserId().equals(seller.getUserId()))
					orderlist.add(slist.get(i));
			}
		}
		else if(kind.equals("all")){
			List<PlaceOrder> slist = new ArrayList<PlaceOrder>();
			slist=placeorderservice.findAll();
			for (int i = 0; i < slist.size(); i++) {
				if(stadiummainservice.findbyId(slist.get(i).getStadiumId()).
						getUserMain().getUserId().equals(seller.getUserId()))
					orderlist.add(slist.get(i));
			}
		}
		System.out.println(kind);
		System.out.println(diff);
		System.out.println(orderlist.size());
		for(int i=0;i<orderlist.size();i++){
			if(orderlist.size()>0){
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
		}
		String res="";
		if(orderlist.size()!=0){
			for(int i =0;i<olist.size()-1;i++){
			res=res+ Utils.getStr(olist.get(i))+"*"; 
		}
		
		res=res+ Utils.getStr(olist.get(olist.size()-1));
		}
		if(seller!=null){
			model.addAttribute("allorder", olist);
		msgdata=res;
		}
		
		return msgdata;
	}
	
	
	
	
	
	/**
	 * 初始化所有场馆
	 * @param model
	 * @return
	 */
	@RequestMapping("/seller_tostadium_table")
	public String tostadium_table(Model model,HttpServletRequest request, HttpSession session){
		UserMain seller = (UserMain) session.getAttribute("seller");
		List stadiumlist1 = new ArrayList();
		List dlist = new ArrayList();
		String pageSize="10";
		if(seller!=null){
		stadiumlist1=stadiummainservice.findbyUserId(seller.getUserId());
		
		List stadiumlist = new ArrayList();
		stadiumlist=Utils.getPageList(request, stadiumlist1, pageSize);
		System.out.println(stadiumlist);
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
		}
		if(session.getAttribute("seller")!=null){
			model.addAttribute("allsize",stadiumlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allstadium", dlist);
		}
		
		return "seller_stadium_table";
	}
	@RequestMapping("/seller_deleteStadium")
	public @ResponseBody String deleteStadium(String id,HttpSession session){
		String msg ="fail";
		if(session.getAttribute("seller")!=null)
		stadiummainservice.delete(stadiummainservice.findbyId(id));
		msg="success";
		return msg;
	}
	
	/**
	 * 根据关键字搜索场馆
	 * @param diff
	 * @param model
	 * @return 场馆数据
	 */
	@RequestMapping(value="/seller_getstadium_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getstadium_table(String diff,Model model,HttpSession session){
		String msgdata="fail";
		UserMain seller = (UserMain) session.getAttribute("seller");
		List stadiumlist = new ArrayList();
		List<String[]> dlist = new ArrayList<String[]>();
		if(diff.equals("全部"))
			stadiumlist=stadiummainservice.findAll();
		else 
		stadiumlist=stadiummainservice.findByName(diff);
		System.out.println(stadiumlist);

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
			if(sm.getUserMain().getUserId().equals(seller.getUserId())){
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
		}
		String res="";
		if(stadiumlist.size()!=0){
			for(int i =0;i<dlist.size()-1;i++){
			res=res+ Utils.getStr(dlist.get(i))+"*"; 
		}
		res=res+ Utils.getStr(dlist.get(dlist.size()-1));
		}
	//	model.addAttribute("allshowreply", dlist);
		if(session.getAttribute("seller")!=null)
		msgdata=res;
		return msgdata;
	
	}
	/**
	 * 初始化场地列表
	 * @param model
	 * @return 场地数据
	 */
	@RequestMapping("/seller_toplace_table")
	public String toplace_table(Model model,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		List placelist1 = new ArrayList();
		List dlist = new ArrayList();
		String pageSize="10";
		placelist1=stadiummplaceservice.findAll();
		List placelist = new ArrayList();
		placelist=Utils.getPageList(request, placelist1, pageSize);
		System.out.println(placelist);

		for(int i=0;i<placelist.size();i++){
			String id="";
			String type="";
			String name="";
			String price="";	
			String img="";
			String location="";
			Object[] str = null ;
			StadiumPlace sp = (StadiumPlace) placelist.get(i);
		if(	sp.getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){
			id=sp.getPlaceId();
			type=sp.getStadiumMain().getStadiumName();
			name=sp.getPlaceName();
			price=sp.getPlacePrice();
			img=sp.getPlacePhoto();
			location=sp.getPlaceLocation();
			str = new Object[]{id,name,price,type,img,location};		
			dlist.add(str);
		}
		}
		if(session.getAttribute("seller")!=null){
			model.addAttribute("allsize",placelist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("allplace", dlist);
		}
		
		return "seller_place_table";
	}
	/**
	 * 通过关键词搜索场地
	 * @param diff
	 * @param model
	 * @return 场地数据
	 */
	@RequestMapping(value="/seller_getplace_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getplace_table(String diff,Model model,HttpSession session){
		UserMain seller = (UserMain) session.getAttribute("seller");

		String msgdata="fail";
		List placelist = new ArrayList();
		List<String[]> dlist = new ArrayList<String[]>();
		if(diff.equals("全部"))	
			placelist=stadiummplaceservice.findAll();
		else 
			placelist=stadiummplaceservice.findByname(diff);
		System.out.println(placelist);

		for(int i=0;i<placelist.size();i++){
			String id="";
			String type="";
			String name="";
			String price="";	
			String img="";
			String location="";
			String[] str = null ;
			StadiumPlace sp = (StadiumPlace) placelist.get(i);
			if(sp.getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){
			id=sp.getPlaceId();
			type=sp.getStadiumMain().getStadiumName();
			name=sp.getPlaceName();
			price=sp.getPlacePrice();
			img=sp.getPlacePhoto();
			location=sp.getPlaceLocation();
			str = new String[]{id,name,type,price,img,location};		
			dlist.add(str);
			}
		}
		String res="";
		if(placelist.size()!=0){
			for(int i =0;i<dlist.size()-1;i++){
			res=res+ Utils.getStr(dlist.get(i))+"*"; 
		}
		res=res+ Utils.getStr(dlist.get(dlist.size()-1));
		}
		//model.addAttribute("allshowreply", dlist);
		if(session.getAttribute("seller")!=null)
		msgdata=res;
		return msgdata;
	
	}
	@RequestMapping("/seller_deletePlace")
	public @ResponseBody String deletePlace(String id,HttpSession session){
			String msg="fail";
			UserMain seller = (UserMain) session.getAttribute("seller");
			if(seller!=null){
			stadiummplaceservice.delete(stadiummplaceservice.findbyid(id));
			msg="success";
		}
		return msg;
	}
	
	
	/**
	 * 初始化所有场馆评论
	 * @param model
	 * @return
	 */
	@RequestMapping("/seller_tocomment_table")
	public String tocomment_table(Model model,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		StadiumComment comment = new StadiumComment();
		UserMain user = new UserMain();
		UserMain user1 = new UserMain();
		UserDetail ud = new UserDetail();
		String pageSize="10";
		List<String[]> clist = new ArrayList<String[]>();
		List<StadiumComment> commentlist1 = new ArrayList<StadiumComment>();
		 commentlist1=stadiumcommentservice.findAll();
		 List<StadiumComment> commentlist = new ArrayList<StadiumComment>();
		 commentlist=Utils.getPageList(request, commentlist1, pageSize);
		System.out.println(commentlist.size());
		for(int i=0;i<commentlist.size();i++){
			
			comment=commentlist.get(i);
			if(comment.getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){
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
		}
		if(session.getAttribute("seller")!=null){
			model.addAttribute("allsize",commentlist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("cinit", clist);
		}
		
		return "seller_comment_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有场馆评论
	 */
	@RequestMapping(value="/seller_getcomment_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getcomment_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		UserMain seller = (UserMain) session.getAttribute("seller");
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
			if(comment.getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){
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
		}
		String res="";
		if(commentlist.size()!=0){
			for(int i =0;i<clist.size()-1;i++){
				res=res+ Utils.getStr(clist.get(i))+"*"; 
			}
			
			res=res+ Utils.getStr(clist.get(clist.size()-1));	
		}
		if(session.getAttribute("seller")!=null){
		//model.addAttribute("allcomment", clist);
		msgdata=res;
		}
		return msgdata;
	}
	
	@RequestMapping("/seller_deleteComment")
	public @ResponseBody String deleteComment(String commentid,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("seller")!=null)
		stadiumcommentservice.delete(stadiumcommentservice.findById(commentid));
		msg="success";
		return msg;
	}
	@RequestMapping("/seller_deleteCommentReply")
	public @ResponseBody String deleteCommentReply(String replyid,HttpSession session){
		String msg = "fail";
		if(session.getAttribute("seller")!=null)
		commentreplyservice.delete(commentreplyservice.findById(replyid).get(0));
		msg="success";
		return msg;
	}
	
	
	/**
	 * 初始化所有场馆评论回复
	 * @param model
	 * @return
	 */
	@RequestMapping("/seller_tocomment_reply_table")
	public String tocomment_reply_table(Model model,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
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
			if(creply.getStadiumComment().getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){
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
		}
		if(session.getAttribute("seller")!=null){
			model.addAttribute("allsize",commentreplylist1.size() );
			model.addAttribute("pagesize",pageSize);
			model.addAttribute("crinit", crlist);
		}
	
		return "seller_comment_reply_table";
	}
	
	/**
	 * 
	 * @param kind
	 * @param diff
	 * @param model
	 * @return 所有场馆评论回复
	 */
	@RequestMapping(value="/seller_getcomment_reply_table",produces={"text/html;charset=UTF-8;","application/json;"}/*解决返回乱码*/)  
	public @ResponseBody String getcomment_reply_table(String kind,String diff,Model model,HttpSession session){
		String msgdata="fail";
		UserMain seller = (UserMain) session.getAttribute("seller");
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
			if(creply.getStadiumComment().getStadiumMain().getUserMain().getUserId().equals(seller.getUserId())){

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
		}
		String res="";
		if(commentreplylist.size()!=0){
			for(int i =0;i<crlist.size()-1;i++){
				res=res+ Utils.getStr(crlist.get(i))+"*"; 
			}
			
			res=res+ Utils.getStr(crlist.get(crlist.size()-1));
		}
		if(session.getAttribute("seller")!=null){
		model.addAttribute("allcommentreply", crlist);
		msgdata=res;
		}
		return msgdata;
	}
	
	
	
	
	
	
	

	/**
	 * 添加运动场馆
	 * @param type 场馆分类
	 * @param name 名称
	 * @param img 图片
	 * @param introduce 介绍
	 * @param location 地址
	 * @param session 
	 * @param request
	 * @return 页面
	 */
	@RequestMapping("/addStadium")
	public String addStadium(String type,String name,MultipartFile img,String introduce,String location,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		StadiumMain sm = new StadiumMain();
		
		String imgName=Utils.uploadFile(request, img, "photo","new");
		if(seller!=null){
			sm.setSportProject(sportprojectservice.find(type).get(0));
		sm.setStadiumId(UUID.randomUUID().toString());
		sm.setStadiumName(name);
		sm.setStadiumIntroduction(introduce);
		sm.setStadiumLocation(location);
		sm.setStadiumPhoto("./photo/"+imgName);
		sm.setStadiumTel(seller.getUserDetail().getUserTel());
		sm.setUserMain(seller);
		stadiummainservice.add(sm);
		}
		return "redirect:/seller_tostadium_table";
	}
	@RequestMapping("/toeditStadium")
	public  String toUpdateSta( Model model){	
		model.addAttribute("stadium", stadiummainservice.findbyId(eid));
		model.addAttribute("projecttype", sportprojectservice.findAll());
		return "seller_editstadium";
	}
	@RequestMapping("/toaddStadium")
	public  String toaddStadium(Model model){	
		model.addAttribute("projecttype", sportprojectservice.findAll());
		return "seller_addstadium";
	}
	@RequestMapping("/editStadium")
	public  String updateStadium(String type,String name,MultipartFile img,String introduce,String location,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		StadiumMain sm =stadiummainservice.findbyId(eid);
		String imgname = sm.getStadiumPhoto();
		if(imgname.length()>36)
		imgname=imgname.substring(imgname.length()-37, imgname.length());
		else
			imgname="new";
		String imgName=Utils.uploadFile(request, img, "photo",imgname);
		if(seller!=null){
			if(type!="")
			sm.setSportProject(sportprojectservice.find(type).get(0));
			if(name!="")
		sm.setStadiumName(name);
			
		sm.setStadiumIntroduction(introduce);
		if(location!="")
		sm.setStadiumLocation(location);
		if(img!=null)
		sm.setStadiumPhoto("./photo/"+imgName);
		sm.setStadiumTel(seller.getUserDetail().getUserTel());
		sm.setUserMain(seller);
		System.out.println(location+"---"+introduce+"---"+name+"---"+type);
		stadiummainservice.update(sm);
		}
		return "redirect:/seller_tostadium_table";
	}
	
	
	
	@RequestMapping("/addPlace")
	public String addPlace(String type,String name,MultipartFile img,String price,String introduce,String location,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		StadiumPlace sp = new StadiumPlace();
		String imgName=Utils.uploadFile(request, img, "photo","new");
		if(seller!=null){
		sp.setPlaceId(UUID.randomUUID().toString());
		sp.setPlaceLocation(location);
		sp.setPlaceName(name);
		sp.setPlacePhoto("./photo/"+imgName);
		sp.setStadiumMain(stadiummainservice.findbyId(type));
		sp.setPlacePrice(price);
		sp.setPlaceStatus((short)1);
		stadiummplaceservice.addplace(sp);
		}
		return "redirect:/seller_toplace_table";
	}
	@RequestMapping("/toeditPlace")
	public  String toeditPlace( Model model,HttpSession session){	
		UserMain seller = (UserMain) session.getAttribute("seller");
		model.addAttribute("place", stadiummplaceservice.findbyid(eid));
		model.addAttribute("stadiumtype", stadiummainservice.findbyUserId(seller.getUserId()));
		return "seller_editplace";
	}
	@RequestMapping("/toaddPlace")
	public  String toaddPlace(Model model,HttpSession session){	
		UserMain seller = (UserMain) session.getAttribute("seller");
		model.addAttribute("stadiumtype", stadiummainservice.findbyUserId(seller.getUserId()));
		return "seller_addplace";
	}
	@RequestMapping("/editPlace")
	public  String editPlace(String type,String name,MultipartFile img,String price,String introduce,String location,HttpSession session,HttpServletRequest request){
		UserMain seller = (UserMain) session.getAttribute("seller");
		StadiumPlace sp = stadiummplaceservice.findbyid(eid);
		String imgname = sp.getPlacePhoto();
		if(imgname.length()>36)
		imgname=imgname.substring(imgname.length()-37, imgname.length());
		else
			imgname="new";
		String imgName=Utils.uploadFile(request, img, "photo",imgname);
		if(seller!=null){
			if(location!="")
		sp.setPlaceLocation(location);
			if(name!="")
		sp.setPlaceName(name);
			if(img!=null)
		sp.setPlacePhoto("./photo/"+imgName);
		sp.setStadiumMain(stadiummainservice.findbyId(type));
		if(price!="")
		sp.setPlacePrice(price);
		
		stadiummplaceservice.update(sp);
		}
		return "redirect:/seller_toplace_table";
	}
	
	
}
