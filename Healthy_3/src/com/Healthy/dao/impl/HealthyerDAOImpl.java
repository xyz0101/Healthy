package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.HealthyerDAO;
@Repository
public class HealthyerDAOImpl extends HibernateDaoSupport implements HealthyerDAO {
	private static final String FIND="from Healthyer h where h.adminName like ?";
	@Autowired
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);	
	}
	@Override
	public List find(String name) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(FIND, new String[]{name});
	}

}
