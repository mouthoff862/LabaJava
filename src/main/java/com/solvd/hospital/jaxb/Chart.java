package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "chart")
@XmlType(propOrder = {"id", "patient", "visit", "therapy", "diagnosis"})
public class Chart {
    private Long id;
    private PatientClass patient;
    private VisitPatient visit;
    private PatientTherapy therapy;
    private DiagnosisPatient diagnosis;

    public Long getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(Long id) {
        this.id = id;
    }

    public PatientClass getPatient() {
        return patient;
    }

    @XmlElement(name = "patient")
    public void setPatient(PatientClass patient) {
        this.patient = patient;
    }

    public VisitPatient getVisit() {
        return visit;
    }

    @XmlElement(name = "visit")
    public void setVisit(VisitPatient visit) {
        this.visit = visit;
    }

    public PatientTherapy getTherapy() {
        return therapy;
    }

    @XmlElement(name = "therapy")
    public void setTherapy(PatientTherapy therapy) {
        this.therapy = therapy;
    }

    public DiagnosisPatient getDiagnosis() {
        return diagnosis;
    }

    @XmlElement(name = "diagnosis")
    public void setDiagnosis(DiagnosisPatient diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", patient=" + patient +
                ", visit=" + visit +
                ", therapy=" + therapy +
                ", diagnosis=" + diagnosis +
                '}';
    }
}
