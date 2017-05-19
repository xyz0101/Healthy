package com.Healthy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * StadiumMain entity. @author MyEclipse Persistence Tools
 */

public class StadiumMain implements java.io.Serializable {

	// Fields

	private String stadiumId;
	private UserMain userMain;
	private SportProject sportProject;
	private String stadiumName;
	private String stadiumType;
	private String stadiumPrice;
	private String stadiumLocation;
	private String stadiumIntroduction;
	private String stadiumTel;
	private Integer stadiumLevel;
	private String stadiumPhoto;
	private Short stadiumStatus;
	private Set stadiumPlaces = new HashSet(0);
	private Set healthyInvites = new HashSet(0);
	private Set stadiumComments = new HashSet(0);

	// Constructors

	/** default constructor */
	public StadiumMain() {
	}

	/** minimal constructor */
	public StadiumMain(String stadiumId, UserMain userMain,
			SportProject sportProject, String stadiumName,
			String stadiumLocation, String stadiumTel, String stadiumPhoto) {
		this.stadiumId = stadiumId;
		this.userMain = userMain;
		this.sportProject = sportProject;
		this.stadiumName = stadiumName;
		this.stadiumLocation = stadiumLocation;
		this.stadiumTel = stadiumTel;
		this.stadiumPhoto = stadiumPhoto;
	}

	/** full constructor */
	public StadiumMain(String stadiumId, UserMain userMain,
			SportProject sportProject, String stadiumName, String stadiumType,
			String stadiumPrice, String stadiumLocation,
			String stadiumIntroduction, String stadiumTel,
			Integer stadiumLevel, String stadiumPhoto, Short stadiumStatus,
			Set stadiumPlaces, Set healthyInvites, Set stadiumComments) {
		this.stadiumId = stadiumId;
		this.userMain = userMain;
		this.sportProject = sportProject;
		this.stadiumName = stadiumName;
		this.stadiumType = stadiumType;
		this.stadiumPrice = stadiumPrice;
		this.stadiumLocation = stadiumLocation;
		this.stadiumIntroduction = stadiumIntroduction;
		this.stadiumTel = stadiumTel;
		this.stadiumLevel = stadiumLevel;
		this.stadiumPhoto = stadiumPhoto;
		this.stadiumStatus = stadiumStatus;
		this.stadiumPlaces = stadiumPlaces;
		this.healthyInvites = healthyInvites;
		this.stadiumComments = stadiumComments;
	}

	// Property accessors

	public String getStadiumId() {
		return this.stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public UserMain getUserMain() {
		return this.userMain;
	}

	public void setUserMain(UserMain userMain) {
		this.userMain = userMain;
	}

	public SportProject getSportProject() {
		return this.sportProject;
	}

	public void setSportProject(SportProject sportProject) {
		this.sportProject = sportProject;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumType() {
		return this.stadiumType;
	}

	public void setStadiumType(String stadiumType) {
		this.stadiumType = stadiumType;
	}

	public String getStadiumPrice() {
		return this.stadiumPrice;
	}

	public void setStadiumPrice(String stadiumPrice) {
		this.stadiumPrice = stadiumPrice;
	}

	public String getStadiumLocation() {
		return this.stadiumLocation;
	}

	public void setStadiumLocation(String stadiumLocation) {
		this.stadiumLocation = stadiumLocation;
	}

	public String getStadiumIntroduction() {
		return this.stadiumIntroduction;
	}

	public void setStadiumIntroduction(String stadiumIntroduction) {
		this.stadiumIntroduction = stadiumIntroduction;
	}

	public String getStadiumTel() {
		return this.stadiumTel;
	}

	public void setStadiumTel(String stadiumTel) {
		this.stadiumTel = stadiumTel;
	}

	public Integer getStadiumLevel() {
		return this.stadiumLevel;
	}

	public void setStadiumLevel(Integer stadiumLevel) {
		this.stadiumLevel = stadiumLevel;
	}

	public String getStadiumPhoto() {
		return this.stadiumPhoto;
	}

	public void setStadiumPhoto(String stadiumPhoto) {
		this.stadiumPhoto = stadiumPhoto;
	}

	public Short getStadiumStatus() {
		return this.stadiumStatus;
	}

	public void setStadiumStatus(Short stadiumStatus) {
		this.stadiumStatus = stadiumStatus;
	}

	public Set getStadiumPlaces() {
		return this.stadiumPlaces;
	}

	public void setStadiumPlaces(Set stadiumPlaces) {
		this.stadiumPlaces = stadiumPlaces;
	}

	public Set getHealthyInvites() {
		return this.healthyInvites;
	}

	public void setHealthyInvites(Set healthyInvites) {
		this.healthyInvites = healthyInvites;
	}

	public Set getStadiumComments() {
		return this.stadiumComments;
	}

	public void setStadiumComments(Set stadiumComments) {
		this.stadiumComments = stadiumComments;
	}

}