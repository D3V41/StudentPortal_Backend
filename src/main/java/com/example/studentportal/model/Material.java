package com.example.studentportal.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class Material {
    @Id @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String materialId;
    @NotNull
    private String subjectId;
    @NotNull
    private String materialLink;
    @NotNull
    private String materialDescription;

    public Material() {
    }

    public Material(String materialId, String subjectId, String materialLink, String materialDescription) {
        this.materialId = materialId;
        this.subjectId = subjectId;
        this.materialLink = materialLink;
        this.materialDescription = materialDescription;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getMaterialLink() {
        return materialLink;
    }

    public void setMaterialLink(String materialLink) {
        this.materialLink = materialLink;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }
}
