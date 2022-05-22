package com.example.studentportal.security.service;

import com.example.studentportal.dao.AdminDao;
import com.example.studentportal.dao.StudentDao;
import com.example.studentportal.dao.TeacherDao;
import com.example.studentportal.model.Admin;
import com.example.studentportal.model.Student;
import com.example.studentportal.model.Teacher;
import com.example.studentportal.security.model.AdminDetails;
import com.example.studentportal.security.model.StudentDetails;
import com.example.studentportal.security.model.TeacherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        String userType = userId.substring(0,1);
        switch (userType) {
            case "A":
                Admin a = adminDao.findByAdminId(userId).
                        orElseThrow(() -> new UsernameNotFoundException("Admin not found with name : " + userId));
                return AdminDetails.build(a);
            case "S":
                Student s = studentDao.findByStudentId(userId).
                        orElseThrow(() -> new UsernameNotFoundException("Student not found with name : " + userId));
                return StudentDetails.build(s);
            case "T":
            case "E":
                Teacher t = teacherDao.findByTeacherId(userId)
                        .orElseThrow(() -> new UsernameNotFoundException("Teacher not found with name : " + userId));
                return TeacherDetails.build(t);
        }
        return null;
    }

    public void insertAdmin(Admin admin) {
        adminDao.save(admin);
    }

    public Boolean checkAdminExists(String adminId){
        return adminDao.existsByAdminId(adminId);
    }
}
