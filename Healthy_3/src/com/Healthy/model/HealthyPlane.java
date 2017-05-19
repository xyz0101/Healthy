package com.Healthy.model;

/**
 * HealthyPlane entity. @author MyEclipse Persistence Tools
 */

public class HealthyPlane implements java.io.Serializable {

	// Fields

	private Integer planeId;
	private String planeTitle;
	private String planeImg;
	private String planeUrl;
	private String planeAttr;

	// Constructors

	/** default constructor */
	public HealthyPlane() {
	}

	/** minimal constructor */
	public HealthyPlane(String planeTitle, String planeImg, String planeUrl) {
		this.planeTitle = planeTitle;
		this.planeImg = planeImg;
		this.planeUrl = planeUrl;
	}

	/** full constructor */
	public HealthyPlane(String planeTitle, String planeImg, String planeUrl,
			String planeAttr) {
		this.planeTitle = planeTitle;
		this.planeImg = planeImg;
		this.planeUrl = planeUrl;
		this.planeAttr = planeAttr;
	}

	// Property accessors

	public Integer getPlaneId() {
		return this.planeId;
	}

	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}

	public String getPlaneTitle() {
		return this.planeTitle;
	}

	public void setPlaneTitle(String planeTitle) {
		this.planeTitle = planeTitle;
	}

	public String getPlaneImg() {
		return this.planeImg;
	}

	public void setPlaneImg(String planeImg) {
		this.planeImg = planeImg;
	}

	public String getPlaneUrl() {
		return this.planeUrl;
	}

	public void setPlaneUrl(String planeUrl) {
		this.planeUrl = planeUrl;
	}

	public String getPlaneAttr() {
		return this.planeAttr;
	}

	public void setPlaneAttr(String planeAttr) {
		this.planeAttr = planeAttr;
	}

}