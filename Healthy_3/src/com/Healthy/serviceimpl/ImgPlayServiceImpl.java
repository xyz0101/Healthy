package com.Healthy.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Healthy.dao.ImgPlayDAO;
import com.Healthy.model.ImgPlay;
import com.Healthy.service.ImgPlayService;
@Service
public class ImgPlayServiceImpl implements ImgPlayService {
	@Autowired
	ImgPlayDAO imgplaydao;
	@Override
	public void update(String id, String tittle, String address) {
		// TODO Auto-generated method stub
			ImgPlay img = new ImgPlay();
			img.setImgId(id);
			img.setImgAddress(address);
			img.setImgTitle(tittle);
			imgplaydao.update(img);
	}

}
