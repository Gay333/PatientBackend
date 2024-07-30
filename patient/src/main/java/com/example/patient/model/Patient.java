package com.example.patient.model;
import java.util.Date;
import jakarta.persistence.*; // for Spring Boot 3
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="patient_id")
    private String patient_id;

    @Column(name="patient_firstname")
    private String patient_firstname;

    @Column(name="patient_lastname")
    private String patient_lastname;

    @Column(name="patient_phone")
    private String patient_phone;

    @Column(name="patient_address")
    private String patient_address;

    @Column(name="occupation")
    private String occupation;

    @Column(name="patient_DOB")
    private LocalDate patient_DOB;

    @Column(name="patient_age")
    private int patient_age;

    @Column(name="patient_gender")
    private String patient_gender;

    @Column(name="patient_bloodtype")
    private String patient_bloodtype;

    @Column(name="prior_pregnancies")
    private int prior_pregnancies;

    public Patient(){}

    public String getPatient_Id(){
        return patient_id;
    }
    public String getPatient_firstname(){
        return patient_firstname;
    }
    public String getPatient_lastname(){
        return patient_lastname;
    }
    public String getPatient_phone(){
        return patient_phone;
    }
    public String getPatient_address(){
        return patient_address;
    }
    public LocalDate getPatient_DOB(){
        return patient_DOB;
    }
    public String getPatient_gender(){
        return patient_gender;
    }
    public int getPatient_age(){
        return patient_age;
    }
    public String getPatient_bloodtype(){
        return patient_bloodtype;
    }
    public int getPrior_pregnancies(){
        return prior_pregnancies;
    }
    public String getOccupation(){
        return occupation;
    }



    public void setOccupation(String occupation){
        this.occupation = occupation;
    }

    public void setPatient_Id(String patient_id){
        this.patient_id = patient_id;
    }
    public void setPatient_firstname(String patient_firstname){
        this.patient_firstname = patient_firstname;
    }
    public void setPatient_lastname(String patient_lastname){
        this.patient_lastname = patient_lastname;
    }
    public void setPatient_phone(String patient_phone){
        this.patient_phone = patient_phone;
    }
    public void setPatient_address(String patient_address){
        this.patient_address = patient_address;
    }
    public void setPatient_DOB(LocalDate patient_DOB){
        this.patient_DOB = patient_DOB;
    }
    public void setPatient_gender(String patient_gender){
        this.patient_gender = patient_gender;
    }
    public void setPatient_age(int patient_age){
        this.patient_age = patient_age;
    }
    public void  setPatient_bloodtype(String patient_bloodtype){
        this.patient_bloodtype = patient_bloodtype;
    }
    public void setPrior_pregnancies(int prior_pregnancies){
        this.prior_pregnancies = prior_pregnancies;
    }












}
