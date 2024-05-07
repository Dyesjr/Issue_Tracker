package com.dyes.issuetracker.aggregate;
//Similar to notificationFlowCommand, where an instance of a request  is created

import com.dyes.issuetracker.command.CreateIssueCommand;
import com.dyes.issuetracker.enums.Priority;
import com.dyes.issuetracker.events.IssueCreatedEvent;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class IssueAggregate {

    @AggregateIdentifier
    private String issueId;
    private String title;
    private String description;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CommandHandler
    public IssueAggregate(CreateIssueCommand createIssueCommand){
        IssueCreatedEvent issueCreatedEvent =
                new IssueCreatedEvent();

        BeanUtils.copyProperties(createIssueCommand,issueCreatedEvent);

        AggregateLifecycle.apply(issueCreatedEvent);
    }

    public IssueAggregate(){

    }

    @EventSourcingHandler
    public void on(IssueCreatedEvent issueCreatedEvent) {
        this.issueId = issueCreatedEvent.getIssueId();
        this.title = issueCreatedEvent.getTitle();
        this.description = issueCreatedEvent.getDescription();
        this.assignee = issueCreatedEvent.getAssignee();
        this.priority = issueCreatedEvent.getPriority();
    }
}
