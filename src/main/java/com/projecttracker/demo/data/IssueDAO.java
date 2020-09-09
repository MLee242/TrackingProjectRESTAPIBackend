package com.projecttracker.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Issues")
public class IssueDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(nullable = false, unique = true)
	private String issueId;
	
	@Column(nullable=false)
	//@NotNull(message = "title cannot be empty")
	//@Size(min=2, message="title needs to be greater than 1")
	private String title;
	
	@Column(nullable=false)
	//@NotNull(message = "summary cannot be empty")
	//@Size(min=2, message="summary needs to be greater than 1")
	private String summary;
	//@NotNull(message = "category cannot be empty")
	//@Size(min=2, message="category length needs to be greater than 1")
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	//@NotNull(message = "status cannot be empty")
	private String status;
	@Column(nullable=false, columnDefinition = "VARCHAR(1337)")
	//@NotNull(message = "description cannot be empty")
	private String description;
	
	public IssueDAO() {
		
	}
	
	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
