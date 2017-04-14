package com.Healthy.model;

import java.sql.Timestamp;

/**
 * OrderContent entity. @author MyEclipse Persistence Tools
 */

public class OrderContent implements java.io.Serializable {

	// Fields

	private String contentId;
	private PlaceOrder placeOrder;
	private String userId;
	private Timestamp contentTime;
	private String contentContent;

	// Constructors

	/** default constructor */
	public OrderContent() {
	}

	/** full constructor */
	public OrderContent(String contentId, PlaceOrder placeOrder, String userId,
			Timestamp contentTime, String contentContent) {
		this.contentId = contentId;
		this.placeOrder = placeOrder;
		this.userId = userId;
		this.contentTime = contentTime;
		this.contentContent = contentContent;
	}

	// Property accessors

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public PlaceOrder getPlaceOrder() {
		return this.placeOrder;
	}

	public void setPlaceOrder(PlaceOrder placeOrder) {
		this.placeOrder = placeOrder;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getContentTime() {
		return this.contentTime;
	}

	public void setContentTime(Timestamp contentTime) {
		this.contentTime = contentTime;
	}

	public String getContentContent() {
		return this.contentContent;
	}

	public void setContentContent(String contentContent) {
		this.contentContent = contentContent;
	}

}