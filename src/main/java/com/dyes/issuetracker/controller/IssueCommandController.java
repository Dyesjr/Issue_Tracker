package com.dyes.issuetracker.controller;

import com.dyes.issuetracker.command.CreateIssueCommand;
import com.dyes.issuetracker.model.IssueModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/issues")
public class IssueCommandController {

    private CommandGateway commandGateway;

    public IssueCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addIssue(@RequestBody IssueModel issueModel){

        CreateIssueCommand createIssueCommand =
                CreateIssueCommand.builder()
                        .issueId(UUID.randomUUID().toString())
                        .title(issueModel.getTitle())
                        .description(issueModel.getDescription())
                        .assignee(issueModel.getAssignee())
                        .priority(issueModel.getPriority())
                        .build();

       String result = commandGateway.sendAndWait((createIssueCommand));
        return result;
    }
}
