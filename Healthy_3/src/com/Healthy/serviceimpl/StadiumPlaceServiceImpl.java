package com.Healthy.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.StadiumPlaceDAO;
import com.Healthy.model.StadiumMain;
import com.Healthy.model.StadiumPlace;
import com.Healthy.service.StadiumPlaceService;

@Service
public class StadiumPlaceServiceImpl implements StadiumPlaceService{
		@Autowired
		StadiumPlaceDAO stadiumplacedao;

		@Override
		public void addplace(StadiumPlace stadiumplace) {
			stadiumplacedao.add(stadiumplace);	
		}

		@Override
		public List findbyStadiumId(String stadiumid) {
			// TODO Auto-generated method stub
			return  stadiumplacedao.findbyStadiumId(stadiumid);
		}

		@Override
		public void delete(StadiumPlace stadiumplace) {
			// TODO Auto-generated method stub
			stadiumplacedao.delete(stadiumplace);
		}

		@Override
		public void update(StadiumPlace stadiumplace) {
			// TODO Auto-generated method stub
			stadiumplacedao.update(stadiumplace);
		}

		@Override
		public StadiumPlace findbyid(String placeid) {
			return stadiumplacedao.findbyid(placeid);
			
		}

		@Override
		public List<StadiumPlace> findbyStadiumMain(StadiumMain stadiummain) {
		return	stadiumplacedao.findbyStadiumMain(stadiummain);
		
		}
		
}
