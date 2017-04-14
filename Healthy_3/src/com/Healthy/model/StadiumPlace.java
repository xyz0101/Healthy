package com.Healthy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * StadiumPlace entity. @author MyEclipse Persistence Tools
 */

public class StadiumPlace implements java.io.Serializable {

	// Fields

	private String placeId;
	private StadiumMain stadiumMain;
	private String placeName;
	private String placePhoto;
	private String placePrice;
	private String placeLocation;
	private Short placeStatus;
	private Set placeOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public StadiumPlace() {
	}

	/** minimal constructor */
	public StadiumPlace(String placeId, StadiumMain stadiumMain,
			String placeName, String placePrice, String placeLocation,
			Short placeStatus) {
		this.placeId = placeId;
		this.stadiumMain = stadiumMain;
		this.placeName = placeName;
		this.placePrice = placePrice;
		this.placeLocation = placeLocation;
		this.placeStatus = placeStatus;
	}

	/** full constructor */
	public StadiumPlace(String placeId, StadiumMain stadiumMain,
			String placeName, String placePhoto, String placePrice,
			String placeLocation, Short placeStatus, Set placeOrders) {
		this.placeId = placeId;
		this.stadiumMain = stadiumMain;
		this.placeName = placeName;
		this.placePhoto = placePhoto;
		this.placePrice = placePrice;
		this.placeLocation = placeLocation;
		this.placeStatus = placeStatus;
		this.placeOrders = placeOrders;
	}

	// Property accessors

	public String getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public StadiumMain getStadiumMain() {
		return this.stadiumMain;
	}

	public void setStadiumMain(StadiumMain stadiumMain) {
		this.stadiumMain = stadiumMain;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlacePhoto() {
		return this.placePhoto;
	}

	public void setPlacePhoto(String placePhoto) {
		this.placePhoto = placePhoto;
	}

	public String getPlacePrice() {
		return this.placePrice;
	}

	public void setPlacePrice(String placePrice) {
		this.placePrice = placePrice;
	}

	public String getPlaceLocation() {
		return this.placeLocation;
	}

	public void setPlaceLocation(String placeLocation) {
		this.placeLocation = placeLocation;
	}

	public Short getPlaceStatus() {
		return this.placeStatus;
	}

	public void setPlaceStatus(Short placeStatus) {
		this.placeStatus = placeStatus;
	}

	public Set getPlaceOrders() {
		return this.placeOrders;
	}

	public void setPlaceOrders(Set placeOrders) {
		this.placeOrders = placeOrders;
	}

}