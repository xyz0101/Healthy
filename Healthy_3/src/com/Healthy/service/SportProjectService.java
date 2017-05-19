package com.Healthy.service;

import java.util.List;

import com.Healthy.model.Page;
import com.Healthy.model.SportProject;

public interface SportProjectService {
		public void update(SportProject sportproject);
		public void add(SportProject sportproject);
		public void delete(String id);
		public List<SportProject> find(String id);
		public List<SportProject> findAll();
		public List findByPage(Page page);
}
