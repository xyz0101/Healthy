package com.Healthy.service;
import com.Healthy.model.Page;
import com.Healthy.model.SportProject;
import com.Healthy.model.StadiumMain;

import java.util.List;
public interface StadiumMainService {
		public List findbyUserId(String userid);
		public List findWithPage(Page page);
		public void add(StadiumMain stadiummain);
		public StadiumMain findbyId(String stadiumid);
		public StadiumMain findbyname(String name);
		public List<StadiumMain> findbySpId(SportProject sp);
		public void delete(StadiumMain stadiummain);
		public void update(StadiumMain stadiummain);
		public List findAll();
		public List findByName(String name);
}
