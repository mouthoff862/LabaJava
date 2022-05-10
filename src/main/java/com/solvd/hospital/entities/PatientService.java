package com.solvd.hospital.entities;

import java.util.List;

public class PatientService {
    private int id;
    private String serviceName;

    public PatientService() {
    }

    public PatientService(int id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
