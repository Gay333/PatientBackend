package com.example.patient.service;


import com.example.patient.model.Patient;
import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.model.Patient_Tests;
import com.example.patient.repository.Patient_TestsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.patient.service.PredictionService;

@Service
public class Patient_TestsService {
    public final Patient_TestsRepository patientTestsRepository;
    public final PredictionService predictionService;
    @Autowired
    public Patient_TestsService(Patient_TestsRepository patientTestsRepository, PredictionService predictionService){
        this.patientTestsRepository = patientTestsRepository;
        this.predictionService = predictionService;
    }

    public Iterable<Patient_Tests> findAllTests(){
        return patientTestsRepository.findAll();
    }

    public Iterable<Patient_Tests> findTestsPatient(String patient_ID){
        return patientTestsRepository.findPatientTest(patient_ID);
    }

    public Iterable<Patient_Tests> findParticularTest(String patient_ID, String date_of_appointment){
        return patientTestsRepository.findSpecificTest(patient_ID,date_of_appointment);
    }

    /*public Patient_Tests addnewPatientTest(Patient_Tests patient) {
        float x = predictionService.predict(patient);
        patient.getOutcome(x);
        return patientTestsRepository.save(patient);
    }*/
    public Patient_Tests addnewPatientTest(Patient_Tests patient) {
        try {
             //Perform prediction and set the outcome
            float prediction = predictionService.predict(patient);
            patient.setOutcome((int) prediction);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Prediction failed");
       }
        return patientTestsRepository.save(patient);
    }


    @Transactional
    public int deletePatient(Iterable<Patient_Tests> patient) {
        try {

            if (patient != null) {
                patientTestsRepository.deleteAll(patient);
                System.out.println("Patient Test Deleted Successfully!");
                return 1;
            } else {
                System.out.println("Patient not found.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the patient test: " + e.getMessage());
        }
        return 0;
    }

}
