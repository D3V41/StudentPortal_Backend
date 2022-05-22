package com.example.studentportal.dao;

import com.example.studentportal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,String> {
    @Query(value = "SELECT * FROM Student s WHERE s.studentId = :studentId",
            nativeQuery = true)
    Optional<Student> findByStudentId(String studentId);

    Boolean existsByStudentId(String studentId);


}
