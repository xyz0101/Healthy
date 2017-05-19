package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.HealthyPlaneDAO;
import com.Healthy.model.HealthyPlane;
import com.util.Utils;

@Repository
public class HealthyPlaneDAOImpl extends HibernateDaoSupport implements HealthyPlaneDAO {
	public static final String  FIND_BY_ID="from HealthyPlane h where planeId=?";

	@Autowired
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);	
	}
	@Override
	public List findAll() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from HealthyPlane").list();
	
	}
	@Override
	public void delete(HealthyPlane healthyplane) {
		Utils.delete(this, healthyplane);
	}
	@Override
	public void update(HealthyPlane healthyplane) {
		Utils.update(this, healthyplane);
	}
	@Override
	public void add(HealthyPlane healthyplane) {
		Utils.add(this, healthyplane);
	}
	@Override
	public List findById(String id) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		int i = Integer.parseInt(id);
		return tmp.find(FIND_BY_ID, new Integer[]{i} );
	}

}
