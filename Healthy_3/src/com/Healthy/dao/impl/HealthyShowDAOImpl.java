package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.HealthyShow;
import com.Healthy.model.Page;
import com.Healthy.dao.HealthyShowDAO;
import com.util.GetSQL;
import com.util.Utils;
@Repository
public class HealthyShowDAOImpl extends HibernateDaoSupport implements
		HealthyShowDAO {
	 private static final String FIND_BY_USERID="from HealthyShow u where u.showUser = ?";
	 private static final String FIND_BY_ID="from HealthyShow u where u.showId = ?";
	 private static final String FIND_BY_DAYDIFF="select * from healthy_show where TIMESTAMPDIFF(DAY,show_time,CURRENT_TIMESTAMP())<= ?";
	 private static final String FIND_BY_MONTHDIFF="select * from healthy_show where TIMESTAMPDIFF(MONTH,show_time,CURRENT_TIMESTAMP())<= ?";
	HealthyShowDAO healthyshowdao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(HealthyShow healthyshow) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(healthyshow);
		tmp.flush();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HealthyShow> find() {
		return (List<HealthyShow>) this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from HealthyShow").list();
	}
	@Override
	public void delete(HealthyShow healthyshow) {
		Utils.delete(this, healthyshow);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HealthyShow> findOne(String id) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		List<HealthyShow> list=(List<HealthyShow>) tmp.find(FIND_BY_ID, new String[]{id});
		return list;
	}
	@Override
	public List<HealthyShow> findByUserId(String userid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<HealthyShow>) tmp.find(FIND_BY_USERID, new String[]{userid});
	}
	@Override
	public List<HealthyShow> findByDiffDay(String diffday) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		SQLQuery query = tmp.getSessionFactory().getCurrentSession()
				.createSQLQuery(FIND_BY_DAYDIFF).addEntity(HealthyShow.class);
		query.setString(0, diffday);
		return query.list();
	}
	@Override
	public List<HealthyShow> findByDiffMonth(String diffmonth) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		SQLQuery query = tmp.getSessionFactory().getCurrentSession()
				.createSQLQuery(FIND_BY_MONTHDIFF).addEntity(HealthyShow.class);
		query.setString(0, diffmonth);
		return query.list();
	}
	@Override
	public List<HealthyShow> findByPage(Page page) {
		HealthyShow h = new HealthyShow();
		return Utils.findInSQLAll(h, this, GetSQL.getSQL(page));
	}

}
