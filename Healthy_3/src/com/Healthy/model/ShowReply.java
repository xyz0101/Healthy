package com.Healthy.model;

import java.sql.Timestamp;

/**
 * ShowReply entity. @author MyEclipse Persistence Tools
 */

public class ShowReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private HealthyShow healthyShow;
	private String userId;
	private String replyContent;
	private Timestamp replyTime;

	// Constructors

	/** default constructor */
	public ShowReply() {
	}

	/** full constructor */
	public ShowReply(String replyId, HealthyShow healthyShow, String userId,
			String replyContent, Timestamp replyTime) {
		this.replyId = replyId;
		this.healthyShow = healthyShow;
		this.userId = userId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}