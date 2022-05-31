package com.solvd.hospital.entities;

public class PatientChart {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Diagnosis diagnosis;

    public PatientChart() {}

    public PatientChart(int id, Patient patient, Doctor doctor, Diagnosis diagnosis) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
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

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientChart)) return false;

        PatientChart that = (PatientChart) o;

        if (id != that.id) return false;
        if (patient != null ? !patient.equals(that.patient) : that.patient != null) return false;
        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        return diagnosis != null ? diagnosis.equals(that.diagnosis) : that.diagnosis == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PatientChart{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
