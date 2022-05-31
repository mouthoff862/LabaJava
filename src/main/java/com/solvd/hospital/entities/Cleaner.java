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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cleaner)) return false;

        Cleaner cleaner = (Cleaner) o;

        if (id != cleaner.id) return false;
        if (name != null ? !name.equals(cleaner.name) : cleaner.name != null) return false;
        if (departments != null ? !departments.equals(cleaner.departments) : cleaner.departments != null) return false;
        return hospitalRooms != null ? hospitalRooms.equals(cleaner.hospitalRooms) : cleaner.hospitalRooms == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (departments != null ? departments.hashCode() : 0);
        result = 31 * result + (hospitalRooms != null ? hospitalRooms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cleaner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departments=" + departments +
                ", hospitalRooms=" + hospitalRooms +
                '}';
    }
}
