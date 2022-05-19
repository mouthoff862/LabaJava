package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nurse")
public class HospitalNurse {
    private String name;

    public String getName() {
        return name;
    }

    @XmlElement(name = "nurse")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HospitalNurse{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalNurse)) return false;

        HospitalNurse nurse = (HospitalNurse) o;

        return name != null ? name.equals(nurse.name) : nurse.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
