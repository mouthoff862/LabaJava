package com.solvd.hospital.entities;

import java.util.List;

public class HospitalTreatment {
    private int id;
    private List<Patient> patients;
    private List<Nurse> nurses;
    private List<HospitalRoom> hospitalRooms;

    public HospitalTreatment() {}

    public HospitalTreatment(int id) {
        this.id = id;
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

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<HospitalRoom> getHospitalRooms() {
        return hospitalRooms;
    }

    public void setHospitalRooms(List<HospitalRoom> hospitalRooms) {
        this.hospitalRooms = hospitalRooms;
    }
}
