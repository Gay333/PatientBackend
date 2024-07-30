package com.example.patient.controller;
import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.service.Patient_Medical_RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patient_medical_record")
public class Patient_Medical_RecordController {
    private final Patient_Medical_RecordService patientMedicalRecordService;
    @Autowired
    public Patient_Medical_RecordController(Patient_Medical_RecordService patientMedicalRecordService){this.patientMedicalRecordService = patientMedicalRecordService;}

    @GetMapping("/findAll")
    @ResponseBody
    public Iterable<Patient_Medical_Record> findAllMedicalRecords(){
        return patientMedicalRecordService.findAllMedicalRecords();
    }

    @GetMapping("/findPatientRecords/{patient_ID}")
    @ResponseBody
    public Iterable<Patient_Medical_Record> findPatientMedicalRecords(@PathVariable String patient_ID){
        return patientMedicalRecordService.findAllPatientMedicalRecords(patient_ID);
    }

    @GetMapping("/findOnePatientRecord/{patient_ID}/{type_of_patient}/{Date_of_appointment}")
    @ResponseBody
    public Iterable<Patient_Medical_Record> findOnePatientMedicalRecord(@PathVariable String patient_ID, @PathVariable String type_of_patient, @PathVariable Date Date_of_appointment){
        return patientMedicalRecordService.findPatientMedicalRecord(patient_ID, type_of_patient, Date_of_appointment);
    }


    @PostMapping("/addNewRecord")
    @ResponseBody
    public Patient_Medical_Record addNewMedicalRecord(@RequestBody Patient_Medical_Record patient){

        return patientMedicalRecordService.savePatientMedicalRecord(patient);
    }


    @DeleteMapping("/deleteRecord/{patient_ID}/{type_of_patient}/{Date_of_appointment}")
    @ResponseBody
    public String deleteMedicalRecord(@PathVariable String patient_ID, @PathVariable String type_of_patient, @PathVariable Date Date_of_appointment){
        Iterable<Patient_Medical_Record> patient = patientMedicalRecordService.findPatientMedicalRecord(patient_ID, type_of_patient, Date_of_appointment);
        if (patient != null) {
            int x=0;
            x = patientMedicalRecordService.deletePatient(patient);
            if(x==1){
            return "Deleted Successfully!";}
            else{return "Patient not deleted Successfully!";}
        } else {
            return "Patient not found.";
        }
    }



}
