package com.example.studentportal.dao;

import com.example.studentportal.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin,String> {
    @Query(value = "SELECT * FROM Admin a WHERE a.adminId = :adminId",
            nativeQuery = true)
    Optional<Admin> findByAdminId(String adminId);

    Boolean existsByAdminId(String adminId);


}
