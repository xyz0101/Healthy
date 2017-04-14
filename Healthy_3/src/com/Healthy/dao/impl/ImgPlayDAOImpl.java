package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.ImgPlayDAO;
import com.Healthy.model.ImgPlay;
@Repository
public class ImgPlayDAOImpl extends HibernateDaoSupport implements ImgPlayDAO {
	 private static final String FIND_BY_ID="from ImgPlay i where i.imgId like ?"; 
	@Autowired 
		public void Mysetsessionfactory(SessionFactory sessionFactory){
			super.setSessionFactory(sessionFactory);
		}
	@Override
	public void update(ImgPlay img) {
		// TODO Auto-generated method stub
		
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(img);
	}
	@Override
	public List findbyid(String id) {
		return  this.getHibernateTemplate().find(FIND_BY_ID, new String[]{id});
	}

}
