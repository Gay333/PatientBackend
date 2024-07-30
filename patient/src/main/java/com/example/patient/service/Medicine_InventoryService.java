package com.example.patient.service;

import com.example.patient.model.Doctor;
import com.example.patient.model.Medicine_Inventory;
import com.example.patient.repository.Medicine_InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Medicine_InventoryService {
    private Medicine_InventoryRepository medicineInventoryRepository;
    @Autowired
    public Medicine_InventoryService(Medicine_InventoryRepository medicineInventoryRepository){this.medicineInventoryRepository = medicineInventoryRepository;}

    public Iterable<Medicine_Inventory> findAllMeds(){
        return medicineInventoryRepository.findAll();
    }
}
