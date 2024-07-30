package com.example.patient.service;
import com.example.patient.model.Patient;
import com.example.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Iterable<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void updatePatient(String patient_id, String patient_address, String patient_phone, int prior_pregnancies, String occupation) {
        Patient patient = patientRepository.findById(patient_id).orElse(null);
        if (patient!= null) {
            patient.setPatient_address(patient_address);
            patient.setPatient_phone(patient_phone);
            patient.setPrior_pregnancies(prior_pregnancies);
            patient.setOccupation(occupation);
            patientRepository.save(patient);
            System.out.println("Patient Updated Successfully!");
        } else {
            System.out.println("Patient not found.");
        }

    }

    public String checkPhone(String patient_phone){
        Iterable<Patient> patient = patientRepository.findPhone(patient_phone);
        if(patient!=null){
            return "";

        }
        return "Phone Number not Found!";
    }
    public void deletePatient(String patient_id) {
        Patient patient = patientRepository.findById(patient_id).orElse(null);
        if (patient!= null) {
            patientRepository.deleteById(patient_id);
            System.out.println("Patient Deleted Successfully!");
        } else {
            System.out.println("Patient not found.");
        }

    }
}