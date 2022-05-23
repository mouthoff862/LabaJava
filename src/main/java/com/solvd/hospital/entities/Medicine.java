package com.solvd.hospital.entities;

public class Medicine {
    private int id;
    private String medicineName;
    private String used;

    public Medicine() {
    }

    public Medicine(int id, String medicineName, String used) {
        this.id = id;
        this.medicineName = medicineName;
        this.used = used;
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

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
