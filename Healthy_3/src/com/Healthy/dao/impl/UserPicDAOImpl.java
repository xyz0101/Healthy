package com.Healthy.dao.impl;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserPic;
import com.Healthy.dao.UserDetailDAO;
import com.Healthy.dao.UserPicDAO;
@Repository
public class UserPicDAOImpl extends HibernateDaoSupport
implements UserPicDAO{

	UserPicDAO userpicdao;
	 private static final String FIND_BY_ID="from UserMain u where u.userId like ?";
	 @Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(UserPic userpic) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(userpic);
		tmp.flush();
	}

	
}
