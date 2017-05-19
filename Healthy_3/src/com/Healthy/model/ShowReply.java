package com.Healthy.model;

import java.sql.Timestamp;

/**
 * ShowReply entity. @author MyEclipse Persistence Tools
 */

public class ShowReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private HealthyShow healthyShow;
	private String replyUser;
	private String replyContent;
	private Timestamp replyTime;
	private String replyImage;
	private Integer replyAgree;

	// Constructors

	/** default constructor */
	public ShowReply() {
	}

	/** minimal constructor */
	public ShowReply(String replyId, HealthyShow healthyShow, String replyUser,
			String replyContent, Timestamp replyTime) {
		this.replyId = replyId;
		this.healthyShow = healthyShow;
		this.replyUser = replyUser;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}

	/** full constructor */
	public ShowReply(String replyId, HealthyShow healthyShow, String replyUser,
			String replyContent, Timestamp replyTime, String replyImage,
			Integer replyAgree) {
		this.replyId = replyId;
		this.healthyShow = healthyShow;
		this.replyUser = replyUser;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyImage = replyImage;
		this.replyAgree = replyAgree;
	}

	// Property accessors

	public String getReplyId() {
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public HealthyShow getHealthyShow() {
		return this.healthyShow;
	}

	public void setHealthyShow(HealthyShow healthyShow) {
		this.healthyShow = healthyShow;
	}

	public String getReplyUser() {
		return this.replyUser;
	}

	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyImage() {
		return this.replyImage;
	}

	public void setReplyImage(String replyImage) {
		this.replyImage = replyImage;
	}

	public Integer getReplyAgree() {
		return this.replyAgree;
	}

	public void setReplyAgree(Integer replyAgree) {
		this.replyAgree = replyAgree;
	}

}