package com.solvd.hospital.entities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientService)) return false;

        PatientService that = (PatientService) o;

        if (id != that.id) return false;
        return serviceName != null ? serviceName.equals(that.serviceName) : that.serviceName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PatientService{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
