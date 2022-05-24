package com.solvd.hospital.entities;

public class Therapy {
    private int id;
    private String patient;
    private String nurse;
    private String medicine;

    public Therapy() {
    }

    public Therapy(int id) {
        this.id = id;
    }

    public Therapy(int id, String patient, String nurse, String medicine) {
        this.id = id;
        this.patient = patient;
        this.nurse = nurse;
        this.medicine = medicine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Therapy{" +
                "id=" + id +
                ", patient='" + patient + '\'' +
                ", nurse='" + nurse + '\'' +
                ", medicine='" + medicine + '\'' +
                '}';
    }
}
