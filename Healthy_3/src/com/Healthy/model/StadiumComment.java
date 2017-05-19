package com.Healthy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StadiumComment entity. @author MyEclipse Persistence Tools
 */

public class StadiumComment implements java.io.Serializable {

	// Fields

	private String commentId;
	private StadiumMain stadiumMain;
	private String commentContent;
	private String commentImage;
	private Timestamp commentTime;
	private Integer commentAgree;
	private String commentReplay;
	private String commentUser;
	private Set commentReplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public StadiumComment() {
	}

	/** minimal constructor */
	public StadiumComment(String commentId, StadiumMain stadiumMain,
			String commentContent, Timestamp commentTime, String commentUser) {
		this.commentId = commentId;
		this.stadiumMain = stadiumMain;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentUser = commentUser;
	}

	/** full constructor */
	public StadiumComment(String commentId, StadiumMain stadiumMain,
			String commentContent, String commentImage, Timestamp commentTime,
			Integer commentAgree, String commentReplay, String commentUser,
			Set commentReplies) {
		this.commentId = commentId;
		this.stadiumMain = stadiumMain;
		this.commentContent = commentContent;
		this.commentImage = commentImage;
		this.commentTime = commentTime;
		this.commentAgree = commentAgree;
		this.commentReplay = commentReplay;
		this.commentUser = commentUser;
		this.commentReplies = commentReplies;
	}

	// Property accessors

	public String getCommentId() {
		return this.commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public StadiumMain getStadiumMain() {
		return this.stadiumMain;
	}

	public void setStadiumMain(StadiumMain stadiumMain) {
		this.stadiumMain = stadiumMain;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentImage() {
		return this.commentImage;
	}

	public void setCommentImage(String commentImage) {
		this.commentImage = commentImage;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getCommentAgree() {
		return this.commentAgree;
	}

	public void setCommentAgree(Integer commentAgree) {
		this.commentAgree = commentAgree;
	}

	public String getCommentReplay() {
		return this.commentReplay;
	}

	public void setCommentReplay(String commentReplay) {
		this.commentReplay = commentReplay;
	}

	public String getCommentUser() {
		return this.commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	public Set getCommentReplies() {
		return this.commentReplies;
	}

	public void setCommentReplies(Set commentReplies) {
		this.commentReplies = commentReplies;
	}

}