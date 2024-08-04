package com.example.patient.controller;
import com.example.patient.model.Patient;
import com.example.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patient")

public class PatientController {

    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){this.patientService = patientService;}
   // @Operation(summary = "Gets all Patients",description="Patients must exist");


    @GetMapping("/findAll")
    @ResponseBody
    public Iterable<Patient>findAllPatients(){
        return patientService.findAllPatients();
    }
    @PostMapping("/addPatient")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @PutMapping("/updatePatient/{patient_id}")
    @ResponseBody
    public String updatePatient(@PathVariable String patient_id, @RequestParam String patient_address, @RequestParam String patient_phone, @RequestParam int prior_pregnancies, @RequestParam String occupation){
        patientService.updatePatient(patient_id, patient_address, patient_phone, prior_pregnancies, occupation);
        return "Patient successfully updated";
    }
/*
    @GetMapping("/checkPhone/{patient_phone}")
    @ResponseBody
    public boolean checkPhone(@PathVariable String patient_phone){
        return patientService.checkPhone(patient_phone);


    }*/

    @DeleteMapping("/deletePatient/{patient_id}")
    @ResponseBody
    public String deletePatient(@PathVariable String patient_id){
        patientService.deletePatient(patient_id);
        return "Patient successfully updated";
    }


}