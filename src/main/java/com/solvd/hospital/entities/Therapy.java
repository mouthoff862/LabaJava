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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Therapy)) return false;

        Therapy therapy = (Therapy) o;

        if (id != therapy.id) return false;
        if (patient != null ? !patient.equals(therapy.patient) : therapy.patient != null) return false;
        if (nurse != null ? !nurse.equals(therapy.nurse) : therapy.nurse != null) return false;
        return medicine != null ? medicine.equals(therapy.medicine) : therapy.medicine == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (nurse != null ? nurse.hashCode() : 0);
        result = 31 * result + (medicine != null ? medicine.hashCode() : 0);
        return result;
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
