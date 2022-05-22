package com.example.studentportal.dao;

import com.example.studentportal.model.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExamResultDao extends JpaRepository<ExamResult,String> {

    @Query(value = "SELECT * FROM ExamResult e WHERE e.examType = :type AND e.studentId = :id",
            nativeQuery = true)
    List<ExamResult> getResultByIdAndType(@Param("id") String id, @Param("type") String type);

    @Query(value = "SELECT * FROM ExamResult e WHERE e.studentId = :id",
            nativeQuery = true)
    List<ExamResult> getResultByStudentId(@Param("id") String id);

    @Query(value = "SELECT * FROM ExamResult e WHERE e.examType = :type AND e.studentId = :studentid " +
            "AND e.subjectId = :subjectid",
            nativeQuery = true)
    String checkResultExist(@Param("studentid") String studentid,@Param("subjectid")String subjectid,@Param("type") String type);

    @Query(value = "SELECT * FROM Student s WHERE s.studentId = :studentid",nativeQuery = true)
    String checkStudentExist(@Param("studentid") String studentid);

    @Query(value = "SELECT * FROM Subject s WHERE s.subjectId = :subjectid",nativeQuery = true)
    String checkSubjectExist(@Param("subjectid") String subjectid);

    @Modifying
    @Query(value = "UPDATE ExamResult e SET e.examDate = :date, e.examInternalMark = :imark," +
            "e.examExternalMark = :emark,e.attendance = :attendance WHERE e.studentId = :studentid " +
            "AND e.subjectId = :subjectid AND e.examType = :type",nativeQuery = true)
    int updateResultByIdAndType(@Param("studentid") String studentid,@Param("subjectid") String subjectid,
                                @Param("type") String type, @Param("date") String date,
                                @Param("imark") String imark, @Param("emark") String emark,
                                @Param("attendance") String attendance);

    @Modifying
    @Query("DELETE FROM ExamResult e where e.examId = :id")
    int deleteResultById(@Param("id") String id);

    Boolean existsByExamId(String examId);
}
