package com.Healthy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * HealthyShow entity. @author MyEclipse Persistence Tools
 */

public class HealthyShow implements java.io.Serializable {

	// Fields

	private String showId;
	private String showUser;
	private String showTag;
	private String showContent;
	private Timestamp showTime;
	private String showLocation;
	private String showImage;
	private Integer showAgree;
	private Set showReplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public HealthyShow() {
	}

	/** minimal constructor */
	public HealthyShow(String showId, String showUser, String showContent,
			Timestamp showTime) {
		this.showId = showId;
		this.showUser = showUser;
		this.showContent = showContent;
		this.showTime = showTime;
	}

	/** full constructor */
	public HealthyShow(String showId, String showUser, String showTag,
			String showContent, Timestamp showTime, String showLocation,
			String showImage, Integer showAgree, Set showReplies) {
		this.showId = showId;
		this.showUser = showUser;
		this.showTag = showTag;
		this.showContent = showContent;
		this.showTime = showTime;
		this.showLocation = showLocation;
		this.showImage = showImage;
		this.showAgree = showAgree;
		this.showReplies = showReplies;
	}

	// Property accessors

	public String getShowId() {
		return this.showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getShowUser() {
		return this.showUser;
	}

	public void setShowUser(String showUser) {
		this.showUser = showUser;
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

	public Timestamp getShowTime() {
		return this.showTime;
	}

	public void setShowTime(Timestamp showTime) {
		this.showTime = showTime;
	}

	public String getShowLocation() {
		return this.showLocation;
	}

	public void setShowLocation(String showLocation) {
		this.showLocation = showLocation;
	}

	public String getShowImage() {
		return this.showImage;
	}

	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}

	public Integer getShowAgree() {
		return this.showAgree;
	}

	public void setShowAgree(Integer showAgree) {
		this.showAgree = showAgree;
	}

	public Set getShowReplies() {
		return this.showReplies;
	}

	public void setShowReplies(Set showReplies) {
		this.showReplies = showReplies;
	}

}