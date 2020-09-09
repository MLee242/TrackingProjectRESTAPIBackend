package com.projecttracker.demo.model;

public class IssueDetails {
	
	private String title;
	private String summary;
	private String category;
	private String status;
	private String description;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	@Override
	public String toString() {
		return "IssueDetails [title=" + title + ", summary=" + summary + ", category=" + category + ", status=" + status
				+ ", description=" + description + "]";
	}
	
	
}
