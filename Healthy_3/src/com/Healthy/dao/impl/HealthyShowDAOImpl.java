package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.HealthyShow;
import com.Healthy.dao.HealthyShowDAO;
@Repository
public class HealthyShowDAOImpl extends HibernateDaoSupport implements
		HealthyShowDAO {
	 private static final String FIND_BY_ID="from HealthyShow u where u.showId like ?";
	HealthyShowDAO healthyshowdao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(HealthyShow healthyshow) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(healthyshow);
		tmp.flush();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HealthyShow> find() {
		// TODO Auto-generated method stub
		return (List<HealthyShow>) this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from HealthyShow").list();
	}
	@Override
	public void delete(HealthyShow healthyshow) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(healthyshow);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HealthyShow> findOne(String id) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		List<HealthyShow> list=(List<HealthyShow>) tmp.find(FIND_BY_ID, new String[]{id});
		return list;
	}

}
