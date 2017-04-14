package com.Healthy.model;

import java.util.Date;

/**
 * InviteReply entity. @author MyEclipse Persistence Tools
 */

public class InviteReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private HealthyInvite healthyInvite;
	private String userId;
	private Boolean replyChoose;
	private String replyContent;
	private Date replyTime;

	// Constructors

	/** default constructor */
	public InviteReply() {
	}

	/** minimal constructor */
	public InviteReply(String replyId, HealthyInvite healthyInvite,
			String userId, Boolean replyChoose, Date replyTime) {
		this.replyId = replyId;
		this.healthyInvite = healthyInvite;
		this.userId = userId;
		this.replyChoose = replyChoose;
		this.replyTime = replyTime;
	}

	/** full constructor */
	public InviteReply(String replyId, HealthyInvite healthyInvite,
			String userId, Boolean replyChoose, String replyContent,
			Date replyTime) {
		this.replyId = replyId;
		this.healthyInvite = healthyInvite;
		this.userId = userId;
		this.replyChoose = replyChoose;
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

	public HealthyInvite getHealthyInvite() {
		return this.healthyInvite;
	}

	public void setHealthyInvite(HealthyInvite healthyInvite) {
		this.healthyInvite = healthyInvite;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getReplyChoose() {
		return this.replyChoose;
	}

	public void setReplyChoose(Boolean replyChoose) {
		this.replyChoose = replyChoose;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

}