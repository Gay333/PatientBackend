package com.example.patient.model;
import jakarta.persistence.*; // for Spring Boot 3
import lombok.Data;

import java.sql.Date;


@Data
@Entity
@Table(name="patient_medical_record")
public class Patient_Medical_Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_no;

    @Column(name="patient_ID")
    private String patient_ID;

    @Column(name="type_of_patient")
    private String type_of_patient;

    @Column(name="doctor_id")
    private String doctor_id;

    @Column(name="hospital_id")
    private String hospital_id;

    @Column(name="time_of_visit")
    private String time_of_visit;

    @Column(name="purpose_of_visit")
    private String purpose_of_visit;

    @Column(name="past_history")
    private String past_history;

    @Column(name="nurse_id")
    private String nurse_id;

    @Column(name="Date_of_appointment")
    private Date Date_of_appointment;

    public Patient_Medical_Record(){}



    public int gets_no(){
        return s_no;
    }
    public void sets_no(int s_no){
        this.s_no = s_no;
    }

    public String getNurse_id(){
        return nurse_id;
    }
    public void setNurse_id(String nurse_id){
        this.nurse_id= nurse_id;
    }

    public String getPatient_id(){
        return patient_ID;
    }
    public void setPatient_id(String patient_ID){
        this.patient_ID = patient_ID;
    }

    public String getType_of_patient(){
        return type_of_patient;
    }
    public void setType_of_patient(String type_of_patient){
        this.type_of_patient = type_of_patient;
    }

    public String getDoctor_id(){
        return doctor_id;
    }
    public void setDoctor_id(String doctor_id){
        this.doctor_id = doctor_id;
    }

    public String getHospital_id(){
        return hospital_id;
    }
    public void setHospital_id(String hospital_id){
        this.hospital_id = hospital_id;
    }

    public String getTime_of_visit(){
        return time_of_visit;
    }
    public void setTime_of_visit(String time_of_visit){
        this.time_of_visit = time_of_visit;
    }

    public String getPurpose_of_visit(){
        return purpose_of_visit;
    }
    public void setPurpose_of_visit(String purpose_of_visit){
        this.purpose_of_visit = purpose_of_visit;
    }


    public String getPast_history(){
        return past_history;
    }
    public void setPast_history(String past_history){
        this.past_history = past_history;
    }

    public Date getDate_of_appointment(){
        return Date_of_appointment;
    }
    public void setDate_of_appointment(Date Date_of_appointment){
        this.Date_of_appointment = Date_of_appointment;
    }


















}
