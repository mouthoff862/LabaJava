package com.solvd.hospital.entities;

import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private String position;
    private int age;
    private List<Visit> visits;
    private List<PatientChart> patientCharts;

    public Doctor() {
    }

    public Doctor(int id, String name, String position, int age) {
        this.id = id;
        this.name = name;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<PatientChart> getPatientCharts() {
        return patientCharts;
    }

    public void setPatientCharts(List<PatientChart> patientCharts) {
        this.patientCharts = patientCharts;
    }
}
