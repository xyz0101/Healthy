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
	private Timestamp orderTime;
	private Timestamp orderStartTime;
	private Timestamp orderEndTime;
	private String orderStatus;
	private String orderPlace;
	private Integer orderPrice;
	private Integer orderNumber;
	private String orderPhoto;
	private String orderComment;
	private Set stadiumPlaces = new HashSet(0);
	private Set orderContents = new HashSet(0);

	// Constructors

	/** default constructor */
	public PlaceOrder() {
	}

	/** minimal constructor */
	public PlaceOrder(String orderId, String userId, String stadiumId,
			Timestamp orderTime, Timestamp orderStartTime,
			Timestamp orderEndTime, String orderStatus, String orderPlace,
			Integer orderPrice, Integer orderNumber, String orderComment) {
		this.orderId = orderId;
		this.userId = userId;
		this.stadiumId = stadiumId;
		this.orderTime = orderTime;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderStatus = orderStatus;
		this.orderPlace = orderPlace;
		this.orderPrice = orderPrice;
		this.orderNumber = orderNumber;
		this.orderComment = orderComment;
	}

	/** full constructor */
	public PlaceOrder(String orderId, StadiumPlace stadiumPlace, String userId,
			String stadiumId, Timestamp orderTime, Timestamp orderStartTime,
			Timestamp orderEndTime, String orderStatus, String orderPlace,
			Integer orderPrice, Integer orderNumber, String orderPhoto,
			String orderComment, Set stadiumPlaces, Set orderContents) {
		this.orderId = orderId;
		this.stadiumPlace = stadiumPlace;
		this.userId = userId;
		this.stadiumId = stadiumId;
		this.orderTime = orderTime;
		this.orderStartTime = orderStartTime;
		this.orderEndTime = orderEndTime;
		this.orderStatus = orderStatus;
		this.orderPlace = orderPlace;
		this.orderPrice = orderPrice;
		this.orderNumber = orderNumber;
		this.orderPhoto = orderPhoto;
		this.orderComment = orderComment;
		this.stadiumPlaces = stadiumPlaces;
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

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderPlace() {
		return this.orderPlace;
	}

	public void setOrderPlace(String orderPlace) {
		this.orderPlace = orderPlace;
	}

	public Integer getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderPhoto() {
		return this.orderPhoto;
	}

	public void setOrderPhoto(String orderPhoto) {
		this.orderPhoto = orderPhoto;
	}

	public String getOrderComment() {
		return this.orderComment;
	}

	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	public Set getStadiumPlaces() {
		return this.stadiumPlaces;
	}

	public void setStadiumPlaces(Set stadiumPlaces) {
		this.stadiumPlaces = stadiumPlaces;
	}

	public Set getOrderContents() {
		return this.orderContents;
	}

	public void setOrderContents(Set orderContents) {
		this.orderContents = orderContents;
	}

}