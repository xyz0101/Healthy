package com.Healthy.dao;

import java.util.List;

import com.Healthy.model.ImgPlay;

public interface ImgPlayDAO {
		public void update(ImgPlay img);
		public List findbyid(String id);
}
