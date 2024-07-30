package com.example.patient.controller;


import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.model.Patient_Tests;
import com.example.patient.service.Patient_TestsService;
//import com.example.patient.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patient_tests")
public class Patient_TestsController {
    private final Patient_TestsService patientTestsService;
    //private final PredictionService predictionService;
//, PredictionService predictionService
    @Autowired
    public Patient_TestsController(Patient_TestsService patientTestsService) {
        this.patientTestsService = patientTestsService;
        //this.predictionService = predictionService;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public Iterable<Patient_Tests> findAllTests() {
        return patientTestsService.findAllTests();
    }

    @GetMapping("/findTestsForPatient/{patient_ID}")
    @ResponseBody
    public Iterable<Patient_Tests> findTestsPatient(@PathVariable String patient_ID) {
        return patientTestsService.findTestsPatient(patient_ID);
    }

    @GetMapping("/findParticularTestOfPatient/{patient_ID}/{Date_of_appointment}")
    @ResponseBody
    public Iterable<Patient_Tests> findParticularTest(@PathVariable String patient_ID, @PathVariable String Date_of_appointment) {
        return patientTestsService.findParticularTest(patient_ID, Date_of_appointment);
    }

    @PostMapping("/addNewTest")
    @ResponseBody
    public Patient_Tests addNewTest(@RequestBody Patient_Tests patient){
        //return patientTestsService.addNewPatientTest(patient);

        return patientTestsService.addnewPatientTest(patient);
    }

    @DeleteMapping("/deleteParticularTest/{patient_ID}/{Date_of_appointment}")
    @ResponseBody
    public String deleteMedicalRecordPatient(@PathVariable String patient_ID, @PathVariable String Date_of_appointment) {
        Iterable<Patient_Tests> patient = patientTestsService.findParticularTest(patient_ID, Date_of_appointment);
        if (patient != null) {
            int x = 0;
            x = patientTestsService.deletePatient(patient);
            if(x==1){
                return "Deleted Successfully!";}
            else{return "Patient not deleted Successfully!";}
        } else {
            return "Patient not found.";
        }
    }


}



