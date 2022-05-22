package com.example.studentportal.security.api;

import com.example.studentportal.model.Admin;
import com.example.studentportal.payload.request.LoginRequest;
import com.example.studentportal.payload.responce.JwtResponce;
import com.example.studentportal.security.jwt.JwtUtils;
import com.example.studentportal.security.model.AdminDetails;
import com.example.studentportal.security.model.StudentDetails;
import com.example.studentportal.security.model.TeacherDetails;
import com.example.studentportal.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest l){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(l.getUsername(),l.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateAdminJwtToken(authentication);

        String userType = l.getUsername().substring(0,1);
        switch (userType) {
            case "A": {
                AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();

                List<String> roles = adminDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponce(jwt,
                        adminDetails.getUsername(),
                        adminDetails.getPassword(),
                        roles));
            }
            case "S": {
                StudentDetails studentDetails = (StudentDetails) authentication.getPrincipal();

                List<String> roles = studentDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponce(jwt,
                        studentDetails.getUsername(),
                        studentDetails.getPassword(),
                        roles));
            }
            case "T":
            case "E": {
                TeacherDetails teacherDetails = (TeacherDetails) authentication.getPrincipal();

                List<String> roles = teacherDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponce(jwt,
                        teacherDetails.getUsername(),
                        teacherDetails.getPassword(),
                        roles));
            }
        }

        return ResponseEntity.ok("Invalid username");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerAdmin(@NonNull @Valid @RequestBody Admin a){
        if(myUserDetailsService.checkAdminExists(a.getAdminId())){
            return ResponseEntity.badRequest()
                    .body("Error : Admin is already taken");
        }

        Admin admin = new Admin(a.getAdminId(),passwordEncoder.encode(a.getAdminPassword()));

        myUserDetailsService.insertAdmin(admin);

        return ResponseEntity.ok("Admin Registered!!!");
    }
}
