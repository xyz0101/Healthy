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
import com.Healthy.model.ShowReply;
import com.Healthy.dao.ShowReplyDAO;
import com.util.Utils;
@Repository
public class ShowReplyDAOImpl extends HibernateDaoSupport implements
		ShowReplyDAO {
	 private static final String FIND_BY_USERID="from ShowReply u where u.replyUser = ?";
	 private static final String FIND_BY_ID="from ShowReply u where u.replyId = ?";
	 private static final String FIND_BY_DAYDIFF="select * from show_reply where TIMESTAMPDIFF(DAY,reply_time,CURRENT_TIMESTAMP())<= ?";
	 private static final String FIND_BY_MONTHDIFF="select * from show_reply where TIMESTAMPDIFF(MONTH,reply_time,CURRENT_TIMESTAMP())<= ?";

	private static final String FIND_BY_SHOW = "from ShowReply s where s.healthyShow like ? ";
	ShowReplyDAO showreplydao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(ShowReply showreply) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(showreply);
		tmp.flush();
	}
	@Override
	public List findByShow(HealthyShow healthyshow) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return tmp.find(FIND_BY_SHOW, healthyshow);
	}
	@Override
	public List<ShowReply> findByUserId(String userid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		
		return (List<ShowReply>) tmp.find(FIND_BY_USERID, new String[]{userid});
	}
	@Override
	public List<ShowReply> findByDiffDay(String diffday) {
		SQLQuery query = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createSQLQuery(FIND_BY_DAYDIFF).addEntity(ShowReply.class);
		query.setString(0, diffday);
		
		return query.list();
	}
	@Override
	public List<ShowReply> findByDiffMonth(String diffmonth) {
		SQLQuery query = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createSQLQuery(FIND_BY_MONTHDIFF).addEntity(ShowReply.class);
		query.setString(0, diffmonth);
		return query.list();
	}
	@Override
	public List<ShowReply> findAll() {
		HibernateTemplate tmp = this.getHibernateTemplate();	
		return tmp.getSessionFactory().getCurrentSession().createQuery("from ShowReply").list();
	
	}
	@Override
	public void delete(ShowReply showreply) {
		Utils.delete(this, showreply);
	}
	@Override
	public List<ShowReply> findById(String replyid) {
		return Utils.findInHQL(this,FIND_BY_ID , new String[]{replyid});
	}

}
