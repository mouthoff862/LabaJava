package com.solvd.hospital.patterns;

import com.solvd.hospital.entities.Patient;

public class Builder {
    private String name;
    private String email;
    private int age;
    private String address;

    public Builder() {
    }

    public Builder(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient build() {
        return new Patient(name, email, age, address);
    }
}
