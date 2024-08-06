package com.example.patient.repository;
import com.example.patient.model.Patient;
import com.example.patient.model.Patient_Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient,String>{
    //List<Patient> findAllById(String patient_id);
    //List<Patient> findByFirstName(String patient_firstName);
    @Query(value="SELECT * FROM Patient p WHERE p.patient_phone = :patient_phone",nativeQuery = true)
    Iterable<Patient> findPhone(@Param("patient_phone") String patient_phone);



}





