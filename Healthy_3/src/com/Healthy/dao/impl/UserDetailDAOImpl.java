package com.Healthy.dao.impl;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.UserDetail;
import com.Healthy.dao.UserDetailDAO;
@Repository
public class UserDetailDAOImpl extends HibernateDaoSupport
implements UserDetailDAO{

	UserDetailDAO userdetaildao;
	 private static final String FIND_BY_USERID="from UserDetail u where u.userId like ?";
	 private static final String FIND_BY_USERTEL="from UserDetail u where u.userTel like ?";
	 @Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(UserDetail userdetail) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(userdetail);
		tmp.flush();
	}
	@Override
	public List findByUserId(String userid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return tmp.find(FIND_BY_USERID, new String[]{ userid});
	}
	@Override
	public List findbyphone(String phone) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return tmp.find(FIND_BY_USERTEL, new String[]{ phone});
	}
	@Override
	public void update(UserDetail userdetail) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(userdetail);
		tmp.flush();
	}
	@Override
	public List<UserDetail> findAll() {
		// TODO Auto-generated method stub
		return this.findAll();
	}

	
}
