package com.Healthy.dao.impl;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.Healthy.dao.HealthyEquipmentDAO;
import com.Healthy.model.HealthyEquipment;
import com.util.Utils;
@Repository
public class HealthyEquipmentDAOImpl extends HibernateDaoSupport implements HealthyEquipmentDAO {
	public static final String  FIND_BY_ID="from HealthyEquipment h where equipmentId=?";
	@Autowired
	public void Mysetsessionfactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);	
	}
	@Override
	public List findAll() {
		
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery("from HealthyEquipment").list();
	}
	@Override
	public void delete(HealthyEquipment healthyequipment) {
		Utils.delete(this, healthyequipment);
	}
	@Override
	public void update(HealthyEquipment healthyequipment) {
		Utils.update(this, healthyequipment);
	}
	@Override
	public void add(HealthyEquipment healthyequipment) {
		Utils.add(this, healthyequipment);
	}
	@Override
	public List findById(String id) {
		HibernateTemplate tmp = this.getHibernateTemplate();
		tmp.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		int i = Integer.parseInt(id);
		return tmp.find(FIND_BY_ID, new Integer[]{i} );
	}

}
