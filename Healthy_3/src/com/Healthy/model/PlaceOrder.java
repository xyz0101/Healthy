package com.Healthy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * PlaceOrder entity. @author MyEclipse Persistence Tools
 */

public class PlaceOrder implements java.io.Serializable {

	// Fields

	private String orderId;
	private StadiumPlace stadiumPlace;
	private String userId;
	private String stadiumId;
	private String orderPlace;
	private Timestamp orderTime;
	private Timestamp orderStartTime;
	private Timestamp orderEndTime;
	private Boolean orderStatus;
	private Set orderContents = new HashSet(0);

	// Constructors

	/** default constructor */
	public PlaceOrder() {
	}

	/** minimal constructor */
	public PlaceOrder(String orderId, StadiumPlace stadiumPlace, String userId,
			String stadiumId, Timestamp orderTime, Timestamp orderStartTime,
			Timestamp orderEndTime, Boolean orderStatus,String orderPlace) {
		this.orderId = orderId;
		this.orderPlace = orderPlace;
		this.stadiumPlace = stadiumPlace;
		this.userId = userId;
		this.stadiumId = stadiumId;
		this.orderTime = orderTime;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderStatus = orderStatus;
	}

	/** full constructor */
	public PlaceOrder(String orderId, StadiumPlace stadiumPlace, String userId,
			String stadiumId, Timestamp orderTime, Timestamp orderStartTime,
			Timestamp orderEndTime, Boolean orderStatus, Set orderContents ,String orderPlace) {
		this.orderId = orderId;
		this.stadiumPlace = stadiumPlace;
		this.orderPlace = orderPlace;
		this.userId = userId;
		this.stadiumId = stadiumId;
		this.orderTime = orderTime;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderStatus = orderStatus;
		this.orderContents = orderContents;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public StadiumPlace getStadiumPlace() {
		return this.stadiumPlace;
	}

	public void setStadiumPlace(StadiumPlace stadiumPlace) {
		this.stadiumPlace = stadiumPlace;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Timestamp getOrderStartTime() {
		return this.orderStartTime;
	}

	public void setOrderStartTime(Timestamp orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public Timestamp getOrderEndTime() {
		return this.orderEndTime;
	}

	public void setOrderEndTime(Timestamp orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public Boolean getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set getOrderContents() {
		return this.orderContents;
	}

	public void setOrderContents(Set orderContents) {
		this.orderContents = orderContents;
	}

	public String getOrderPlace() {
		return orderPlace;
	}

	public void setOrderPlace(String orderPlace) {
		this.orderPlace = orderPlace;
	}

}