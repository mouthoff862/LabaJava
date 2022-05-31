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

    @Override
    public String toString() {
        return "HospitalTreatment{" +
                "id=" + id +
                ", patients=" + patients +
                ", nurses=" + nurses +
                ", hospitalRooms=" + hospitalRooms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalTreatment)) return false;

        HospitalTreatment that = (HospitalTreatment) o;

        if (id != that.id) return false;
        if (patients != null ? !patients.equals(that.patients) : that.patients != null) return false;
        if (nurses != null ? !nurses.equals(that.nurses) : that.nurses != null) return false;
        return hospitalRooms != null ? hospitalRooms.equals(that.hospitalRooms) : that.hospitalRooms == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patients != null ? patients.hashCode() : 0);
        result = 31 * result + (nurses != null ? nurses.hashCode() : 0);
        result = 31 * result + (hospitalRooms != null ? hospitalRooms.hashCode() : 0);
        return result;
    }
}
