package com.example.patient.service;
import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.repository.Patient_Medical_RecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class Patient_Medical_RecordService {
    private final Patient_Medical_RecordRepository patientMedicalRecordRepository;

    @Autowired

    public Patient_Medical_RecordService(Patient_Medical_RecordRepository patientMedicalRecordRepository) {
        this.patientMedicalRecordRepository = patientMedicalRecordRepository;
    }

    //All Medical Records
    public Iterable<Patient_Medical_Record> findAllMedicalRecords() {
        return patientMedicalRecordRepository.findAll();
    }


    //All records of a singular patient
    public Iterable<Patient_Medical_Record> findAllPatientMedicalRecords(String patient_ID) {
        //List<String> ids = Collections.singletonList(patient_id);
        return patientMedicalRecordRepository.findPatient(patient_ID);
    }


    public Patient_Medical_Record savePatientMedicalRecord(Patient_Medical_Record patient) {
        return patientMedicalRecordRepository.save(patient);
    }

    public Iterable<Patient_Medical_Record> findPatientMedicalRecord(String patient_ID, String type_of_patient, Date Date_of_appointment) {
        return patientMedicalRecordRepository.findMedical_Record(patient_ID, type_of_patient, Date_of_appointment);
    }

    @Transactional
    public int deletePatient(Iterable<Patient_Medical_Record> patient) {
        try {

            if (patient != null) {
                patientMedicalRecordRepository.deleteAll(patient);
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
