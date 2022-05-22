package com.example.studentportal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id @NotNull
    private String studentId;
    @NotNull
    private String studentName;
    @NotNull
    private String studentPassword;
    @NotNull
    private String studentEmail;
    @NotNull
    private String studentGender;
    @NotNull
    private String studentDob;
    @NotNull
    private String studentPhone;
    @NotNull
    private String studentAddress;
    @NotNull
    private String studentNumber;
    @NotNull
    private String studentClass;
    @NotNull
    private String studentBranch;

    public Student(){}

    public Student(String studentId, String studentPassword) {
        this.studentId = studentId;
        this.studentPassword = studentPassword;
    }

    public Student(@JsonProperty("studentId") String studentId, @JsonProperty("studentName") String studentName,
                   @JsonProperty("studentEmail") String studentEmail, @JsonProperty("studentGender") String studentGender,
                   @JsonProperty("studentDob") String studentDob, @JsonProperty("studentPhone")String studentPhone,
                   @JsonProperty("studentAddress") String studentAddress, @JsonProperty("studentNumber")String studentNumber,
                   @JsonProperty("studentClass") String studentClass, @JsonProperty("studentBranch") String studentBranch) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentGender = studentGender;
        this.studentDob = studentDob;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentNumber = studentNumber;
        this.studentClass = studentClass;
        this.studentBranch = studentBranch;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentBranch() { return studentBranch; }

    public void setStudentBranch(String studentBranch) { this.studentBranch = studentBranch; }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
}
