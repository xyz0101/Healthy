package com.Healthy.model;

/**
 * HealthyMuscle entity. @author MyEclipse Persistence Tools
 */

public class HealthyMuscle implements java.io.Serializable {

	// Fields

	private Integer muscleId;
	private String muscleImg;
	private String muscleName;
	private String muscleUrl;
	private String muscleAttr;

	// Constructors

	/** default constructor */
	public HealthyMuscle() {
	}

	/** minimal constructor */
	public HealthyMuscle(String muscleImg, String muscleName, String muscleUrl) {
		this.muscleImg = muscleImg;
		this.muscleName = muscleName;
		this.muscleUrl = muscleUrl;
	}

	/** full constructor */
	public HealthyMuscle(String muscleImg, String muscleName, String muscleUrl,
			String muscleAttr) {
		this.muscleImg = muscleImg;
		this.muscleName = muscleName;
		this.muscleUrl = muscleUrl;
		this.muscleAttr = muscleAttr;
	}

	// Property accessors

	public Integer getMuscleId() {
		return this.muscleId;
	}

	public void setMuscleId(Integer muscleId) {
		this.muscleId = muscleId;
	}

	public String getMuscleImg() {
		return this.muscleImg;
	}

	public void setMuscleImg(String muscleImg) {
		this.muscleImg = muscleImg;
	}

	public String getMuscleName() {
		return this.muscleName;
	}

	public void setMuscleName(String muscleName) {
		this.muscleName = muscleName;
	}

	public String getMuscleUrl() {
		return this.muscleUrl;
	}

	public void setMuscleUrl(String muscleUrl) {
		this.muscleUrl = muscleUrl;
	}

	public String getMuscleAttr() {
		return this.muscleAttr;
	}

	public void setMuscleAttr(String muscleAttr) {
		this.muscleAttr = muscleAttr;
	}

}