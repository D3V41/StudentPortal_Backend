package com.example.studentportal.api;

import com.example.studentportal.model.Material;
import com.example.studentportal.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("material")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public int addMaterial(@Valid @NonNull @RequestBody Material material) {
        return materialService.addMaterial(material);
    }

    @GetMapping
    @PreAuthorize("hasRole('TEACHER')")
    public List<Material> getAllMaterial(){
        return materialService.getAllMaterial();
    }

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public Material getMaterialById(@PathVariable("id") String id){
        return materialService.getMaterialById(id);
    }

    @GetMapping(path = "{subject}/{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public List<Material> getMaterialBySubjectId(@PathVariable("id") String id){
        return materialService.getMaterialBySubjectId(id);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public int updateMaterial(@PathVariable("id") String id,@Valid @NonNull @RequestBody Material material){
        return materialService.updateMaterial(id,material);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public int deleteMaterial(@PathVariable("id") String id){
        return materialService.deleteMaterial(id);
    }

    @DeleteMapping(path = "{subject}/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public int deleteMaterialsBySubjectId(@PathVariable("id") String id){
        return materialService.deleteMaterialsBySubjectId(id);
    }

}
