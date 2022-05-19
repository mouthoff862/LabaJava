package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "visit")
@XmlType(propOrder = {"doctor", "year"})
public class VisitPatient {
    private HospitalDoctor doctor;
    private Date dateOfVisit;
    private int year;

    public HospitalDoctor getDoctor() {
        return doctor;
    }

    @XmlElement(name = "doctor")
    public void setDoctor(HospitalDoctor doctor) {
        this.doctor = doctor;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    // @XmlElement(name = "date_of_visit")
    // @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public int getYear() {
        return year;
    }

    @XmlElement(name = "year")
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "VisitPatient{" +
                "doctor=" + doctor +
                ", dateOfVisit=" + dateOfVisit +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitPatient)) return false;

        VisitPatient visit = (VisitPatient) o;

        if (doctor != null ? !doctor.equals(visit.doctor) : visit.doctor != null) return false;
        return dateOfVisit != null ? dateOfVisit.equals(visit.dateOfVisit) : visit.dateOfVisit == null;
    }

    @Override
    public int hashCode() {
        int result = doctor != null ? doctor.hashCode() : 0;
        result = 31 * result + (dateOfVisit != null ? dateOfVisit.hashCode() : 0);
        return result;
    }
}
