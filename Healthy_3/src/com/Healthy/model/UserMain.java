package com.Healthy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * UserMain entity. @author MyEclipse Persistence Tools
 */

public class UserMain implements java.io.Serializable {

	// Fields

	private String userId;
	private String userNickname;
	private String userPassword;
	private String userSex;
	private String userStatus;
	private Set stadiumMains = new HashSet(0);
	private UserDetail userDetail;
	private UserPic userPic;
	private Set userOperates = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserMain() {
	}

	/** minimal constructor */
	public UserMain(String userId, String userNickname, String userPassword,
			String userStatus) {
		this.userId = userId;
		this.userNickname = userNickname;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
	}

	/** full constructor */
	public UserMain(String userId, String userNickname, String userPassword,
			String userSex, String userStatus, Set stadiumMains,
			UserDetail userDetail, UserPic userPic, Set userOperates) {
		this.userId = userId;
		this.userNickname = userNickname;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userStatus = userStatus;
		this.stadiumMains = stadiumMains;
		this.userDetail = userDetail;
		this.userPic = userPic;
		this.userOperates = userOperates;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Set getStadiumMains() {
		return this.stadiumMains;
	}

	public void setStadiumMains(Set stadiumMains) {
		this.stadiumMains = stadiumMains;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public UserPic getUserPic() {
		return this.userPic;
	}

	public void setUserPic(UserPic userPic) {
		this.userPic = userPic;
	}

	public Set getUserOperates() {
		return this.userOperates;
	}

	public void setUserOperates(Set userOperates) {
		this.userOperates = userOperates;
	}

}