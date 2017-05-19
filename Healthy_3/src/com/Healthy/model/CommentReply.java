package com.Healthy.model;

import java.sql.Timestamp;

/**
 * CommentReply entity. @author MyEclipse Persistence Tools
 */

public class CommentReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private StadiumComment stadiumComment;
	private String replyContent;
	private Timestamp replyTime;
	private String replyUser;
	private Integer replyAgree;
	private String replyImage;

	// Constructors

	/** default constructor */
	public CommentReply() {
	}

	/** minimal constructor */
	public CommentReply(String replyId, StadiumComment stadiumComment,
			String replyContent, Timestamp replyTime, String replyUser) {
		this.replyId = replyId;
		this.stadiumComment = stadiumComment;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyUser = replyUser;
	}

	/** full constructor */
	public CommentReply(String replyId, StadiumComment stadiumComment,
			String replyContent, Timestamp replyTime, String replyUser,
			Integer replyAgree, String replyImage) {
		this.replyId = replyId;
		this.stadiumComment = stadiumComment;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyUser = replyUser;
		this.replyAgree = replyAgree;
		this.replyImage = replyImage;
	}

	// Property accessors

	public String getReplyId() {
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public StadiumComment getStadiumComment() {
		return this.stadiumComment;
	}

	public void setStadiumComment(StadiumComment stadiumComment) {
		this.stadiumComment = stadiumComment;
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

	public String getReplyUser() {
		return this.replyUser;
	}

	public void setReplyUser(String replyUser) {
		this.replyUser = replyUser;
	}

	public Integer getReplyAgree() {
		return this.replyAgree;
	}

	public void setReplyAgree(Integer replyAgree) {
		this.replyAgree = replyAgree;
	}

	public String getReplyImage() {
		return this.replyImage;
	}

	public void setReplyImage(String replyImage) {
		this.replyImage = replyImage;
	}

}