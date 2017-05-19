package com.Healthy.model;

import java.sql.Timestamp;

/**
 * SportAdvice entity. @author MyEclipse Persistence Tools
 */

public class SportAdvice implements java.io.Serializable {

	// Fields

	private String adviceId;
	private String adviceTitle;
	private String adviceContent;
	private String adviceImg;
	private Timestamp adviceTime;

	// Constructors

	/** default constructor */
	public SportAdvice() {
	}

	/** full constructor */
	public SportAdvice(String adviceId, String adviceTitle,
			String adviceContent, String adviceImg, Timestamp adviceTime) {
		this.adviceId = adviceId;
		this.adviceTitle = adviceTitle;
		this.adviceContent = adviceContent;
		this.adviceImg = adviceImg;
		this.adviceTime = adviceTime;
	}

	// Property accessors

	public String getAdviceId() {
		return this.adviceId;
	}

	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
	}

	public String getAdviceTitle() {
		return this.adviceTitle;
	}

	public void setAdviceTitle(String adviceTitle) {
		this.adviceTitle = adviceTitle;
	}

	public String getAdviceContent() {
		return this.adviceContent;
	}

	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}

	public String getAdviceImg() {
		return this.adviceImg;
	}

	public void setAdviceImg(String adviceImg) {
		this.adviceImg = adviceImg;
	}

	public Timestamp getAdviceTime() {
		return this.adviceTime;
	}

	public void setAdviceTime(Timestamp adviceTime) {
		this.adviceTime = adviceTime;
	}

}