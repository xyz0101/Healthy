package com.Healthy.service;

import java.util.List;

import com.Healthy.model.PlaceOrder;

public interface PlaceOrderService {
	public void delete(PlaceOrder placeorder);	
		public void add(PlaceOrder placeorder);
		public void pay(PlaceOrder placeorder);
		public PlaceOrder findById(String orderid);
		public List<PlaceOrder> findByUserId(String userid);
		public List<PlaceOrder> findByDiffDay(String diffday);
		public List<PlaceOrder> findByDiffMonth(String diffmonth);
		public List<PlaceOrder> findAll();
}
