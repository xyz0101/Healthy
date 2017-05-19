package com.Healthy.model;

/**
 * HealthyEquipment entity. @author MyEclipse Persistence Tools
 */

public class HealthyEquipment implements java.io.Serializable {

	// Fields

	private Integer equipmentId;
	private String equipmentName;
	private String equipmentImg;
	private String equipmentUrl;
	private String equipmentAttr;

	// Constructors

	/** default constructor */
	public HealthyEquipment() {
	}

	/** minimal constructor */
	public HealthyEquipment(String equipmentName, String equipmentImg,
			String equipmentUrl) {
		this.equipmentName = equipmentName;
		this.equipmentImg = equipmentImg;
		this.equipmentUrl = equipmentUrl;
	}

	/** full constructor */
	public HealthyEquipment(String equipmentName, String equipmentImg,
			String equipmentUrl, String equipmentAttr) {
		this.equipmentName = equipmentName;
		this.equipmentImg = equipmentImg;
		this.equipmentUrl = equipmentUrl;
		this.equipmentAttr = equipmentAttr;
	}

	// Property accessors

	public Integer getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentImg() {
		return this.equipmentImg;
	}

	public void setEquipmentImg(String equipmentImg) {
		this.equipmentImg = equipmentImg;
	}

	public String getEquipmentUrl() {
		return this.equipmentUrl;
	}

	public void setEquipmentUrl(String equipmentUrl) {
		this.equipmentUrl = equipmentUrl;
	}

	public String getEquipmentAttr() {
		return this.equipmentAttr;
	}

	public void setEquipmentAttr(String equipmentAttr) {
		this.equipmentAttr = equipmentAttr;
	}

}