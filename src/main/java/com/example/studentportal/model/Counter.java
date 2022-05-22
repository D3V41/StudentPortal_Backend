package com.example.studentportal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="counter")
public class Counter {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private int studentId;
    @NotNull
    private int teacherId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
