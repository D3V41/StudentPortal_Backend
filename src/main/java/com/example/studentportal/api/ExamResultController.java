package com.example.studentportal.api;

import com.example.studentportal.model.ExamResult;
import com.example.studentportal.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("exam")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamResultController {

    @Autowired
    private ExamResultService examResultService;

    @PostMapping
    @PreAuthorize("hasRole('TEACHER')")
    public String addResult(@Valid @NonNull @RequestBody ExamResult e){
        return examResultService.insertResult(e);
    }

    @GetMapping(path = "{id}/{type}")
    @PreAuthorize("hasRole('TEACHER')")
    public List<ExamResult> getResultByIdAndType(@PathVariable("id") String id, @PathVariable("type") String type){
        return examResultService.getResultByIdAndType(id,type);
    }
    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public List<ExamResult> getResultByStudentId(@PathVariable("id") String id){
        return examResultService.getResultByStudentId(id);
    }
    @GetMapping(path = "result/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ExamResult getResultByResultId(@PathVariable("id") String id){
        return examResultService.getResultByResultId(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('TEACHER')")
    public int updateResultByIdAndType(@Valid @NonNull @RequestBody ExamResult e){
        return examResultService.updateResultByIdAndType(e);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public int deleteResultById(@PathVariable("id") String id){
        return examResultService.deleteResultById(id);
    }
}
