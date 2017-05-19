package com.Healthy.service;
import java.util.List;

import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;

public interface StadiumPlaceService {
		public void addplace(StadiumPlace stadiumplace);
		public List findbyStadiumId(String stadiumid);
		public List<StadiumPlace> findbyStadiumMain(StadiumMain stadiummain);
		public StadiumPlace findbyid(String placeid);
		public void delete(StadiumPlace stadiumplace);
		public void update(StadiumPlace stadiumplace);
		public List findAll();
		public List findByname(String name);
}
