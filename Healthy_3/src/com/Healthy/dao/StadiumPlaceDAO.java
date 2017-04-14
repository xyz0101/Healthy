package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;

public interface StadiumPlaceDAO {
		public void add(StadiumPlace stadiumplace);
		public StadiumPlace findbyid(String placeid);
		public List<StadiumPlace> findbyStadiumMain(StadiumMain stadiummain);
		public List findbyStadiumId(String stadiumid);
		public void delete(StadiumPlace stadiumplace);
		public void update(StadiumPlace stadiumplace);
}
