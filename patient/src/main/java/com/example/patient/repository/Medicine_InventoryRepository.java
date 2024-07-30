package com.example.patient.repository;


import com.example.patient.model.Medicine_Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Medicine_InventoryRepository extends CrudRepository<Medicine_Inventory, String> {

}
