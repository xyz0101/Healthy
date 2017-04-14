package com.Healthy.model;

/**
 * Active entity. @author MyEclipse Persistence Tools
 */

public class Active implements java.io.Serializable {

	// Fields

	private Integer activeId;
	private String activeTittle;
	private String activeLink;

	// Constructors

	/** default constructor */
	public Active() {
	}

	/** full constructor */
	public Active(String activeTittle, String activeLink) {
		this.activeTittle = activeTittle;
		this.activeLink = activeLink;
	}

	// Property accessors

	public Integer getActiveId() {
		return this.activeId;
	}

	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
	}

	public String getActiveTittle() {
		return this.activeTittle;
	}

	public void setActiveTittle(String activeTittle) {
		this.activeTittle = activeTittle;
	}

	public String getActiveLink() {
		return this.activeLink;
	}

	public void setActiveLink(String activeLink) {
		this.activeLink = activeLink;
	}

}