package com.example.patient.repository;
import com.example.patient.model.Patient_Medical_Record;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;


@Repository
public interface Patient_Medical_RecordRepository extends CrudRepository<Patient_Medical_Record,Integer> {
    //List<Patient_Medical_Record> findAllByIdIn(List<String> patientIds);

    @Modifying
    @Transactional
    @Query(value="SELECT * FROM Patient_Medical_Record p WHERE p.patient_ID = :patient_ID AND p.type_of_patient = :type_of_patient AND p.Date_of_appointment = :Date_of_appointment",nativeQuery = true)
    Iterable<Patient_Medical_Record> findMedical_Record(@Param("patient_ID") String patient_ID, @Param("type_of_patient") String type_of_patient,@Param("Date_of_appointment") Date Date_of_appointment);

    @Query(value="SELECT * FROM Patient_Medical_Record p WHERE p.patient_ID = :patient_ID",nativeQuery = true)
    List<Patient_Medical_Record> findPatient(@Param("patient_ID") String patient_ID);


}
