package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "medicine")
@XmlType(propOrder = {"name", "portion"})
public class HospitalMedicine {
    private String name;
    private int portion;

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public int getPortion() {
        return portion;
    }

    @XmlElement(name = "portion")
    public void setPortion(int portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "HospitalMedicine{" +
                "name='" + name + '\'' +
                ", portion=" + portion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalMedicine)) return false;

        HospitalMedicine medicine = (HospitalMedicine) o;

        if (portion != medicine.portion) return false;
        return name != null ? name.equals(medicine.name) : medicine.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + portion;
        return result;
    }
}
