package com.example.patient.service;

import com.example.patient.model.Doctor;
import com.example.patient.model.Hospital;
import com.example.patient.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    @Autowired
    public DoctorService(DoctorRepository doctorRepository){this.doctorRepository = doctorRepository;}

    public Iterable<Doctor> findAllDocs(){
        return doctorRepository.findAll();
    }
}
