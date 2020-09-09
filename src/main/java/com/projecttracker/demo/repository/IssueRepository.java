package com.projecttracker.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecttracker.demo.data.IssueDAO;

@Repository
public interface IssueRepository extends CrudRepository<IssueDAO, Long>  {
	List<IssueDAO> findAllByCategory(String category);
	IssueDAO findByIssueId(String issueId);
}
