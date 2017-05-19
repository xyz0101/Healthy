package com.Healthy.serviceimpl;

import java.util.List;

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
	@Override
	public List<PlaceOrder> findByUserId(String userid) {
		
		return placeorderdao.findByUserId(userid);
	}
	@Override
	public List<PlaceOrder> findByDiffDay(String diffday) {
		// TODO Auto-generated method stub
		return placeorderdao.findByDiffDay(diffday);
	}
	@Override
	public List<PlaceOrder> findByDiffMonth(String diffmonth) {
		// TODO Auto-generated method stub
		return placeorderdao.findByDiffMonth(diffmonth);
	}
	@Override
	public List<PlaceOrder> findAll() {
		// TODO Auto-generated method stub
		return placeorderdao.findAll();
		
	}
	@Override
	public void delete(PlaceOrder placeorder) {
		placeorderdao.delete(placeorder);
		
	}
	@Override
	public PlaceOrder findById(String orderid) {
	
		return placeorderdao.findById(orderid).get(0);
	}
	@Override
	public void pay(PlaceOrder placeorder) {
		placeorderdao.pay(placeorder);
	}

}
