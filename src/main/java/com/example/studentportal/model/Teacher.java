package com.example.studentportal.model;

import com.sun.istack.NotNull;
import jdk.jfr.DataAmount;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.lang.model.element.Name;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teacher")
public class Teacher {

    @Id @NotNull
    private String teacherId;
    @NotNull
    private String teacherName;
    @NotNull
    private String teacherPassword;
    @NotNull
    private String teacherEmail;
    @NotNull
    private String teacherGender;
    @NotNull
    private String teacherDob;
    @NotNull
    private String teacherPhone;
    @NotNull
    private String teacherAddress;
    @NotNull
    private String teacherRole;
    @NotNull
    private String teacherWorkplace;

    public Teacher() {
    }

    public Teacher(String teacherId, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherPassword = teacherPassword;
    }

    public Teacher(String teacherId, String teacherName, String teacherPassword, String teacherEmail, String teacherGender, String teacherDob, String teacherPhone, String teacherAddress, String teacherRole, String teacherWorkplace) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
        this.teacherEmail = teacherEmail;
        this.teacherGender = teacherGender;
        this.teacherDob = teacherDob;
        this.teacherPhone = teacherPhone;
        this.teacherAddress = teacherAddress;
        this.teacherRole = teacherRole;
        this.teacherWorkplace = teacherWorkplace;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherDob() {
        return teacherDob;
    }

    public void setTeacherDob(String teacherDob) {
        this.teacherDob = teacherDob;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(String teacherRole) {
        this.teacherRole = teacherRole;
    }

    public String getTeacherWorkplace() {
        return teacherWorkplace;
    }

    public void setTeacherWorkplace(String teacherWorkplace) {
        this.teacherWorkplace = teacherWorkplace;
    }
}
