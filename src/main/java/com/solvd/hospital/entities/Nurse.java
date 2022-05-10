package com.solvd.hospital.entities;

import java.util.List;

public class Nurse {
    private int id;
    private String name;

    public Nurse() {
    }

    public Nurse(int id, String name) {
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

}
