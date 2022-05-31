package com.solvd.hospital.entities;

import java.sql.Date;

public class Visit {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;

    public Visit() {
    }

    public Visit(int id, Patient patient, Doctor doctor, Date date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit)) return false;

        Visit visit = (Visit) o;

        if (id != visit.id) return false;
        if (patient != null ? !patient.equals(visit.patient) : visit.patient != null) return false;
        if (doctor != null ? !doctor.equals(visit.doctor) : visit.doctor != null) return false;
        return date != null ? date.equals(visit.date) : visit.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", date=" + date +
                '}';
    }
}
