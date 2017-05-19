package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.web.multipart.MultipartFile;



public class Utils{
	
	public static String[] getAN(HttpServletRequest request,String pageSize,List list){
		String index=request.getParameter("index");
		//String pageSize="10";
		String pageNow="";
		String allpage="";
		int size = list.size();
		allpage=size+"";
		if(index==null)
			pageNow="1";
		else
		 pageNow=index;
		String[] AllandNow = new String[]{};
		AllandNow[0]=allpage;
		AllandNow[1]=pageNow;
		return AllandNow;
	}
	
	public static List getPageList(HttpServletRequest request,List list,String pageSize){
		String index=request.getParameter("index");
		int size=Integer.parseInt(pageSize);
		String pageNow="";
		String allpage="";
		int allsize = list.size();
		allpage=allsize+"";
		if(index==null)
			pageNow="1";
		else
		 pageNow=index;
		int now = Integer.parseInt(pageNow);
		int end=size*now;
		List rlist = new ArrayList();
		if(allsize<=end)
			end=allsize;
		
		for (int i = (now-1)*size; i < end; i++) {
			rlist.add(list.get(i));
		}
		return rlist;
		
	}
	
	
	/**
	 * 通过sql语句查询
	 * @param obg 对象类型
	 * @param hds HibernateDaoSupport对象
	 * @param sql sql语句
	 * @param arg	关键词数组
	 * @return	结果集合
	 */
	public static List findInSQL(Object obg,HibernateDaoSupport hds,String sql,String[] arg){
	SQLQuery query = hds.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(obg.getClass());
	for(int i=0;i<arg.length;i++)
	query.setString(i, arg[i]);
	return query.list();
	}
	/**
	 * 通过sql语句查询
	 * @param obg 对象类型
	 * @param hds HibernateDaoSupport对象
	 * @param sql sql语句
	 * @param arg	关键词数组
	 * @return	结果集合
	 */
	public static List findInSQLAll(Object obg,HibernateDaoSupport hds,String sql){
	SQLQuery query = hds.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(obg.getClass());
	return query.list();
	}
	/**
	 * 插入数据
	 * @param hds HibernateDaoSupport对象
	 * @param obj 对象类型
	 */
	public static void add(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(obj);
		tmp.flush();
	}
	/**
	 * 删除数据
	 * @param hds HibernateDaoSupport对象
	 * @param obj 对象类型
	 */
	public static void delete(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(obj);
		tmp.flush();
	}
	/**
	 * 更新数据
	 * @param hds HibernateDaoSupport对象
	 * @param obj 对象类型
	 */
	public static void update(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(obj);
		tmp.flush();
	}
	/**
	 * 通过hql语句查询
	 * @param hds HibernateDaoSupport对象
	 * @param hql hql语句
	 * @param arg	关键词数组
	 * @return	结果集合
	 */
	public static List findInHQL(HibernateDaoSupport hds,String hql,String[] arg){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(hql, arg);
	}
	/**
	 * 通过hql语句查询
	 * @param hds HibernateDaoSupport对象
	 * @param hql hql语句
	 * @param arg	对象参数
	 * @return	结果集合
	 */
	public static List findInHQL(HibernateDaoSupport hds,String hql,Object arg){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return tmp.find(hql, arg);
	}
	public static String getStr(String[] s ){
		String str="";
		for (int i = 0; i < s.length-1; i++) {
			str=str+s[i]+",";
		}str=str+s[s.length-1];
		return str;
	}
	
	public static Timestamp dateToTime(Date date ){	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String str = df.format(date);
	Timestamp time = new Timestamp(System.currentTimeMillis());
	time=time.valueOf(str);
	return time;
	}
	public static String dateToString(Date d) {
		if(d==null)
			return "";
		DateFormat df =new  SimpleDateFormat("YYYY-MM-dd");
		String birth=df.format(d);
		return birth;
	}
	/**
	 * 星座计算
	 * @param d
	 * @return String
	 */
	public static String getConstellation(Date d) {
		if(d==null)
			return "";
		DateFormat df =new  SimpleDateFormat("YYYY-MM-dd");
		String birth=df.format(d);
		String constellation=null;
		String[] str = birth.split("-");
		int m=Integer.parseInt(str[1]);
		int day= Integer.parseInt(str[2]);
		if(m==1){
			if(day<=19){
				constellation="摩羯座";
			}else {
				constellation="水瓶座";
			}
		}else if(m==2){
			if(day<=18){
				constellation="水瓶座";
			}else {
				constellation="双鱼座";
			}
		}else if(m==3){
			if(day<=20){
				constellation="双鱼座";
			}else {
				constellation="白羊座";
			}
		}
		else if(m==4){
			if(day<=19){
				constellation="白羊座";
			}else {
				constellation="金牛座";
			}
		}else if(m==5){
			if(day<=20){
				constellation="金牛座";
			}else {
				constellation="双子座";
			}
		}else if(m==6){
			if(day<=21){
				constellation="双子座";
			}else {
				constellation="巨蟹座";
			}
		}else if(m==7){
			if(day<=22){
				constellation="巨蟹座";
			}else {
				constellation="狮子座";
			}
		}else if(m==8){
			if(day<=22){
				constellation="狮子座";
			}else {
				constellation="处女座";
			}
		}else if(m==9){
			if(day<=22){
				constellation="处女座";
			}else {
				constellation="天秤座";
			}
		}else if(m==10){
			if(day<=23){
				constellation="天秤座";
			}else {
				constellation="天蝎座";
			}
		}else if(m==11){
			if(day<=22){
				constellation="天蝎座";
			}else {
				constellation="射手座";
			}
		}else if(m==12){
			if(day<=22){
				constellation="射手座";
			}else {
				constellation="摩羯座";
			}
		}
		return constellation;
	}
	/**
	 * 年龄计算
	 * @param d 日期
	 * @return 年龄
	 */
	public static int getAge(Date d){
		if(d==null)
			return 0;
		int birth = d.getYear();
		int now = new Date().getYear();
		return now-birth;
	}
	/**
	 * 获取最大最
	 * @param list
	 * @return 最大值
	 */
	public static int getMax(List<Integer> list){
		Collections.sort(list);
		return  list.get(list.size()-1);
	}
	/**
	 * 获取最小值
	 * @param list
	 * @return 最小值
	 */
	public static int getMin(List<Integer> list){
		Collections.sort(list);
		return  list.get(0);
	}
	
	
	/**
	 * 上传文件工具
	 * @param request 根据请求获取路径
	 * @param img 需要上传的文件
	 * @param urlLast 目标最后文件夹
	 * @param status 更新还是新建，如果更新择传文件名  ，新建传new
	 */
	
		public static String uploadFile(HttpServletRequest request,MultipartFile img,String urlLast,String status){
			String path = request.getSession().getServletContext().getRealPath(urlLast);
			String path1 = "C:/Users/Administrator/git/Healthy/Healthy_3/WebRoot/"+urlLast+"/"; 
			String imgName=status;
			if(status.equals("new"))
		 imgName= UUID.randomUUID().toString();
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
		            img.transferTo(file); 	
		         
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
				return imgName;  	     
		}
	
}
