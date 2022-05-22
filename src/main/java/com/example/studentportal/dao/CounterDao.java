package com.example.studentportal.dao;

import com.example.studentportal.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CounterDao extends JpaRepository<Counter,Integer> {
    @Query(value = "SELECT * FROM Counter c", nativeQuery = true)
    Counter getId();

    @Modifying
    @Query(value = "UPDATE Counter c SET c.studentId = :newid WHERE c.studentId = :oldid", nativeQuery = true)
    void updateStudentId(@Param("oldid") int oid,@Param("newid") int newid);

    @Modifying
    @Query(value = "UPDATE Counter c SET c.teacherId = :newid WHERE c.teacherId = :oldid", nativeQuery = true)
    void updateTeacherId(@Param("oldid") int oid,@Param("newid") int newid);
}
