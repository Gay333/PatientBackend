package com.example.patient.controller;

import com.example.patient.model.Admin;
import com.example.patient.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
    private  final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){this.adminService = adminService;}
    @PostMapping("/adminlogin/{admin_id}/{password}")
    public ResponseEntity<?> adminlogin(@PathVariable int admin_id, @PathVariable String password, HttpSession session){
        Admin a =  adminService.checkPassword(admin_id, password);
        if(a!=null){
            session.setAttribute("admin_id", a.getAdmin_id());
            return ResponseEntity.ok("Login successful");
        }
        else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
    @PostMapping("/adminlogout")
    public ResponseEntity<?> adminlogout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("Logout Successful");
    }
    @GetMapping("/welcome")
    public ResponseEntity<?> welcome(HttpSession session) {
        Integer adminId = (Integer) session.getAttribute("admin_id");
        if (adminId != null) {
            return ResponseEntity.ok("Welcome, Admin ID: " + adminId);
        } else {
            return ResponseEntity.badRequest().body("No admin logged in");
        }
    }
}
*/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/adminlogin/{admin_id}/{password}")
    public ResponseEntity<?> adminLogin(@PathVariable int admin_id, @PathVariable String password, HttpSession session) {
        //System.out.println(admin_id+" "+password);
        Admin a = adminService.checkPassword(admin_id, password);
        if (a != null) {
            session.setAttribute("admin_id", a.getAdmin_id());
            System.out.println("HERE" + a.getAdmin_id());
           System.out.println("HERE"+session.getAttribute("admin_id"));
            //session.setAttribute("admin_id", a.getAdmin_id());
            System.out.println("/n");
            return ResponseEntity.ok("Login successful" + admin_id);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @GetMapping("/adminlogout")
    public ResponseEntity<?> adminLogout(HttpSession session) {
        session.invalidate();
        System.out.println("DONE");
        return ResponseEntity.ok("Logout Successful");
    }

    @GetMapping("/welcome")
    public ResponseEntity<?> welcome(HttpSession session) {
        System.out.println("SECOND" + session.getAttribute("admin_id"));
        Integer adminId = (Integer) session.getAttribute("admin_id");
        if (adminId != null) {
            System.out.println("Welcome Request. ADMIN ID from session " + adminId + " " + session.getAttribute("admin_id"));
            return ResponseEntity.ok("Welcome " + adminId);
        } else {
            return ResponseEntity.badRequest().body("No admin logged in");
        }
        //System.out.println("Welcome");
        //return ResponseEntity.ok("Welcome " );    }
    }
}
