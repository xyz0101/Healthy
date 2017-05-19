package com.util;

import java.util.Comparator;

import com.Healthy.model.HealthyShow;

public class MycompareTime implements Comparator<HealthyShow> {

	@Override
	public int compare(HealthyShow o1, HealthyShow o2) {
		int result =o1.getShowTime().compareTo(o2.getShowTime());
		return result;
	}

}
