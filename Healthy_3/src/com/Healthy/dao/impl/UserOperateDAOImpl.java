package com.Healthy.dao.impl;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.UserDetail;
import com.Healthy.model.UserOperate;
import com.Healthy.dao.UserDetailDAO;
import com.Healthy.dao.UserOperateDAO;
import com.Healthy.dao.UserPicDAO;
@Repository
public class UserOperateDAOImpl extends HibernateDaoSupport
implements UserOperateDAO{

	UserOperateDAO useroperatedao;
	
	 @Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(UserOperate useroperate) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(useroperate);
		tmp.flush();
	}

	
}
