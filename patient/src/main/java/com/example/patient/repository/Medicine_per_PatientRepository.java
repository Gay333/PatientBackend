package com.example.patient.repository;


import com.example.patient.model.Medicine_per_Patient;
import com.example.patient.model.Patient_Medical_Record;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Repository
public interface Medicine_per_PatientRepository extends CrudRepository<Medicine_per_Patient,Integer>{

@Modifying
@Transactional
@Query(value="SELECT * FROM Medicine_Per_Patient p WHERE p.patient_ID=:patient_ID",nativeQuery = true)
Iterable<Medicine_per_Patient> findAllPerPatient(@Param("patient_ID") String patient_ID);



@Query(value = "SELECT * FROM Medicine_Per_Patient p WHERE p.patient_ID=:patient_ID AND p.start_date=:start_date AND p.medicine_id=:medicine_id AND p.timing=:timing", nativeQuery = true)
Iterable<Medicine_per_Patient> findMedicinePatient(@Param("patient_ID") String patient_ID, @Param("start_date") LocalDate start_date, @Param("medicine_id") String medicine_id, @Param("timing") String timing);

}

