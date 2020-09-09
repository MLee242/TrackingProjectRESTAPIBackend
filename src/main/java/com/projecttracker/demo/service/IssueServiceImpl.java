package com.projecttracker.demo.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecttracker.demo.data.IssueDAO;
import com.projecttracker.demo.model.IssueDetails;
import com.projecttracker.demo.repository.IssueRepository;
import com.projecttracker.demo.shared.Utils;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueRepository issueRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public IssueDAO createIssue(IssueDetails issue) {
		ModelMapper modelMapper = new ModelMapper();
		IssueDAO issueDAO = modelMapper.map(issue, IssueDAO.class);
		issueDAO.setUserId(utils.generateUserId(30));
		IssueDAO result = issueRepository.save(issueDAO);
		return result;
	}

	@Override
	public List<IssueDAO> getWorkIssues(String category) {
		List<IssueDAO> result = new LinkedList<>();
		result = issueRepository.findAllByCategory(category);
		
		return result;
	}

	@Override
	public IssueDAO updateIssue(String userId, IssueDetails issue) {
		IssueDAO issueEntity = issueRepository.findByUserId(userId);
		if(issueEntity == null) {
			throw new NoSuchElementException();
		}
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(issue, issueEntity);
		issueRepository.save(issueEntity);
		return issueEntity;
		
	}

	@Override
	public void deleteIssue(String userId) {
		IssueDAO issueEntity = issueRepository.findByUserId(userId);
		if(issueEntity == null) {
			throw new NoSuchElementException();
		}
		issueRepository.delete(issueEntity);
	}

}
