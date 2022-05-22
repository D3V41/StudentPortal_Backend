package com.example.studentportal.security.model;

import com.example.studentportal.model.Teacher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class TeacherDetails implements UserDetails {
    private String teacherId;
    private String teacherPassword;
    private Set<GrantedAuthority> authorities;

    public TeacherDetails(String teacherId, String teacherPassword, Set<GrantedAuthority> authorities) {
        this.teacherId = teacherId;
        this.teacherPassword = teacherPassword;
        this.authorities = authorities;
    }

    public static TeacherDetails build(Teacher teacher){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));

        return new TeacherDetails(
                teacher.getTeacherId(),
                teacher.getTeacherPassword(),
                authorities);
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return teacherPassword;
    }

    @Override
    public String getUsername() {
        return teacherId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
