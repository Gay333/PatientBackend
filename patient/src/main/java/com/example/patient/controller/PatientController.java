package com.example.patient.controller;
import com.example.patient.model.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private final PatientRepository patientRepository;
    @Autowired
    public PatientController(PatientService patientService, PatientRepository patientRepository){this.patientService = patientService; this.patientRepository=patientRepository;}
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



    @GetMapping("/welcome")
    public ResponseEntity<?> welcome(HttpSession session) {
        System.out.println("SECOND" + session.getAttribute("patient_id"));
        String patient_id = (String) session.getAttribute("patient_id");
        Patient p = patientRepository.findById(patient_id).orElse(null);
        if (patient_id != null) {
            System.out.println("Welcome Request. patient_firstname ID from session " + patient_id + " " + session.getAttribute("patient_id"));
            return ResponseEntity.ok("Welcome " + p.getPatient_firstname());
        } else {
            return ResponseEntity.badRequest().body("No patient logged in");
        }
        //System.out.println("Welcome");
        //return ResponseEntity.ok("Welcome " );    }
    }

    @GetMapping("/patientlogout")
    public ResponseEntity<?> patientlogout(HttpSession session) {
        session.invalidate();
        System.out.println("DONE");
        return ResponseEntity.ok("Logout Successful");
    }

    @GetMapping("/getID")
    public String getID(HttpSession session) {
        //session.invalidate();
        //System.out.println("DONE");
        System.out.println((String) session.getAttribute("patient_id"));
        return (String) session.getAttribute("patient_id");
    }




}