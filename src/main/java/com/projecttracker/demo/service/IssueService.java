package com.projecttracker.demo.service;

import java.util.List;

import com.projecttracker.demo.data.IssueDAO;
import com.projecttracker.demo.model.IssueDetails;


public interface IssueService {
	IssueDAO createIssue(IssueDetails issue);
	List<IssueDAO> getWorkIssues(String category);
	IssueDAO updateIssue(String userId, IssueDetails issue);
	void deleteIssue(String userId);
}
