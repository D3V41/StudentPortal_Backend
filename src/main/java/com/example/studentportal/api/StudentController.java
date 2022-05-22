package com.example.studentportal.api;

import com.example.studentportal.model.Student;
import com.example.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("admin/student")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public StudentController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public int addStudent(@NonNull @Valid @RequestBody Student s){
        s.setStudentPassword(passwordEncoder.encode(s.getStudentDob()));
        return studentService.insertStudent(s);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
    public Optional<Student> getStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }

    @GetMapping(path = "generateId")
    @PreAuthorize("hasRole('ADMIN')")
    public String getStudentId(){
        return studentService.getStudentId();
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public int updateStudentById(@PathVariable("id") String id,@NonNull @Valid @RequestBody Student s){
        s.setStudentPassword(passwordEncoder.encode(s.getStudentDob()));
        return studentService.updateStudentById(id,s);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public int deleteStudentById(@PathVariable("id") String id){
        return studentService.deleteStudentById(id);
    }
}
