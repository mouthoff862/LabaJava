package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "diagnosis")
public class DiagnosisPatient {

    private String diagnosis;

    public String getDiagnosis() {
        return diagnosis;
    }

    @XmlElement(name = "diagnosis")
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "DiagnosisPatient{" +
                "diagnosis='" + diagnosis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiagnosisPatient)) return false;

        DiagnosisPatient diagnosisOne = (DiagnosisPatient) o;

        return diagnosis != null ? diagnosis.equals(diagnosisOne.diagnosis) : diagnosisOne.diagnosis == null;
    }

    @Override
    public int hashCode() {
        return diagnosis != null ? diagnosis.hashCode() : 0;
    }
}
