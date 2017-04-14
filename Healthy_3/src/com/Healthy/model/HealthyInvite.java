package com.Healthy.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * HealthyInvite entity. @author MyEclipse Persistence Tools
 */

public class HealthyInvite implements java.io.Serializable {

	// Fields

	private String inviteId;
	private StadiumMain stadiumMain;
	private String userId;
	private String inviteTitle;
	private String inviteTag;
	private String inviteContent;
	private Timestamp inviteStartTime;
	private Timestamp inviteTime;
	private String inviteUser;
	private Boolean inviteSimilar;
	private Set inviteReplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public HealthyInvite() {
	}

	/** minimal constructor */
	public HealthyInvite(String inviteId, StadiumMain stadiumMain,
			String userId, String inviteTitle, String inviteTag,
			String inviteContent, Timestamp inviteStartTime,
			Timestamp inviteTime, Boolean inviteSimilar) {
		this.inviteId = inviteId;
		this.stadiumMain = stadiumMain;
		this.userId = userId;
		this.inviteTitle = inviteTitle;
		this.inviteTag = inviteTag;
		this.inviteContent = inviteContent;
		this.inviteStartTime = inviteStartTime;
		this.inviteTime = inviteTime;
		this.inviteSimilar = inviteSimilar;
	}

	/** full constructor */
	public HealthyInvite(String inviteId, StadiumMain stadiumMain,
			String userId, String inviteTitle, String inviteTag,
			String inviteContent, Timestamp inviteStartTime,
			Timestamp inviteTime, String inviteUser, Boolean inviteSimilar,
			Set inviteReplies) {
		this.inviteId = inviteId;
		this.stadiumMain = stadiumMain;
		this.userId = userId;
		this.inviteTitle = inviteTitle;
		this.inviteTag = inviteTag;
		this.inviteContent = inviteContent;
		this.inviteStartTime = inviteStartTime;
		this.inviteTime = inviteTime;
		this.inviteUser = inviteUser;
		this.inviteSimilar = inviteSimilar;
		this.inviteReplies = inviteReplies;
	}

	// Property accessors

	public String getInviteId() {
		return this.inviteId;
	}

	public void setInviteId(String inviteId) {
		this.inviteId = inviteId;
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

	public String getInviteTitle() {
		return this.inviteTitle;
	}

	public void setInviteTitle(String inviteTitle) {
		this.inviteTitle = inviteTitle;
	}

	public String getInviteTag() {
		return this.inviteTag;
	}

	public void setInviteTag(String inviteTag) {
		this.inviteTag = inviteTag;
	}

	public String getInviteContent() {
		return this.inviteContent;
	}

	public void setInviteContent(String inviteContent) {
		this.inviteContent = inviteContent;
	}

	public Timestamp getInviteStartTime() {
		return this.inviteStartTime;
	}

	public void setInviteStartTime(Timestamp inviteStartTime) {
		this.inviteStartTime = inviteStartTime;
	}

	public Timestamp getInviteTime() {
		return this.inviteTime;
	}

	public void setInviteTime(Timestamp inviteTime) {
		this.inviteTime = inviteTime;
	}

	public String getInviteUser() {
		return this.inviteUser;
	}

	public void setInviteUser(String inviteUser) {
		this.inviteUser = inviteUser;
	}

	public Boolean getInviteSimilar() {
		return this.inviteSimilar;
	}

	public void setInviteSimilar(Boolean inviteSimilar) {
		this.inviteSimilar = inviteSimilar;
	}

	public Set getInviteReplies() {
		return this.inviteReplies;
	}

	public void setInviteReplies(Set inviteReplies) {
		this.inviteReplies = inviteReplies;
	}

}