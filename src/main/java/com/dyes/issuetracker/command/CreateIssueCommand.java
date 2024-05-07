package com.dyes.issuetracker.command;

import com.dyes.issuetracker.enums.Priority;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Getter
@Setter
@Builder
public class CreateIssueCommand {

    @TargetAggregateIdentifier
    private String issueId;
    private String title;
    private String description;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private Priority priority;
}
