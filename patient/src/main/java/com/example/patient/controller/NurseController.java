package com.example.patient.controller;

import com.example.patient.model.Nurse;
import com.example.patient.model.Patient;
import com.example.patient.service.NurseService;
import com.example.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/nurse")
public class NurseController {
    private final NurseService nurseService;
    @Autowired
    public NurseController(NurseService nurseService){this.nurseService = nurseService;}
    @GetMapping("/findAll")
    @ResponseBody
    public Iterable<Nurse>findAll(){
        return nurseService.findAll();
    }
    @PostMapping("/addNurse")
    public Nurse saveNurse(@RequestBody Nurse nurse){
        return nurseService.saveNurse(nurse);
    }

    @PostMapping("/updateNurse/{nurse_id}")
    @ResponseBody
    public String updateNurse(@PathVariable String nurse_id, @RequestParam String hospital_id,@RequestParam String nurse_phone,@RequestParam String nurse_firstname, @RequestParam String nurse_lastname){
        nurseService.updateNurse(nurse_id, hospital_id,nurse_phone,nurse_firstname, nurse_lastname);
        return "Nurse successfully updated";
    }

    @PostMapping("/nurselogin/{nurse_id}/{password}")
    @ResponseBody
    public ResponseEntity<?> checkPassword(@PathVariable String nurse_id, @PathVariable String password){
        ResponseEntity<?> x = nurseService.checkPassword(nurse_id, password);
        return x;

    }
    @DeleteMapping("/deleteNurse/{nurse_id}")
    @ResponseBody
    public String deleteNurse(@PathVariable String nurse_id){
        nurseService.deleteNurse(nurse_id);
        return "Nurse successfully updated";
    }

}
