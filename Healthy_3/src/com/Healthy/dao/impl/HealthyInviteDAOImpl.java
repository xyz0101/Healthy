package com.Healthy.dao.impl;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.HealthyInvite;
import com.Healthy.dao.HealthyInviteDAO;
@Repository
public class HealthyInviteDAOImpl extends HibernateDaoSupport 
implements HealthyInviteDAO {
	HealthyInviteDAO healthyinvitedao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(HealthyInvite healthyinvite) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(healthyinvite);
		tmp.flush();
	}
}
