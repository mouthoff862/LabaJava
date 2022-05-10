package com.solvd.hospital.entities;

import java.util.List;

public class Cleaner {
    private int id;
    private String name;
    private List<Department> departments;
    private List<HospitalRoom> hospitalRooms;

    public Cleaner() {
    }

    public Cleaner(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<HospitalRoom> getHospitalRooms() {
        return hospitalRooms;
    }

    public void setHospitalRooms(List<HospitalRoom> hospitalRooms) {
        this.hospitalRooms = hospitalRooms;
    }
}
