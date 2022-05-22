package com.example.studentportal.service;

import com.example.studentportal.dao.SubjectDao;
import com.example.studentportal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public int saveSubject(Subject subject){
        if(!subjectDao.existsBySubjectId(subject.getSubjectId())){
            subjectDao.save(subject);
            return 1;
        }
        return 0;
    };

    public List<Subject> getAllSubjects(){
        return (List<Subject>) subjectDao.findAll();
    }
    public Subject getSubjectById(String id){
        return subjectDao.findById(id).orElse(null);
    }


    public int deleteSubject(String id){
        if(subjectDao.existsBySubjectId(id)) {
            subjectDao.deleteById(id);
            return 1;
        }
        return 0;
    };

    public int updateSubject(String id,Subject subject){
        subjectDao.findById(id).map((existingSubject)-> {
            existingSubject.setSubjectName(subject.getSubjectName());
            existingSubject.setSubjectCredit(subject.getSubjectCredit());
            existingSubject.setSubjectBranch(subject.getSubjectBranch());
            existingSubject.setSubjectSemester(subject.getSubjectSemester());
            subjectDao.save(existingSubject);
            return 1;
        });
        return 0;

    }
}
