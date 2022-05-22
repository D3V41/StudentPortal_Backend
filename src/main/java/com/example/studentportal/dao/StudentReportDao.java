package com.example.studentportal.dao;

import com.example.studentportal.model.Material;
import com.example.studentportal.model.StudentReport;
import com.example.studentportal.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface StudentReportDao extends JpaRepository<StudentReport,String> {

    @Query(value = "SELECT * FROM StudentReport sr WHERE sr.externalId = :eid AND sr.internalId = :iid", nativeQuery = true)
    List<StudentReport> getStudentByGuideId(@Param("eid") String eid,@Param("iid") String iid);

    @Query(value = "SELECT * FROM StudentReport sr WHERE sr.studentId = :id", nativeQuery = true)
    Optional<StudentReport> getStudentById(@Param("id") String id);

    @Query(value = "SELECT * FROM Teacher t WHERE t.teacherId = :teacherid",nativeQuery = true)
    List<Teacher> getTeacher(@Param("teacherid") String teacherid);

    @Query(value = "SELECT * FROM StudentReport sr WHERE sr.studentId = :sid AND sr.externalId = :eid" +
            " AND sr.internalId = :iid",
            nativeQuery = true)
    String checkStudentReportExist(@Param("sid") String studentid,@Param("eid")String externalid,@Param("iid") String internalid);

    @Query(value = "SELECT * FROM Teacher t WHERE t.teacherId = :teacherid",nativeQuery = true)
    String checkInternalTeacherExist(@Param("teacherid") String teacherid);

    @Query(value = "SELECT * FROM Teacher t WHERE t.teacherId = :teacherid",nativeQuery = true)
    String checkExternalTeacherExist(@Param("teacherid") String teacherid);

    @Query(value = "SELECT * FROM Student s WHERE s.studentId = :studentid",nativeQuery = true)
    String checkStudentExist(@Param("studentid") String teacherid);

    @Modifying
    @Query(value = "UPDATE StudentReport sr SET sr.projectDefinition = :projectdefinition, sr.workLanguage = :worklanguage," +
            "sr.studentPercentage = :studentpercentage,sr.companyResources = :companyresources, sr.joinDate = :joindate, " +
            "sr.endDate = :enddate WHERE sr.studentId = :studentid " +
            "AND sr.internalId = :internalid AND sr.externalId = :externalid",nativeQuery = true)
    int updateStudentReport(@Param("studentid") String studentid,@Param("internalid") String internalid,
                            @Param("externalid") String externalid, @Param("projectdefinition") String projectdefinition,
                            @Param("worklanguage") String worklanguage, @Param("studentpercentage") String studentpercentage,
                            @Param("companyresources") String companyresources,@Param("joindate") String joindate,
                            @Param("enddate") String enddate);

    @Modifying
    @Query("DELETE FROM StudentReport sr where sr.studentId = :id")
    int deleteStudentReportById(@Param("id") String id);


    @Query(value = "SELECT * FROM StudentReport sr WHERE sr.internalId = :id", nativeQuery = true)
    List<StudentReport> getStudentByTeacherId(String id);

    @Query(value = "SELECT * FROM StudentReport sr WHERE sr.externalId = :id", nativeQuery = true)
    List<StudentReport> getStudentByExternalId(String id);
}