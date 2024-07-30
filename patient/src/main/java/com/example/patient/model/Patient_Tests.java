package com.example.patient.model;
import jakarta.persistence.*; // for Spring Boot 3
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="patient_tests")
public class Patient_Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int s_no;

    @Getter
    @Setter
    @Column(name="patient_ID")
    private String patient_ID;

    @Getter
    @Setter
    @Column(name="heart_rate")
    private double heart_rate;

    @Getter
    @Setter
    @Column(name="diabetespedigreefunction")
    private double diabetespedigreefunction;

    @Getter
    @Setter
    @Column(name="glucose")
    private double glucose;

    @Getter
    @Setter
    @Column(name="blood_pressure")
    private double blood_pressure;

    @Getter
    @Setter
    @Column(name="skin_thickness")
    private double skin_thickness;

    public double getInsulin() {
        return insulin;
    }

    public void setInsulin(double insulin) {
        this.insulin = insulin;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public String getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        this.patient_ID = patient_ID;
    }

    public double getHeart_rate() {
        return heart_rate;
    }

    public double getDiabetespedigreefunction() {
        return diabetespedigreefunction;
    }

    public void setDiabetespedigreefunction(double diabetespedigreefunction) {
        this.diabetespedigreefunction = diabetespedigreefunction;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    public double getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(double blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public double getSkin_thickness() {
        return skin_thickness;
    }

    public void setSkin_thickness(double skin_thickness) {
        this.skin_thickness = skin_thickness;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getOutcome() {
        return outcome;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    public String getDate_of_appointment() {
        return date_of_appointment;
    }

    public void setDate_of_appointment(String date_of_appointment) {
        this.date_of_appointment = date_of_appointment;
    }

    @Getter
    @Setter
    @Column(name="insulin")
    private double insulin;

    @Getter
    @Setter
    @Column(name="bmi")
    private double bmi;

    @Getter
    @Setter
    @Column(name="outcome")
    private int outcome;

    @Getter
    @Setter
    @Column(name="date_of_appointment")
    private String date_of_appointment;

    public Patient_Tests(){}
    public void setHeart_rate(double heart_rate){
        this.heart_rate = heart_rate;
    }


}
