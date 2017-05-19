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
	 * ͨ��sql����ѯ
	 * @param obg ��������
	 * @param hds HibernateDaoSupport����
	 * @param sql sql���
	 * @param arg	�ؼ�������
	 * @return	�������
	 */
	public static List findInSQL(Object obg,HibernateDaoSupport hds,String sql,String[] arg){
	SQLQuery query = hds.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(obg.getClass());
	for(int i=0;i<arg.length;i++)
	query.setString(i, arg[i]);
	return query.list();
	}
	/**
	 * ͨ��sql����ѯ
	 * @param obg ��������
	 * @param hds HibernateDaoSupport����
	 * @param sql sql���
	 * @param arg	�ؼ�������
	 * @return	�������
	 */
	public static List findInSQLAll(Object obg,HibernateDaoSupport hds,String sql){
	SQLQuery query = hds.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(obg.getClass());
	return query.list();
	}
	/**
	 * ��������
	 * @param hds HibernateDaoSupport����
	 * @param obj ��������
	 */
	public static void add(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(obj);
		tmp.flush();
	}
	/**
	 * ɾ������
	 * @param hds HibernateDaoSupport����
	 * @param obj ��������
	 */
	public static void delete(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(obj);
		tmp.flush();
	}
	/**
	 * ��������
	 * @param hds HibernateDaoSupport����
	 * @param obj ��������
	 */
	public static void update(HibernateDaoSupport hds,Object obj){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(obj);
		tmp.flush();
	}
	/**
	 * ͨ��hql����ѯ
	 * @param hds HibernateDaoSupport����
	 * @param hql hql���
	 * @param arg	�ؼ�������
	 * @return	�������
	 */
	public static List findInHQL(HibernateDaoSupport hds,String hql,String[] arg){
		HibernateTemplate tmp = hds.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(hql, arg);
	}
	/**
	 * ͨ��hql����ѯ
	 * @param hds HibernateDaoSupport����
	 * @param hql hql���
	 * @param arg	�������
	 * @return	�������
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
	 * ��������
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
				constellation="Ħ����";
			}else {
				constellation="ˮƿ��";
			}
		}else if(m==2){
			if(day<=18){
				constellation="ˮƿ��";
			}else {
				constellation="˫����";
			}
		}else if(m==3){
			if(day<=20){
				constellation="˫����";
			}else {
				constellation="������";
			}
		}
		else if(m==4){
			if(day<=19){
				constellation="������";
			}else {
				constellation="��ţ��";
			}
		}else if(m==5){
			if(day<=20){
				constellation="��ţ��";
			}else {
				constellation="˫����";
			}
		}else if(m==6){
			if(day<=21){
				constellation="˫����";
			}else {
				constellation="��з��";
			}
		}else if(m==7){
			if(day<=22){
				constellation="��з��";
			}else {
				constellation="ʨ����";
			}
		}else if(m==8){
			if(day<=22){
				constellation="ʨ����";
			}else {
				constellation="��Ů��";
			}
		}else if(m==9){
			if(day<=22){
				constellation="��Ů��";
			}else {
				constellation="�����";
			}
		}else if(m==10){
			if(day<=23){
				constellation="�����";
			}else {
				constellation="��Ы��";
			}
		}else if(m==11){
			if(day<=22){
				constellation="��Ы��";
			}else {
				constellation="������";
			}
		}else if(m==12){
			if(day<=22){
				constellation="������";
			}else {
				constellation="Ħ����";
			}
		}
		return constellation;
	}
	/**
	 * �������
	 * @param d ����
	 * @return ����
	 */
	public static int getAge(Date d){
		if(d==null)
			return 0;
		int birth = d.getYear();
		int now = new Date().getYear();
		return now-birth;
	}
	/**
	 * ��ȡ�����
	 * @param list
	 * @return ���ֵ
	 */
	public static int getMax(List<Integer> list){
		Collections.sort(list);
		return  list.get(list.size()-1);
	}
	/**
	 * ��ȡ��Сֵ
	 * @param list
	 * @return ��Сֵ
	 */
	public static int getMin(List<Integer> list){
		Collections.sort(list);
		return  list.get(0);
	}
	
	
	/**
	 * �ϴ��ļ�����
	 * @param request ���������ȡ·��
	 * @param img ��Ҫ�ϴ����ļ�
	 * @param urlLast Ŀ������ļ���
	 * @param status ���»����½�������������ļ���  ���½���new
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
