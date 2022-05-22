package com.example.studentportal.model;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="examresult")
public class ExamResult {
    @Id @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String examId;
    @NotNull
    String studentId;
    @NotNull
    String subjectId;
    @NotNull
    String examType;
    @NotNull
    String examDate;
    @NotNull
    String examInternalMark;
    @NotNull
    String examExternalMark;
    @NotNull
    String attendance;


    public ExamResult() {
    }

    public ExamResult(String studentId, String subjectId, String examType, String examDate, String examInternalMark, String examExternalMark, String attendance) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.examType = examType;
        this.examDate = examDate;
        this.examInternalMark = examInternalMark;
        this.examExternalMark = examExternalMark;
        this.attendance = attendance;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamInternalMark() {
        return examInternalMark;
    }

    public void setExamInternalMark(String examInternalMark) {
        this.examInternalMark = examInternalMark;
    }

    public String getExamExternalMark() {
        return examExternalMark;
    }

    public void setExamExternalMark(String examExternalMark) {
        this.examExternalMark = examExternalMark;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
