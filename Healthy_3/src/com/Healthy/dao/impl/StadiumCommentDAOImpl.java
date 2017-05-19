package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.StadiumCommentDAO;
import com.Healthy.model.StadiumComment;
import com.Healthy.model.StadiumMain;
import com.util.Utils;
@Repository
public class StadiumCommentDAOImpl extends HibernateDaoSupport implements StadiumCommentDAO {
	
	 private static final String FIND_BY_USERID="from StadiumComment u where u.commentUser = ?";
	 private static final String FIND_BY_DAYDIFF="select * from stadium_comment where TIMESTAMPDIFF(DAY,comment_time,CURRENT_TIMESTAMP())<= ?";
	 private static final String FIND_BY_MONTHDIFF="select * from stadium_comment where TIMESTAMPDIFF(MONTH,comment_time,CURRENT_TIMESTAMP())<= ?";
	
	private static final String FIND_BY_ID="from StadiumComment s where s.commentId like ?";
	private static final String FIND_BY_STADIUMID="from StadiumComment s where s.stadiumMain like ?";
	@Autowired
	public void Mysessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public List<StadiumComment> findComment(StadiumMain stadiumId) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<StadiumComment>) tmp.find(FIND_BY_STADIUMID,stadiumId );
	}
	@Override
	public List findById(String commentId) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<StadiumComment>) tmp.find(FIND_BY_ID,new String[] {commentId});
	
	}
	@Override
	public List<StadiumComment> findAll() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession().
				createQuery("from StadiumComment").list();
	}
	@Override
	public List<StadiumComment> findByUserId(String userid) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		return (List<StadiumComment>) tmp.find(FIND_BY_USERID, new String[]{userid});
	}
	@Override
	public List<StadiumComment> findByDiffDay(String diffday) {
		StadiumComment st = new StadiumComment();
		return Utils.findInSQL(st, this, FIND_BY_DAYDIFF, new String[]{diffday});
	}
	@Override
	public List<StadiumComment> findByDiffMonth(String diffmonth) {
		StadiumComment st = new StadiumComment();
		return Utils.findInSQL(st, this, FIND_BY_MONTHDIFF, new String[]{diffmonth});
	}
	@Override
	public void delete(StadiumComment stadiumcomment) {
		Utils.delete(this, stadiumcomment);
		
	}
	@Override
	public List<StadiumComment> findOne(String id) {
		return Utils.findInHQL(this, FIND_BY_ID, new String[]{id});
	}
	@Override
	public void add(StadiumComment sc) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(sc);
		tmp.flush();
	}

}
