package com.example.patient.controller;

import com.example.patient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
    private  final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){this.adminService = adminService;}
    @PostMapping("/adminlogin/{admin_id}/{password}")
    public ResponseEntity<?> adminlogin( @PathVariable int admin_id, @PathVariable String password){
        return adminService.checkPassword(admin_id, password);
    }
}
