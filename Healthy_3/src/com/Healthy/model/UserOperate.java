package com.Healthy.model;

import java.sql.Timestamp;

/**
 * UserOperate entity. @author MyEclipse Persistence Tools
 */

public class UserOperate implements java.io.Serializable {

	// Fields

	private Integer operateId;
	private UserMain userMain;
	private String operateBehavior;
	private Timestamp operateTime;
	private String operateIp;

	// Constructors

	/** default constructor */
	public UserOperate() {
	}

	/** minimal constructor */
	public UserOperate(UserMain userMain) {
		this.userMain = userMain;
	}

	/** full constructor */
	public UserOperate(UserMain userMain, String operateBehavior,
			Timestamp operateTime, String operateIp) {
		this.userMain = userMain;
		this.operateBehavior = operateBehavior;
		this.operateTime = operateTime;
		this.operateIp = operateIp;
	}

	// Property accessors

	public Integer getOperateId() {
		return this.operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public UserMain getUserMain() {
		return this.userMain;
	}

	public void setUserMain(UserMain userMain) {
		this.userMain = userMain;
	}

	public String getOperateBehavior() {
		return this.operateBehavior;
	}

	public void setOperateBehavior(String operateBehavior) {
		this.operateBehavior = operateBehavior;
	}

	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateIp() {
		return this.operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

}