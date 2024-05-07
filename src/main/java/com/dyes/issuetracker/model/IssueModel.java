package com.dyes.issuetracker.model;
import com.dyes.issuetracker.enums.Priority;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class IssueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String issueId;
    private String title;
    private String description;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private Priority priority;
}
