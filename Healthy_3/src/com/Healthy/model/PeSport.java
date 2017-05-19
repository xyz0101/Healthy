package com.Healthy.model;

/**
 * PeSport entity. @author MyEclipse Persistence Tools
 */

public class PeSport implements java.io.Serializable {

	// Fields

	private Integer peId;
	private String peContent;
	private String peName;

	// Constructors

	/** default constructor */
	public PeSport() {
	}

	/** full constructor */
	public PeSport(String peContent, String peName) {
		this.peContent = peContent;
		this.peName = peName;
	}

	// Property accessors

	public Integer getPeId() {
		return this.peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

	public String getPeContent() {
		return this.peContent;
	}

	public void setPeContent(String peContent) {
		this.peContent = peContent;
	}

	public String getPeName() {
		return this.peName;
	}

	public void setPeName(String peName) {
		this.peName = peName;
	}

}