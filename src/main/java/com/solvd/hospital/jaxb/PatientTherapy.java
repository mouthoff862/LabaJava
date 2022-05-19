package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "therapy")
@XmlType(propOrder = {"doctor", "nurse", "hospitalMedicine"})
public class PatientTherapy {

    private HospitalDoctor doctor;
    private HospitalNurse nurse;
    private List<HospitalMedicine> hospitalMedicine;

    public HospitalDoctor getDoctor() {
        return doctor;
    }

    @XmlElement(name = "doctor")
    public void setDoctor(HospitalDoctor doctor) {
        this.doctor = doctor;
    }

    public HospitalNurse getNurse() {
        return nurse;
    }

    @XmlElement(name = "nurse")
    public void setNurse(HospitalNurse nurse) {
        this.nurse = nurse;
    }

    public List<HospitalMedicine> getHospitalMedicine() {
        return hospitalMedicine;
    }

    @XmlElement(name = "medicine")
    public void setHospitalMedicine(List<HospitalMedicine> hospitalMedicine) {
        this.hospitalMedicine = hospitalMedicine;
    }

    @Override
    public String toString() {
        return "PatientTherapy{" +
                "doctor=" + doctor +
                ", nurse=" + nurse +
                ", hospitalMedicines=" + hospitalMedicine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientTherapy)) return false;

        PatientTherapy therapy = (PatientTherapy) o;

        if (nurse != null ? !nurse.equals(therapy.nurse) : therapy.nurse != null) return false;
        return hospitalMedicine != null ? hospitalMedicine.equals(therapy.hospitalMedicine) : therapy.hospitalMedicine == null;
    }

    @Override
    public int hashCode() {
        int result = nurse != null ? nurse.hashCode() : 0;
        result = 31 * result + (hospitalMedicine != null ? hospitalMedicine.hashCode() : 0);
        return result;
    }
}
