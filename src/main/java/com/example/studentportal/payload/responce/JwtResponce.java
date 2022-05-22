package com.example.studentportal.payload.responce;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class JwtResponce implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken;
    private String username;
    private String password;
    private List<String> role;

    public JwtResponce(String jwttoken, String username, String password, List<String> role) {
        this.jwttoken = jwttoken;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRole() {
        return role;
    }
}
