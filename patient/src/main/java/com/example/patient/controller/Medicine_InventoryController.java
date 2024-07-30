package com.example.patient.controller;

import com.example.patient.model.Doctor;
import com.example.patient.model.Medicine_Inventory;
import com.example.patient.service.Medicine_InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/medicine_inventory")
public class Medicine_InventoryController {
    private final Medicine_InventoryService medicineInventoryService;
    @Autowired
    public Medicine_InventoryController(Medicine_InventoryService medicineInventoryService){this.medicineInventoryService = medicineInventoryService;}

    @GetMapping("/findAll")
    public Iterable<Medicine_Inventory> findAllMeds(){
        return medicineInventoryService.findAllMeds();
    }
}
