package com.Healthy.dao.impl;


import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.model.UserMain;
import com.Healthy.dao.UserMainDAO;
@Repository
public class UserMainDAOImpl extends HibernateDaoSupport implements UserMainDAO{
	 private static final String FIND_BY_NAME="from UserMain u where u.userNickname = ?";
	 private static final String FIND_BY_ID="from UserMain u where u.userId = ?";

	 @Autowired 
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(UserMain user) {
		HibernateTemplate tmp=getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(user);//���浽����
		tmp.flush();//д�뵽���ݿ�
		System.out.println("id="+user.getUserId());
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List findbyname(String name) {
		 return  this.getHibernateTemplate().find(FIND_BY_NAME, new String[]{name});
	}
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return (List) this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery("from UserMain").list();
	}
	@Override
	public void delete(UserMain user) {
		// TODO Auto-generated method stub
		HibernateTemplate tmp=getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(user);
		tmp.flush();
	}
	@Override
	public List findbyId(String id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(FIND_BY_ID, new String[]{id});
		
	}
	@Override
	public void update(UserMain user) {
		HibernateTemplate tmp=getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.update(user);
		tmp.flush();
		System.out.println("�޸ĳɹ�");
	}

}
