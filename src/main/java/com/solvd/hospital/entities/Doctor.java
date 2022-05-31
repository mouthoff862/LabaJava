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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        if (id != doctor.id) return false;
        if (age != doctor.age) return false;
        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        return position != null ? position.equals(doctor.position) : doctor.position == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
