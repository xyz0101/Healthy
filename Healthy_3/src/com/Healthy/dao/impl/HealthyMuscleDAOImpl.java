package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.HealthyMuscleDAO;
import com.Healthy.model.HealthyMuscle;
import com.util.Utils;
@Repository
public class HealthyMuscleDAOImpl extends HibernateDaoSupport implements HealthyMuscleDAO {
	public static final String  FIND_BY_ID="from HealthyMuscle h where muscleId=?";

	@Autowired
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);	
	}
	@Override
	public List findAll() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from HealthyMuscle").list();
	
	}
	@Override
	public void delete(HealthyMuscle healthymuscle) {
		Utils.delete(this, healthymuscle);
	}
	@Override
	public void update(HealthyMuscle healthymuscle) {
		Utils.update(this, healthymuscle);
	}
	@Override
	public void add(HealthyMuscle healthymuscle) {
		Utils.add(this, healthymuscle);
	}
	@Override
	public List findById(String id) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		int i = Integer.parseInt(id);
		return tmp.find(FIND_BY_ID, new Integer[]{i} );
	}

}
