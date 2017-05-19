package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.StadiumPlaceDAO;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.util.Utils;
@Repository
public class StadiumPlaceDAOImpl extends HibernateDaoSupport implements
		StadiumPlaceDAO {
	private static final String FIND_BY_ID="from StadiumPlace s where s.placeId like ?";
	private static final String FIND_BY_NAME="from StadiumPlace s where s.placeName like ?";
	private static final String FIND_BY_SM="from StadiumPlace s where s.stadiumId like ?"; 
	private static final String FIND_BY_StM="from StadiumPlace s where s.stadiumMain like ?";
	StadiumPlaceDAO stadiumplacedao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(StadiumPlace stadiumplace) {
			HibernateTemplate tmp = getHibernateTemplate();
			tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
			tmp.save(stadiumplace);
			tmp.flush();
	}
	@Override
	public List findbyStadiumId(String stadiumid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return tmp.find(FIND_BY_SM, stadiumid);
	}
	@Override
	public void delete(StadiumPlace stadiumplace) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(stadiumplace);
		tmp.flush();
	}
	@Override
	public void update(StadiumPlace stadiumplace) {
				HibernateTemplate tmp = this.getHibernateTemplate();
				tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
				tmp.update(stadiumplace);
				tmp.flush();
	}
	@Override
	public StadiumPlace findbyid(String placeid) {
				HibernateTemplate tmp = this.getHibernateTemplate();
				tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
				return (StadiumPlace) tmp.find(FIND_BY_ID, new String[]{placeid}).get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<StadiumPlace> findbyStadiumMain(StadiumMain stadiummain) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<StadiumPlace>) tmp.find(FIND_BY_StM, stadiummain);
	}
	@Override
	public List findAll() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from StadiumPlace").list();
	}
	@Override
	public List findByname(String placename) {
		return Utils.findInHQL(this, FIND_BY_NAME, new String[]{placename});
	}

}
