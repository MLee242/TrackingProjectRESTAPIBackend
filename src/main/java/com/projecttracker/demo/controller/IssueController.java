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

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/issues")
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	
	@ApiOperation(value ="Create Issue Web Service Endpoint",
			notes ="This Web Service Endpoint creates Issue and post to database"
			)
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
	
	@ApiOperation(value ="Get All Issues by Category Web Service Endpoint",
			notes ="This Web Service Endpoint gets All Issue by category Id"
			)
	@GetMapping(value="/{categoryId}", produces= {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE	
	})
	public List<IssueDAO> getIssuesByCategory(@PathVariable("categoryId") String category){
	
		List<IssueDAO> result = issueService.getWorkIssues(category);
		return result;
	}
	
	@ApiOperation(value ="Update Issue by issueId Category Web Service Endpoint",
			notes ="This Web Service Endpoint gets All Issue by Issue Id"
			)
	@PutMapping(path="/{issueId}", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	},consumes = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	})
	public IssueDAO updateIssue(@PathVariable("issueId") String issueId,
			@RequestBody IssueDetails issueDetails) {
		IssueDAO returnValue = issueService.updateIssue(issueId, issueDetails);
		return returnValue;
	}
	
	@ApiOperation(value ="Delete Issue by issue Id Category Web Service Endpoint",
			notes ="This Web Service Endpoint gets All Issue by issue Id"
			)
	@DeleteMapping(path="/{issueId}", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			
	})
	public OperationStatusModel deleteUser(@PathVariable("issueId") String issueId) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		

		issueService.deleteIssue(issueId);
		
		
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		
		return returnValue;
		
		
	}
	
	
	
}
