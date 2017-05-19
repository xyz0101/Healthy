package com.Healthy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.SportAdviceDAO;
import com.Healthy.model.SportAdvice;
import com.Healthy.model.SportProject;
import com.Healthy.service.SportAdviceService;
import com.Healthy.service.SportProjectService;
@Service
public class SportAdviceServiceImpl implements SportAdviceService {
@Autowired
SportAdviceDAO sportadvicedao;

@Override
public List findAll() {
	return sportadvicedao.findAll();
}

@Override
public void delete(SportAdvice sportadvice) {
	sportadvicedao.delete(sportadvice);
}

@Override
public void update(SportAdvice sportadvice) {
	sportadvicedao.update(sportadvice);
}

@Override
public void add(SportAdvice sportadvice) {
	sportadvicedao.add(sportadvice);
	
}

@Override
public List findById(String id) {
	return sportadvicedao.findById(id);
}
	
}
