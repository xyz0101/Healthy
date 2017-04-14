package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;
import com.Healthy.dao.StadiumMainDAO;
@Repository
public class StadiumMainDAOImpl extends HibernateDaoSupport 
implements StadiumMainDAO {
	StadiumMainDAO stadiummaindao;
	private static final String FIND_BY_ID="from StadiumMain s where s.stadiumId like ?"; 
	private static final String FIND_BY_NAME="from StadiumMain s where s.stadiumName like ?"; 
	private static final String FIND_BY_SP="from StadiumMain s where s.sportProject like ?"; 
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(stadiummain);
		tmp.flush();
	}
	@Override
	public void delete(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(stadiummain);
		tmp.flush();
	}
	@Override
	public void update(StadiumMain stadiummain) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(stadiummain);
		tmp.flush();
	}
	@Override
	public List findbyname(String name) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(FIND_BY_NAME, new String[]{name});
	}
	@Override
	public List findbySpId(SportProject sp) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(FIND_BY_SP, sp);
	}
	@Override
	public List findbyId(String stadiumid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(FIND_BY_ID, new String[]{stadiumid});
	}
	

}
