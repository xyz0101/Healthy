package com.Healthy.service;

import java.util.List;

import com.Healthy.model.SportProject;

public interface SportProjectService {
		public void add(SportProject sportproject);
		public void delete(String id);
		public List<SportProject> find(String id);
		public List<SportProject> findAll();
}
