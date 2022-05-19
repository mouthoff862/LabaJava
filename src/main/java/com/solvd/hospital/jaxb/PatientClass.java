package com.solvd.hospital.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "patient")
@XmlType(propOrder = {"id", "name", "email", "age"})
public class PatientClass {
    private Long id;
    private String name;
    private String email;
    private int age;

    public Long getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    @XmlElement(name = "age")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PatientClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientClass)) return false;

        PatientClass patient = (PatientClass) o;

        if (age != patient.age) return false;
        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        return email != null ? email.equals(patient.email) : patient.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
