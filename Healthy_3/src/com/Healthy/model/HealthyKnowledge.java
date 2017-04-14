package com.Healthy.model;

import java.sql.Timestamp;

/**
 * HealthyKnowledge entity. @author MyEclipse Persistence Tools
 */

public class HealthyKnowledge implements java.io.Serializable {

	// Fields

	private String knowledgeId;
	private String knowledgeTitle;
	private String knowledgeContent;
	private Timestamp knowledgeTime;
	private String knowledgeAuthor;

	// Constructors

	/** default constructor */
	public HealthyKnowledge() {
	}

	/** full constructor */
	public HealthyKnowledge(String knowledgeId, String knowledgeTitle,
			String knowledgeContent, Timestamp knowledgeTime,
			String knowledgeAuthor) {
		this.knowledgeId = knowledgeId;
		this.knowledgeTitle = knowledgeTitle;
		this.knowledgeContent = knowledgeContent;
		this.knowledgeTime = knowledgeTime;
		this.knowledgeAuthor = knowledgeAuthor;
	}

	// Property accessors

	public String getKnowledgeId() {
		return this.knowledgeId;
	}

	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getKnowledgeTitle() {
		return this.knowledgeTitle;
	}

	public void setKnowledgeTitle(String knowledgeTitle) {
		this.knowledgeTitle = knowledgeTitle;
	}

	public String getKnowledgeContent() {
		return this.knowledgeContent;
	}

	public void setKnowledgeContent(String knowledgeContent) {
		this.knowledgeContent = knowledgeContent;
	}

	public Timestamp getKnowledgeTime() {
		return this.knowledgeTime;
	}

	public void setKnowledgeTime(Timestamp knowledgeTime) {
		this.knowledgeTime = knowledgeTime;
	}

	public String getKnowledgeAuthor() {
		return this.knowledgeAuthor;
	}

	public void setKnowledgeAuthor(String knowledgeAuthor) {
		this.knowledgeAuthor = knowledgeAuthor;
	}

}