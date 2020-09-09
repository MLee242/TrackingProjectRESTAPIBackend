package com.projecttracker.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecttracker.demo.data.IssueDAO;
import com.projecttracker.demo.model.IssueDetails;
import com.projecttracker.demo.model.OperationStatusModel;
import com.projecttracker.demo.response.RequestOperationName;
import com.projecttracker.demo.response.RequestOperationStatus;
import com.projecttracker.demo.service.IssueService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/issues")
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@PostMapping(produces= {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE	
	},consumes = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE	
			
	})
	public IssueDAO createIssue(@Valid @RequestBody IssueDetails issue){
		 		
		IssueDAO result = issueService.createIssue(issue);
		return result;
	}
	
	@GetMapping(value="/{categoryId}", produces= {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE	
	})
	public List<IssueDAO> getWorkIssues(@PathVariable("categoryId") String category){
	
		List<IssueDAO> result = issueService.getWorkIssues(category);
		return result;
	}
	
	@PutMapping(path="/{userId}", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	},consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	})
	public IssueDAO updateIssue(@PathVariable("userId") String userId,
			@RequestBody IssueDetails issueDetails) {
		IssueDAO returnValue = issueService.updateIssue(userId, issueDetails);
		return returnValue;
	}
	
	@DeleteMapping(path="/{userId}", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	})
	public OperationStatusModel deleteUser(@PathVariable("userId") String userId) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		

		issueService.deleteIssue(userId);
		
		
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		
		return returnValue;
		
		
	}
	
	
	
}
