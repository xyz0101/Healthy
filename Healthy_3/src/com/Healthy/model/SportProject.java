package com.Healthy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * SportProject entity. @author MyEclipse Persistence Tools
 */

public class SportProject implements java.io.Serializable {

	// Fields

	private String projectId;
	private String porjectPic;
	private Set stadiumMains = new HashSet(0);

	// Constructors

	/** default constructor */
	public SportProject() {
	}

	/** minimal constructor */
	public SportProject(String projectId, String porjectPic) {
		this.projectId = projectId;
		this.porjectPic = porjectPic;
	}

	/** full constructor */
	public SportProject(String projectId, String porjectPic, Set stadiumMains) {
		this.projectId = projectId;
		this.porjectPic = porjectPic;
		this.stadiumMains = stadiumMains;
	}

	// Property accessors

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPorjectPic() {
		return this.porjectPic;
	}

	public void setPorjectPic(String porjectPic) {
		this.porjectPic = porjectPic;
	}

	public Set getStadiumMains() {
		return this.stadiumMains;
	}

	public void setStadiumMains(Set stadiumMains) {
		this.stadiumMains = stadiumMains;
	}

}