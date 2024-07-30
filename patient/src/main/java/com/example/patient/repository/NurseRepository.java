package com.example.patient.repository;

import com.example.patient.model.Nurse;
import com.example.patient.model.Patient_Medical_Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NurseRepository extends CrudRepository<Nurse,String> {
    @Query(value="SELECT * FROM Nurse p WHERE p.nurse_id = :nurse_id AND p.password=:password",nativeQuery = true)
    Iterable<Nurse> findPassword(@Param("nurse_id") String nurse_id, @Param("password") String password);
}
