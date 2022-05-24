package com.solvd.hospital.parsing.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "visit")
@XmlType(propOrder = {"doctor", "year"})
@JsonRootName(value = "visit")
@JsonPropertyOrder({"doctor", "date_of_visit", "year"})
public class VisitPatient {
    private HospitalDoctor doctor;
    private Date dateOfVisit;
    private int year;

    public HospitalDoctor getDoctor() {
        return doctor;
    }

    @XmlElement(name = "doctor")
    @JsonProperty
    public void setDoctor(HospitalDoctor doctor) {
        this.doctor = doctor;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    // @XmlElement(name = "date_of_visit")
    // @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("date_of_visit")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="mm/dd/yyyy")
    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public int getYear() {
        return year;
    }

    @XmlElement(name = "year")
    @JsonProperty
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
