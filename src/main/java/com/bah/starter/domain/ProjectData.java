package com.bah.starter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class ProjectData {

	@Id
	@GeneratedValue
	private Long id;
	private String projectName;
	private String projectIdentifier;
	private String description;
	private Date startDate;
	private Date targetDate;
	private Date createDate;
	private Date updatedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIndentifier() {
		return projectIdentifier;
	}

	public void setProjectIndentifier(String projectIndentifier) {
		this.projectIdentifier = projectIndentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	@PrePersist
	protected void onCreate() {
		this.createDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {

		this.updatedDate = new Date();

	}

	public ProjectData() {
		super();
	}

}
