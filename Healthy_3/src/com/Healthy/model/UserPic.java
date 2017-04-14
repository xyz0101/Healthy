package com.Healthy.model;

/**
 * UserPic entity. @author MyEclipse Persistence Tools
 */

public class UserPic implements java.io.Serializable {

	// Fields

	private String userId;
	private UserMain userMain;
	private String userPic;

	// Constructors

	/** default constructor */
	public UserPic() {
	}

	/** minimal constructor */
	public UserPic(String userId, UserMain userMain) {
		this.userId = userId;
		this.userMain = userMain;
	}

	/** full constructor */
	public UserPic(String userId, UserMain userMain, String userPic) {
		this.userId = userId;
		this.userMain = userMain;
		this.userPic = userPic;
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

	public String getUserPic() {
		return this.userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

}