package com.Healthy.model;

/**
 * ImgPlay entity. @author MyEclipse Persistence Tools
 */

public class ImgPlay implements java.io.Serializable {

	// Fields

	private String imgId;
	private String imgAddress;
	private String imgTitle;

	// Constructors

	/** default constructor */
	public ImgPlay() {
	}

	/** full constructor */
	public ImgPlay(String imgId, String imgAddress, String imgTitle) {
		this.imgId = imgId;
		this.imgAddress = imgAddress;
		this.imgTitle = imgTitle;
	}

	// Property accessors

	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgAddress() {
		return this.imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public String getImgTitle() {
		return this.imgTitle;
	}

	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}

}