package com.example.patient.service;


import com.example.patient.model.Medicine_per_Patient;
import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.repository.Medicine_per_PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class Medicine_per_PatientService {
    private final Medicine_per_PatientRepository medicinePerPatientRepository;
    @Autowired
    public Medicine_per_PatientService(Medicine_per_PatientRepository medicinePerPatientRepository){this.medicinePerPatientRepository = medicinePerPatientRepository;}


    public Iterable<Medicine_per_Patient> findAllMedicines(){
        return medicinePerPatientRepository.findAll();
    }

    public Iterable<Medicine_per_Patient> findAllMedicinesPerPatient(String patient_ID){
        return medicinePerPatientRepository.findAllPerPatient(patient_ID);
    }

    public Medicine_per_Patient savePatientMedicine(Medicine_per_Patient patient) {
        return medicinePerPatientRepository.save(patient);
    }

    public List<Medicine_per_Patient> findMedicinePerPatient(String patient_ID, LocalDate start_date, String medicine_id, String timing) {
        return (List<Medicine_per_Patient>) medicinePerPatientRepository.findMedicinePatient(patient_ID, start_date, medicine_id, timing);
    }

    public String updateMedicine(String patient_ID, String new_patient_ID, LocalDate start_date, LocalDate new_start_date, LocalDate end_date, String medicine_id, String new_medicine_id, String purpose, String timing, String new_timing){
        List<Medicine_per_Patient> patient = (List<Medicine_per_Patient>)medicinePerPatientRepository.findMedicinePatient(patient_ID,start_date, medicine_id, timing);
        if(!patient.isEmpty()){
            for(Medicine_per_Patient m: patient){

                m.setMedicine_id(new_medicine_id);
                //m.setPatient_ID(patient_ID);
                m.setPurpose(purpose);
                m.setTiming(new_timing);
                m.setEnd_date(end_date);
                m.setStart_date(new_start_date);
                medicinePerPatientRepository.save(m);
            }
            return "Succuessful Updation!";
        }
        return "Unsuccessful Updation.";

    }

    @Transactional
    public int deletePatientRecord(Iterable<Medicine_per_Patient> patient) {
        try {
            if (patient != null) {
                medicinePerPatientRepository.deleteAll(patient);
                System.out.println("Patient Deleted Successfully!");
                return 1;
            } else {
                System.out.println("Patient not found.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the patient: " + e.getMessage());
        }
        return 0;
    }







}
