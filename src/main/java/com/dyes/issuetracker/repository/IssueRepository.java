package com.dyes.issuetracker.repository;

//import com.dyes.issuetracker.model.Issue;
import com.dyes.issuetracker.dto.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
