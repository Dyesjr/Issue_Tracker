package com.dyes.issuetracker.service;

//import com.dyes.issuetracker.model.Issue;
import com.dyes.issuetracker.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IssueService {

//    private final IssueRepository issueRepository;
//
//    @Autowired
//    public IssueService(IssueRepository issueRepository) {
//        this.issueRepository = issueRepository;
//    }
//
//    //using List is a common practice when you expect multiple results to be returned
//    public List<Issue> getAllIssues() {
//        return issueRepository.findAll();
//    }
//
//    public Issue getIssue(Long id) {
//        return issueRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found with Id: " + id));
//    }
}
