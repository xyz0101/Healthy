package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.PlaceOrder;

public interface PlaceOrderDAO {
	public void add(PlaceOrder placeorder);
	public void pay(PlaceOrder placeorder);
	public void delete(PlaceOrder placeorder);
	public List<PlaceOrder> findById(String orderid);
	public List<PlaceOrder> findByUserId(String userid);
	public List<PlaceOrder> findByDiffDay(String diffday);
	public List<PlaceOrder> findByDiffMonth(String diffmonth);
	public List<PlaceOrder> findAll();
}
