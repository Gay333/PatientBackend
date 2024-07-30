package com.example.patient.repository;

import com.example.patient.model.Patient;
import com.example.patient.model.Patient_Medical_Record;
import com.example.patient.model.Patient_Tests;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Patient_TestsRepository extends CrudRepository<Patient_Tests,Integer> {
    @Modifying
    @Transactional
    @Query(value="SELECT * FROM Patient_Tests p WHERE p.patient_ID = :patient_ID AND p.Date_of_appointment = :Date_of_appointment",nativeQuery = true)
    Iterable<Patient_Tests> findSpecificTest(@Param("patient_ID") String patient_ID, @Param("Date_of_appointment") String Date_of_appointment);


    @Query(value="SELECT * FROM Patient_Tests p WHERE p.patient_ID = :patient_ID",nativeQuery = true)
    Iterable<Patient_Tests> findPatientTest(@Param("patient_ID") String patient_ID);

    //void setHeart_rate(double heart_rate);
}
