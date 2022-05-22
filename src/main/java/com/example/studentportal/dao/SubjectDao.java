package com.example.studentportal.dao;

import com.example.studentportal.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject,String> {
    Boolean existsBySubjectId(String subjectId);

}
