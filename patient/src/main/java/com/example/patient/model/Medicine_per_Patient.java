package com.example.patient.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Medicine_per_patient")
public class Medicine_per_Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serial_number;

    public String getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(String medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Column(name="patient_ID")
    private String patient_ID;

    @Column(name="medicine_id")
    private String medicine_id;

    @Column(name="purpose")
    private String purpose;

    @Column(name="timing")
    private String timing;

    @Column(name="start_date")
    private LocalDate start_date;

    @Column(name="end_date")
    private LocalDate end_date;

    public Medicine_per_Patient(){}



}