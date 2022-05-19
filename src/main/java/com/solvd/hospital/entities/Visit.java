package com.solvd.hospital.entities;

import java.sql.Date;
import java.util.List;

public class Visit {
    private int id;
    private List<Patient> patients;
    private List<Doctor> doctors;
    private Date date;

    public Visit() {
    }

    public Visit(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", patients=" + patients +
                ", doctors=" + doctors +
                ", date=" + date +
                '}';
    }

}
