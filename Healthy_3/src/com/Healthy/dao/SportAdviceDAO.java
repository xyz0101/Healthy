package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.SportAdvice;

public interface SportAdviceDAO {
	public List findAll();
	public List findById(String id);
	public void delete(SportAdvice sportadvice);
	public void update(SportAdvice sportadvice);
	public void add(SportAdvice sportadvice);
}
