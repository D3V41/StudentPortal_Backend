package com.example.studentportal.security.model;

import com.example.studentportal.model.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class StudentDetails implements UserDetails {
    private String studentId;
    private String studentPassword;
    private Set<GrantedAuthority> authorities;

    public StudentDetails(String studentId, String studentPassword, Set<GrantedAuthority> authorities) {
        this.studentId = studentId;
        this.studentPassword = studentPassword;
        this.authorities = authorities;
    }

    public static StudentDetails build(Student student){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));

        return new StudentDetails(
                student.getStudentId(),
                student.getStudentPassword(),
                authorities);

    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return studentPassword;
    }

    @Override
    public String getUsername() {
        return studentId;
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
