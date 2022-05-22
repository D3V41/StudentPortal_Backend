package com.example.studentportal.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {

    @Id @NotNull
    private String subjectId;
    @NotNull
    private String subjectName;
    @NotNull
    private String subjectCredit;
    @NotNull
    private String subjectBranch;
    @NotNull
    private String subjectSemester;

    public Subject() {
    }

    public Subject(String subjectId) {
        this.subjectId = subjectId;
    }

    public Subject(String subjectId, String subjectName, String subjectCredit, String subjectBranch, String subjectSemester) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectCredit = subjectCredit;
        this.subjectBranch = subjectBranch;
        this.subjectSemester = subjectSemester;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCredit() {
        return subjectCredit;
    }

    public void setSubjectCredit(String subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public String getSubjectBranch() {
        return subjectBranch;
    }

    public void setSubjectBranch(String subjectBranch) {
        this.subjectBranch = subjectBranch;
    }

    public String getSubjectSemester() {
        return subjectSemester;
    }

    public void setSubjectSemester(String subjectSemester) {
        this.subjectSemester = subjectSemester;
    }
}
