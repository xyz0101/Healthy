package com.util;

import java.util.Comparator;

import com.Healthy.model.StadiumPlace;

public class Mycompare implements Comparator<StadiumPlace> {

	@Override
	public int compare(StadiumPlace sp1, StadiumPlace sp2) {
		
		return Integer.valueOf(sp1.getPlacePrice())-Integer.valueOf(sp2.getPlacePrice());
	}



}
