package com.example.studentportal.service;

import com.example.studentportal.dao.MaterialDao;
import com.example.studentportal.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaterialService {
    @Autowired
    private MaterialDao materialDao;

    public int addMaterial(Material material) {
        if (materialDao.checkSubjectExists(material.getSubjectId()) != null) {
            materialDao.save(material);
            return 1;
        } else {
            return 0;
        }
    }
    public List<Material> getAllMaterial() {
        return materialDao.findAll();
    }
    public List<Material> getMaterialBySubjectId(String id){
        return materialDao.getMaterialBySubjectId(id);
    }
    public Material getMaterialById(String id){
        return materialDao.findById(id).orElse(null);
    }

    public int updateMaterial(String id,Material material){
        Material existingMaterial = materialDao.findById(id).orElse(null);
        existingMaterial.setMaterialLink(material.getMaterialLink());
        existingMaterial.setMaterialDescription(material.getMaterialDescription());
        existingMaterial.setSubjectId(material.getSubjectId());
        if (materialDao.checkSubjectExists(material.getSubjectId()) != null) {
            materialDao.save(existingMaterial);
            return 1;
        } else {
            return 0;
            // Subject exists
        }

    }

    public int deleteMaterial(String id){
        if(materialDao.existsByMaterialId(id)) {
            materialDao.deleteById(id);
            return 1;
        }
        return 0;
    }

    public int deleteMaterialsBySubjectId(String id){
        if(materialDao.checkSubjectExists(id)!=null) {
            return materialDao.deleteBySubjectId(id);
        }
        return 0;
    }


}
