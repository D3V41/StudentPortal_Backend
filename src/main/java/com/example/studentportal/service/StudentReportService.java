package com.example.studentportal.service;

import com.example.studentportal.dao.StudentReportDao;
import com.example.studentportal.model.StudentReport;
import com.example.studentportal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentReportService {

    @Autowired
    private StudentReportDao studentReportDao;

    public String insertStudentReport(StudentReport studentReport) {

        studentReportDao.save(studentReport);
        return "Added";

    }

    public List<StudentReport> getStudentByGuideId(String eid, String iid){
        return studentReportDao.getStudentByGuideId(eid,iid);
    }

    public Optional<StudentReport> getStudentById(String id){
        return studentReportDao.findById(id);
    }

    public List<Teacher> getGuideById(String id){
        return studentReportDao.getTeacher(id);
    }

    public int updateStudentReport(StudentReport studentReport){
        studentReportDao.updateStudentReport(studentReport.getStudentId(),studentReport.getInternalId(),
                studentReport.getExternalId(),studentReport.getProjectDefinition(),studentReport.getWorkLanguage(),
                studentReport.getStudentPercentage(),studentReport.getCompanyResources(),studentReport.getJoinDate(),
                studentReport.getEndDate());
        return 1;


    }

    public int deleteStudentReportById(String id){
        return studentReportDao.deleteStudentReportById(id);
    }

    public List<StudentReport> getallReport() {
        return studentReportDao.findAll();
    }

    public List<StudentReport> getStudentByTeacherId(String id) {
        return studentReportDao.getStudentByTeacherId(id);
    }

    public List<StudentReport> getStudentByExternalId(String id) {
        return studentReportDao.getStudentByExternalId(id);
    }
}