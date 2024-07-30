package com.example.patient.service;

import com.example.patient.model.Admin;
import com.example.patient.model.Nurse;
import com.example.patient.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository){this.adminRepository = adminRepository;}
    public ResponseEntity<?> checkPassword(int admin_id, String password){
        //String x = passwordEn(password);
        Admin admin = adminRepository.findById(admin_id).orElse(null);
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
            //boolean isPasswordMatch = passwordEncoder.matches(password, n.getPassword());
            //if(isPasswordMatch){return "";}
            if(admin!=null){
            if(password.equals(admin.getPassword())){return ResponseEntity.ok("Login successful");}}
        return ResponseEntity.status(401).body("Invalid credentials");


    }
}
