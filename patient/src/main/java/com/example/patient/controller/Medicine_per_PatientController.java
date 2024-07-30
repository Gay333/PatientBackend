package com.example.patient.controller;


import com.example.patient.model.Medicine_per_Patient;
import com.example.patient.service.Medicine_per_PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicine_per_patient")
public class Medicine_per_PatientController {
    private final Medicine_per_PatientService medicinePerPatientService;
    @Autowired
    public Medicine_per_PatientController(Medicine_per_PatientService medicinePerPatientService){this.medicinePerPatientService = medicinePerPatientService;}

    @GetMapping("/findAllMedicineRecords")
    @ResponseBody
    public Iterable<Medicine_per_Patient> findMedicines(){
        return medicinePerPatientService.findAllMedicines();
    }

    @GetMapping("/findAllMedicinesForPatient/{patient_ID}")
    @ResponseBody
    public Iterable<Medicine_per_Patient> findPatientMedicines(@PathVariable String patient_ID){
        return medicinePerPatientService.findAllMedicinesPerPatient(patient_ID);
    }


    @GetMapping("/findParticularMedicine/{patient_ID}/{start_date}/{medicine_id}/{timing}")
    @ResponseBody
    public Iterable<Medicine_per_Patient> findParticularPatientMedicines(@PathVariable String patient_ID, @PathVariable LocalDate start_date, @PathVariable String medicine_id, @PathVariable String timing){
        System.out.println(start_date);
        return medicinePerPatientService.findMedicinePerPatient(patient_ID, start_date, medicine_id, timing);
    }

    @PostMapping("/addNewMedicine")
    @ResponseBody
    public Medicine_per_Patient addNewMedicineRecord(@RequestBody Medicine_per_Patient patient){
        System.out.println("Received data: " + patient.getPatient_ID()+ patient.getMedicine_id()+patient.getEnd_date()+patient.getStart_date()+patient.getPurpose()+patient.getTiming());
        return medicinePerPatientService.savePatientMedicine(patient);
    }


    @PostMapping("/updateMedicineRecordPerPatient/{patient_ID}/{medicine_id}/{start_date}/{timing}")
    @ResponseBody
    public String updateMedicineRecord(@PathVariable String patient_ID, @RequestParam String new_patient_ID, @RequestParam String medicine_id, @RequestParam String new_medicine_id, @PathVariable LocalDate start_date, @RequestParam LocalDate new_start_date, @RequestParam LocalDate end_date, @RequestParam String purpose, @RequestParam String timing, @RequestParam String new_timing){
        return medicinePerPatientService.updateMedicine(patient_ID,new_patient_ID,start_date,new_start_date,end_date,medicine_id, new_medicine_id,purpose, timing,new_timing);

    }

    @DeleteMapping("/deleteMedicineRecordPerPatient/{patient_ID}/{start_date}/{medicine_id}/{timing}")
    @ResponseBody
    public void deleteMedicineRecordPerPatient(@PathVariable String patient_ID, @PathVariable LocalDate start_date, @PathVariable String medicine_id, @PathVariable String timing){
        Iterable<Medicine_per_Patient> patient = medicinePerPatientService.findMedicinePerPatient(patient_ID, start_date, medicine_id, timing);
        int x = 0;
        x = medicinePerPatientService.deletePatientRecord(patient);
        if(x==1){System.out.println("Successfully deleted!");}
        else{System.out.println("Not successful!");}
    }






}
