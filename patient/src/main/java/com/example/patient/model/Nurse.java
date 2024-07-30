package com.example.patient.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="nurse")
public class Nurse {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="nurse_id")
    private String nurse_id;

    public String getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(String nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getNurse_firstname() {
        return nurse_firstname;
    }

    public void setNurse_firstname(String nurse_firstname) {
        this.nurse_firstname = nurse_firstname;
    }

    public String getNurse_lastname() {
        return nurse_lastname;
    }

    public void setNurse_lastname(String nurse_lastname) {
        this.nurse_lastname = nurse_lastname;
    }

    public String getNurse_phone() {
        return nurse_phone;
    }

    public void setNurse_phone(String nurse_phone) {
        this.nurse_phone = nurse_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Column(name="nurse_firstname")
    private String nurse_firstname;

    @Column(name="nurse_lastname")
    private String nurse_lastname;

    @Column(name="nurse_phone")
    private String nurse_phone;

    @Column(name="password")
    private String password;

    @Column(name="hospital_id")
    private String hospital_id;


    @Column(name="nurse_address")
    private String nurse_address;

    public String getNurse_address() {
        return nurse_address;
    }

    public void setNurse_address(String nurse_address) {
        this.nurse_address = nurse_address;
    }
}
