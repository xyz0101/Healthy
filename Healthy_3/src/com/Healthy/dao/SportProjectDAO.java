package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.SportProject;

public interface SportProjectDAO {
	public void add(SportProject sportproject);
	public void delete(SportProject sportproject);
	public List<SportProject> find(String id);
	public List<SportProject> findAll();
}
