package com.example.studentportal.dao;

import com.example.studentportal.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportDao extends JpaRepository<Report,String> {

    @Query(value = "SELECT * FROM Report r WHERE r.studentId = :studentId",
            nativeQuery = true)
    List<Report> findReportByStudentId(String studentId);
}