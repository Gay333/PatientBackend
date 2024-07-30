package com.example.patient.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.patient.model.Nurse;
import com.example.patient.model.Patient;
import com.example.patient.repository.NurseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;
    @Autowired
    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public Iterable<Nurse> findAll(){return nurseRepository.findAll();}
    public Nurse saveNurse(Nurse nurse) {
        //String x = passwordEn(nurse.getPassword());
        //nurse.setPassword(x);
        return nurseRepository.save(nurse);
    }
    public void updateNurse(String nurse_id, String hospital_id, String nurse_phone, String nurse_firstname, String nurse_lastname) {
        Nurse nurse = nurseRepository.findById(nurse_id).orElse(null);
        if (nurse!= null) {
            nurse.setHospital_id(hospital_id);
            nurse.setNurse_firstname(nurse_firstname);
            nurse.setNurse_lastname(nurse_lastname);
            nurse.setNurse_phone(nurse_phone);
            nurseRepository.save(nurse);
            System.out.println("Nurse Updated Successfully!");
        } else {
            System.out.println("Nurse not found.");
        }

    }

    public ResponseEntity<?> checkPassword(String nurse_id, String password){
        //String x = passwordEn(password);
        Iterable<Nurse> nurse = nurseRepository.findPassword(nurse_id,password);
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for(Nurse n:nurse){
            //boolean isPasswordMatch = passwordEncoder.matches(password, n.getPassword());
            //if(isPasswordMatch){return "";}
            if(password.equals(n.getPassword())){return ResponseEntity.ok("Login successful");}
        }
        return ResponseEntity.status(401).body("Invalid credentials");


    }
/*
    public static String passwordEn(String password) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            return hashedPassword;

        }
*/
    public void deleteNurse(String nurse_id) {
        Nurse nurse = nurseRepository.findById(nurse_id).orElse(null);
        if (nurse!= null) {
            nurseRepository.deleteById(nurse_id);
            System.out.println("Nurse Deleted Successfully!");
        } else {
            System.out.println("Nurse not found.");
        }

    }
}
