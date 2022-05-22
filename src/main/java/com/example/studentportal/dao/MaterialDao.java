package com.example.studentportal.dao;

import com.example.studentportal.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialDao extends JpaRepository<Material,String> {

    @Query(value = "SELECT * FROM Material e WHERE e.subjectId = :id", nativeQuery = true)
    List<Material> getMaterialBySubjectId(@Param("id") String id);

    @Query(value = "SELECT * FROM Subject s WHERE s.subjectId = :subjectid",nativeQuery = true)
    String checkSubjectExists(@Param("subjectid") String subjectid);

    @Modifying
    @Query("DELETE FROM Material e where e.subjectId = :id")
    int deleteBySubjectId(@Param("id") String id);

    Boolean existsByMaterialId(String materialId);

}
