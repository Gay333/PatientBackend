package com.example.patient.controller;

import com.example.patient.model.Doctor;
import com.example.patient.repository.DoctorRepository;
import com.example.patient.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){this.doctorService = doctorService;}
    @GetMapping("/findAll")
    public Iterable<Doctor> findAllDoctors(){
        return doctorService.findAllDocs();
    }
}
