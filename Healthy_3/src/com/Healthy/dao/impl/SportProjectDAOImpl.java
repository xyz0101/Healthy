package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.SportProjectDAO;
import com.Healthy.model.Page;
import com.Healthy.model.SportProject;
import com.util.GetSQL;
import com.util.Utils;
@Repository
public class SportProjectDAOImpl extends HibernateDaoSupport implements
		SportProjectDAO {
	 private static final String FIND_BY_ID="from SportProject s where s.projectId like ?";
	SportProjectDAO sportprojectdao;
	@Autowired
	public void Mysessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(SportProject sportproject) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.save(sportproject);
		tmp.flush();
	}

	@Override
	public void delete(SportProject sportproject) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		tmp.delete(sportproject);
		tmp.flush();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SportProject> find(String id) {
		
		return  (List<SportProject>) this.getHibernateTemplate().find(FIND_BY_ID, new String[]{id});
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SportProject> findAll() {
		System.out.println("sp---success");
		return (List<SportProject>)this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from SportProject").list();
	}
	@Override
	public void update(SportProject sportproject) {
		Utils.update(this, sportproject);
	}
	@Override
	public List findByPage(Page page) {
		SportProject sp = new SportProject();
		return Utils.findInSQLAll(sp, this, GetSQL.getSQL(page));
	}

}
