package com.Healthy.model;

import java.util.Date;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private String userId;
	private UserMain userMain;
	private Boolean userPermission;
	private String userTag;
	private String userLocation;
	private String userSignature;
	private String userTel;
	private String userQq;
	private Integer userLevel;
	private Date userBirth;
	private String userBlood;
	private String userEmotion;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(String userId, UserMain userMain, String userTel) {
		this.userId = userId;
		this.userMain = userMain;
		this.userTel = userTel;
	}

	/** full constructor */
	public UserDetail(String userId, UserMain userMain, Boolean userPermission,
			String userTag, String userLocation, String userSignature,
			String userTel, String userQq, Integer userLevel, Date userBirth,
			String userBlood, String userEmotion) {
		this.userId = userId;
		this.userMain = userMain;
		this.userPermission = userPermission;
		this.userTag = userTag;
		this.userLocation = userLocation;
		this.userSignature = userSignature;
		this.userTel = userTel;
		this.userQq = userQq;
		this.userLevel = userLevel;
		this.userBirth = userBirth;
		this.userBlood = userBlood;
		this.userEmotion = userEmotion;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserMain getUserMain() {
		return this.userMain;
	}

	public void setUserMain(UserMain userMain) {
		this.userMain = userMain;
	}

	public Boolean getUserPermission() {
		return this.userPermission;
	}

	public void setUserPermission(Boolean userPermission) {
		this.userPermission = userPermission;
	}

	public String getUserTag() {
		return this.userTag;
	}

	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}

	public String getUserLocation() {
		return this.userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserSignature() {
		return this.userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserBlood() {
		return this.userBlood;
	}

	public void setUserBlood(String userBlood) {
		this.userBlood = userBlood;
	}

	public String getUserEmotion() {
		return this.userEmotion;
	}

	public void setUserEmotion(String userEmotion) {
		this.userEmotion = userEmotion;
	}

}