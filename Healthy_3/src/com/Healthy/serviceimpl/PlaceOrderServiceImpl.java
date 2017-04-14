package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.model.PlaceOrder;
import com.Healthy.service.PlaceOrderService;
import com.Healthy.dao.PlaceOrderDAO;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {
	@Autowired
	PlaceOrderDAO placeorderdao;
	@Override
	public void add(PlaceOrder placeorder) {
		// TODO Auto-generated method stub
			placeorderdao.add(placeorder);
	}

}
