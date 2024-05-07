package com.dyes.issuetracker.query.projection;

import com.dyes.issuetracker.dto.Issue;
import com.dyes.issuetracker.model.IssueModel;
import com.dyes.issuetracker.query.GetIssuesQuery;
import com.dyes.issuetracker.repository.IssueRepository;
import lombok.Setter;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueProjection {

    private IssueRepository issueRepository;

    public IssueProjection(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @QueryHandler
    public List<IssueModel> handle(GetIssuesQuery getIssuesQuery){
        List<Issue> issues = issueRepository.findAll();

        List<IssueModel> issueModels = issues.stream()
                .map(issue -> IssueModel
                        .builder()
                        .issueId(issue.getIssueId())
                        .title(issue.getTitle())
                        .description(issue.getDescription())
                        .assignee(issue.getAssignee())
                        .priority(issue.getPriority())
                        .build())
                .collect(Collectors.toList());

        return issueModels;

    }
}
