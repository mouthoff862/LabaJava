package com.solvd.hospital.entities;

public class Medicine {
    private int id;
    private String medicineName;

    public Medicine() {
    }

    public Medicine(int id, String medicineName) {
        this.id = id;
        this.medicineName = medicineName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
