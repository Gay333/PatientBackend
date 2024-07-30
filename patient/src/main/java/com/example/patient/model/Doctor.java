package com.example.patient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    private String doctor_id;

    @Column(name="doctor_firstname")
    private String doctor_firstname;

    @Column(name="doctor_lastname")
    private String doctor_lastname;

    @Column(name="doctor_phone")
    private String doctor_phone;

    @Column(name="doctor_address")
    private String doctor_address;

    @Column(name="specialization")
    private String specialization;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_firstname() {
        return doctor_firstname;
    }

    public void setDoctor_firstname(String doctor_firstname) {
        this.doctor_firstname = doctor_firstname;
    }

    public String getDoctor_lastname() {
        return doctor_lastname;
    }

    public void setDoctor_lastname(String doctor_lastname) {
        this.doctor_lastname = doctor_lastname;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Column(name="hospital_id")
    private String hospital_id;
}
