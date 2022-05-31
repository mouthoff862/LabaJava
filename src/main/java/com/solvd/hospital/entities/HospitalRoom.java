package com.solvd.hospital.entities;

public class HospitalRoom {
    private int id;
    private int number;
    private Department department;
    private HospitalTreatment hospitalTreatment;

    public HospitalRoom() {
    }

    public HospitalRoom(int id, int number, Department department, HospitalTreatment hospitalTreatment) {
        this.id = id;
        this.number = number;
        this.department = department;
        this.hospitalTreatment = hospitalTreatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public HospitalTreatment getHospitalTreatment() {
        return hospitalTreatment;
    }

    public void setHospitalTreatment(HospitalTreatment hospitalTreatment) {
        this.hospitalTreatment = hospitalTreatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HospitalRoom)) return false;

        HospitalRoom that = (HospitalRoom) o;

        if (id != that.id) return false;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        return "HospitalRoom{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
