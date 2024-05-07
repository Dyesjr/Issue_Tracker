package com.dyes.issuetracker.events;

import com.dyes.issuetracker.dto.Issue;
import com.dyes.issuetracker.repository.IssueRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ProcessingGroup("issue")
public class IssueEventsHandler {

    private IssueRepository issueRepository;

    public IssueEventsHandler(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    @EventHandler
    public void on(IssueCreatedEvent event) throws Exception {
        Issue issue = new Issue();
        BeanUtils.copyProperties(event, issue);
        issueRepository.save(issue);
        throw new Exception("Exception Occured");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception{
        throw exception;
    }
}
