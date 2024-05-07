package com.dyes.issuetracker.controller;

import com.dyes.issuetracker.model.IssueModel;
import com.dyes.issuetracker.query.GetIssuesQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueQueryController {

    private QueryGateway queryGateway;

    public IssueQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<IssueModel> getAllIssues(){

        GetIssuesQuery getIssuesQuery = new GetIssuesQuery();

        List<IssueModel> issueModels =
        queryGateway.query(getIssuesQuery, ResponseTypes.multipleInstancesOf(IssueModel.class)).join();
        return issueModels;
    }
}
