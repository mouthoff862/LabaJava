package com.solvd.hospital.entities;

import java.util.List;

public class Patient {
    private int id;
    private String name;
    private String email;
    private int age;
    private PatientChart patientChart;
    private List<Therapy> therapies;
    private List<HospitalTreatment> hospitalTreatments;
    private List<Visit> visits;
    private List<Check> checks;

    public Patient() {
    }

    public Patient(int id) {
        this.id = id;
    }

    public Patient(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PatientChart getPatientChart() {
        return patientChart;
    }

    public void setPatientChart(PatientChart patientChart) {
        this.patientChart = patientChart;
    }

    public List<Therapy> getTherapies() {
        return therapies;
    }

    public void setTherapies(List<Therapy> therapies) {
        this.therapies = therapies;
    }

    public List<HospitalTreatment> getHospitalTreatments() {
        return hospitalTreatments;
    }

    public void setHospitalTreatments(List<HospitalTreatment> hospitalTreatments) {
        this.hospitalTreatments = hospitalTreatments;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
