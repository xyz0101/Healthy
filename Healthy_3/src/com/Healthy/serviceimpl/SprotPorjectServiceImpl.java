package com.Healthy.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.SportProjectDAO;
import com.Healthy.model.SportProject;
import com.Healthy.service.SportProjectService;
@Service
public class SprotPorjectServiceImpl implements SportProjectService{
	@Autowired
	SportProjectDAO sportprojectdao;
	@Override
	public void add(SportProject sportproject) {
			sportprojectdao.add(sportproject);
	}

	@Override
	public void delete(String id) {
		SportProject sportproject = sportprojectdao.find(id).get(0);
		sportprojectdao.delete(sportproject);
	}

	@Override
	public List<SportProject> findAll() {
		return sportprojectdao.findAll();
	}

	@Override
	public List<SportProject> find(String id) {
		// TODO Auto-generated method stub
		return sportprojectdao.find(id);
	}

}
