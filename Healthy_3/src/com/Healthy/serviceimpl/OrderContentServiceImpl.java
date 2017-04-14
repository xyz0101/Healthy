package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.OrderContentDAO;
import com.Healthy.model.OrderContent;
import com.Healthy.service.OrderContentService;

@Service
public class OrderContentServiceImpl implements OrderContentService {
	@Autowired
	OrderContentDAO ordercontentdao;
	@Override
	public void add(OrderContent ordercontent) {
		// TODO Auto-generated method stub
		ordercontentdao.add(ordercontent);
	}

}
