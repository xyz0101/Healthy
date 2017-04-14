package com.Healthy.dao.impl;
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
	 private static final String FIND_BY_ID="from UserMain u where u.userId like ?";
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

	
}
