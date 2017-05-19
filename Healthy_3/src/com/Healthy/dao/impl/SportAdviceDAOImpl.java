package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.SportAdviceDAO;
import com.Healthy.model.SportAdvice;
import com.util.Utils;
@Repository
public class SportAdviceDAOImpl extends HibernateDaoSupport implements SportAdviceDAO {
	 private static final String FIND_BY_ID="from SportAdvice u where u.adviceId = ?";
	 private static final String FIND_BY_TIME_DESC="select * from sport_advice ORDER BY advice_time desc";

	@Autowired	
	public void MySessionFactory(SessionFactory sessionfactory){
			super.setSessionFactory(sessionfactory);
		}
	@Override
	public List findAll() {
		SportAdvice sa = new SportAdvice();
		return Utils.findInSQLAll(sa, this, FIND_BY_TIME_DESC);
	}

	@Override
	public void delete(SportAdvice sportadvice) {
		Utils.delete(this, sportadvice);
	}

	@Override
	public void update(SportAdvice sportadvice) {
		Utils.update(this,sportadvice);
	}

	@Override
	public void add(SportAdvice sportadvice) {
		Utils.add(this, sportadvice);
	}
	@Override
	public List findById(String id) {
		return Utils.findInHQL(this, FIND_BY_ID, new String[]{id});
	}

}
