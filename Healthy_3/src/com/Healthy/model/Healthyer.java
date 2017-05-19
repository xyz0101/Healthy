package com.Healthy.model;

/**
 * Healthyer entity. @author MyEclipse Persistence Tools
 */

public class Healthyer implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPassword;
	private String adminStatus;

	// Constructors

	/** default constructor */
	public Healthyer() {
	}

	/** full constructor */
	public Healthyer(String adminName, String adminPassword, String adminStatus) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminStatus = adminStatus;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminStatus() {
		return this.adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

}