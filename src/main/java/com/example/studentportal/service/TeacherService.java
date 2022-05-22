package com.example.studentportal.service;

import com.example.studentportal.dao.TeacherDao;
import com.example.studentportal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private CounterService counterService;

    public int saveTeacher(Teacher teacher){
       if(!teacherDao.existsByTeacherId(teacher.getTeacherId())) {
           teacherDao.save(teacher);
           return 1;
       }
       return 0;
    };

    public List<Teacher> getTeachers(){
        return (List<Teacher>) teacherDao.findAll();
    }
    public Teacher getTeacherById(String id){
        return teacherDao.findById(id).orElse(null);
    }
    /*public Teacher getTeacherByName(String name){
        return teacherDao.findByName(name);
    }*/

    public int deleteTeacher(String id){
        if(teacherDao.existsByTeacherId(id)) {
            teacherDao.deleteById(id);
            return 1;
        }
        return 0;
    };

    public int updateTeacher(String id,Teacher teacher){
        teacherDao.findById(id).map(existingTeacher -> {
            existingTeacher.setTeacherEmail(teacher.getTeacherEmail());
            existingTeacher.setTeacherName(teacher.getTeacherName());
            existingTeacher.setTeacherGender(teacher.getTeacherGender());
            existingTeacher.setTeacherDob(teacher.getTeacherDob());
            existingTeacher.setTeacherPhone(teacher.getTeacherPhone());
            existingTeacher.setTeacherAddress(teacher.getTeacherAddress());
            existingTeacher.setTeacherPassword(teacher.getTeacherPassword());
            existingTeacher.setTeacherRole(teacher.getTeacherRole());
            existingTeacher.setTeacherWorkplace(teacher.getTeacherWorkplace());
            teacherDao.save(existingTeacher);
            return 1;
        });
        return 0;

    }

    public String getTeacherId(){
        return "T"+counterService.getTeacherId();
    }

    public String getExternalId(){
        return "E"+counterService.getTeacherId();
    }
}
