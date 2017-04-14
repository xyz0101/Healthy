package com.Healthy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * HealthyShow entity. @author MyEclipse Persistence Tools
 */

public class HealthyShow implements java.io.Serializable {

	// Fields

	private String showId;
	private StadiumMain stadiumMain;
	private String userId;
	private String showTitle;
	private String showTag;
	private String showContent;
	private Date showTime;
	private String showLocation;
	private Set showReplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public HealthyShow() {
	}

	/** minimal constructor */
	public HealthyShow(String showId, StadiumMain stadiumMain, String userId,
			String showTag, String showContent, Date showTime,
			String showLocation) {
		this.showId = showId;
		this.stadiumMain = stadiumMain;
		this.userId = userId;
		this.showTag = showTag;
		this.showContent = showContent;
		this.showTime = showTime;
		this.showLocation = showLocation;
	}

	/** full constructor */
	public HealthyShow(String showId, StadiumMain stadiumMain, String userId,
			String showTitle, String showTag, String showContent,
			Date showTime, String showLocation, Set showReplies) {
		this.showId = showId;
		this.stadiumMain = stadiumMain;
		this.userId = userId;
		this.showTitle = showTitle;
		this.showTag = showTag;
		this.showContent = showContent;
		this.showTime = showTime;
		this.showLocation = showLocation;
		this.showReplies = showReplies;
	}

	// Property accessors

	public String getShowId() {
		return this.showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public StadiumMain getStadiumMain() {
		return this.stadiumMain;
	}

	public void setStadiumMain(StadiumMain stadiumMain) {
		this.stadiumMain = stadiumMain;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShowTitle() {
		return this.showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowTag() {
		return this.showTag;
	}

	public void setShowTag(String showTag) {
		this.showTag = showTag;
	}

	public String getShowContent() {
		return this.showContent;
	}

	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}

	public Date getShowTime() {
		return this.showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public String getShowLocation() {
		return this.showLocation;
	}

	public void setShowLocation(String showLocation) {
		this.showLocation = showLocation;
	}

	public Set getShowReplies() {
		return this.showReplies;
	}

	public void setShowReplies(Set showReplies) {
		this.showReplies = showReplies;
	}

}