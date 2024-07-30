package com.example.patient.controller;

import com.example.patient.model.Hospital;
import com.example.patient.model.Nurse;
import com.example.patient.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private final HospitalService hospitalService;
    @Autowired
    public HospitalController(HospitalService hospitalService){this.hospitalService = hospitalService;}

    @GetMapping("/findAllHospitals")
    @ResponseBody
    public Iterable<Hospital> findHospitals(){
        return hospitalService.findAllHospitals();
    }
}
