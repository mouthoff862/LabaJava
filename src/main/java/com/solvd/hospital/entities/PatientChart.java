package com.solvd.hospital.entities;

import java.util.List;

public class PatientChart {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private List<Diagnosis> diagnoses;

    public PatientChart() {}

    public PatientChart(int id, Patient patient, Doctor doctor) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
