package com.example.patient.service;


import com.example.patient.model.Hospital;
import com.example.patient.repository.HospitalRepository;
import org.apache.tomcat.util.http.parser.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    @Autowired
    public HospitalService(HospitalRepository hospitalRepository){this.hospitalRepository = hospitalRepository;}

    public Iterable<Hospital> findAllHospitals(){
        return hospitalRepository.findAll();
    }
}
