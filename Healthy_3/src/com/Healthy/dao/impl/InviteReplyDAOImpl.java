package com.Healthy.dao.impl;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.InviteReply;
import com.Healthy.dao.InviteReplyDAO;
@Repository
public class InviteReplyDAOImpl extends HibernateDaoSupport implements
		InviteReplyDAO {
	InviteReplyDAO invitereplydao;
	@Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(InviteReply invitereply) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(invitereply);
		tmp.flush();
	}

}
