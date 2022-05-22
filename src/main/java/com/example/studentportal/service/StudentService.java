package com.example.studentportal.service;

import com.example.studentportal.model.Student;
import com.example.studentportal.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDAO;
    @Autowired
    private CounterService counterService;

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public int insertStudent(Student student) {
        if (!studentDAO.existsByStudentId(student.getStudentId())) {
            studentDAO.save(student);
            return 1;
        } else {
            return 0;
        }
    }

    public Optional<Student> findStudentById(String id) {
        return studentDAO.findById(id);
    }

    public int updateStudentById(String id,Student student) {
        studentDAO.findById(id).map(s -> {
            s.setStudentName(student.getStudentName());
            s.setStudentAddress(student.getStudentAddress());
            s.setStudentClass(student.getStudentClass());
            s.setStudentPassword(student.getStudentPassword());
            s.setStudentDob(student.getStudentDob());
            s.setStudentEmail(student.getStudentEmail());
            s.setStudentGender(student.getStudentGender());
            s.setStudentPhone(student.getStudentPhone());
            s.setStudentNumber(student.getStudentNumber());
            s.setStudentBranch(student.getStudentBranch());
            studentDAO.save(s);
            return 1;
        });
        return 0;
    }

    public int deleteStudentById(String id){
        if(studentDAO.existsByStudentId(id)) {
            studentDAO.deleteById(id);
            return 1;
        }
        return 0;
    }

    public String getStudentId(){
            return "S"+counterService.getStudentId();
    }

}
