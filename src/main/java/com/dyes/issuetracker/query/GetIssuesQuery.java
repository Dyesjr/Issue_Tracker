package com.dyes.issuetracker.query;

import com.dyes.issuetracker.enums.Priority;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Query;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetIssuesQuery {
    private String title;
    private String description;
    private String assignee;

    @Enumerated(EnumType.STRING)
    private Priority priority;
}
