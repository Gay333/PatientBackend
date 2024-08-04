package com.example.patient.controller;

import com.example.patient.model.Nurse;
import com.example.patient.model.Patient;
import com.example.patient.service.NurseService;
import com.example.patient.service.PatientService;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<?> checkPassword(@PathVariable String nurse_id, @PathVariable String password, HttpSession session){
        Iterable<Nurse> nurse = nurseService.checkPassword(nurse_id, password);
        for(Nurse n:nurse){
            if(n!=null){
                session.setAttribute("nurse_id", n.getNurse_id());
                System.out.println("NURSE: "+ session.getAttribute("nurse_id"));
                return ResponseEntity.ok("Login successful" + nurse_id);


            }
        }

        return ResponseEntity.badRequest().body("Invalid credentials");

    }
    @DeleteMapping("/deleteNurse/{nurse_id}")
    @ResponseBody
    public String deleteNurse(@PathVariable String nurse_id){
        nurseService.deleteNurse(nurse_id);
        return "Nurse successfully updated";
    }

    @GetMapping("/nurselogout")
    public ResponseEntity<?> adminLogout(HttpSession session) {
        session.invalidate();
        System.out.println("DONE");
        return ResponseEntity.ok("Logout Successful");
    }
    @GetMapping("/welcome")
    public ResponseEntity<?> welcome(HttpSession session) {
        System.out.println("SECOND" + session.getAttribute("nurse_id"));
        String nurse_id = (String) session.getAttribute("nurse_id");
        if (nurse_id != null) {
            System.out.println("Welcome Request. NURSE ID from session " + nurse_id + " " + session.getAttribute("nurse_id"));
            return ResponseEntity.ok("Welcome " + nurse_id);
        } else {
            return ResponseEntity.badRequest().body("No nurse logged in");
        }
        //System.out.println("Welcome");
        //return ResponseEntity.ok("Welcome " );    }
    }

}
