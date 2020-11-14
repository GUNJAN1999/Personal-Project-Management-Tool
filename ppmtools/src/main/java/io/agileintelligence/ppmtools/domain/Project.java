package io.agileintelligence.ppmtools.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="project")
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="projectName")
	@NotBlank(message="PROJECT NAME IS REQUIRED!!")
	private String projectName;
	
	@Column(name="projectIdentifier",updatable=false,unique=true)
	@NotBlank(message="PROJECT IDENTIFIER IS REQUIRED!!")
	@Size(min=4,max=5,message="PROJECT IDENTIFIER SHOULD BE BETWEEN 4 AND 5!!!")
	private String projectIdentifier;
	
	@Column(name="description")
	@NotBlank(message="PROJECT DESCRIPTION IS REQUIRED!!")
	private String description;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	@Column(name="start_date")
	private Date start_date;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	@Column(name="end_date")
	private Date end_date;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	@Column(name="createdAt",updatable=false)
	private Date createdAt;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	@Column(name="updated_At")
	private Date updated_At;
	public Project() {
		
	}
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
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt=new Date();
	}
	@PreUpdate
	protected void onUpdate()
	{
		this.updated_At=new Date();
	}

}
