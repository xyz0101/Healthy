package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.PlaceOrder;
import com.Healthy.dao.PlaceOrderDAO;
import com.mysql.jdbc.PreparedStatement;
@Repository
public class PlaceOrderDAOImpl extends HibernateDaoSupport implements
		PlaceOrderDAO {
	public static final String FIND_BY_USERID="from PlaceOrder p where p.userId =?";
	public static final String FIND_BY_ID="from PlaceOrder p where p.orderId =?";

	PlaceOrderDAO placeorderdao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(PlaceOrder placeorder) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(placeorder);
		tmp.flush();
		System.out.println("交易成功");
	}
	@Override
	public List<PlaceOrder> findByUserId(String userid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<PlaceOrder>) tmp.find(FIND_BY_USERID, new String[]{userid});
	}
	@Override
	public List<PlaceOrder> findByDiffDay(String diffday) {
		
	SQLQuery query  =	this.getHibernateTemplate().getSessionFactory()
		.getCurrentSession().
		createSQLQuery("select * from place_order where TIMESTAMPDIFF(DAY,order_time,CURRENT_TIMESTAMP())<= ?")
		.addEntity(PlaceOrder.class);//执行sql语句得到的是object对象，里面是表的字段，所以要添加hibernate映射的bean
		query.setString(0, diffday);
		System.out.println("通过天数");
		
		return query.list();
		
	}
	@Override
	public List<PlaceOrder> findByDiffMonth(String diffmonth) {
		SQLQuery query  =	this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery("select * from place_order where TIMESTAMPDIFF(MONTH,order_time,CURRENT_TIMESTAMP())<= ?")
				.addEntity(PlaceOrder.class);//执行sql语句得到的是object对象，里面是表的字段，所以要添加hibernate映射的bean
				query.setString(0, diffmonth);
				System.out.println("通过月份");
				return query.list();
	}
	@Override
	public List<PlaceOrder> findAll() {
		System.out.println("查找所有");
		return  this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery("from PlaceOrder").list();
		
	}
	@Override
	public void delete(PlaceOrder placeorder) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(placeorder);
		tmp.flush();
	
		
	}
	@Override
	public List<PlaceOrder> findById(String orderid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		System.out.println((List<PlaceOrder>) tmp.find(FIND_BY_ID, new String[]{orderid}));
		return (List<PlaceOrder>) tmp.find(FIND_BY_ID, new String[]{orderid});
	}
	@Override
	public void pay(PlaceOrder placeorder) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(placeorder);
		tmp.flush();
	}

}
