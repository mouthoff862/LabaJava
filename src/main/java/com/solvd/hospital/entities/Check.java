package com.solvd.hospital.entities;

import java.util.List;

public class Check {
    private int id;
    private List<Patient> patients;
    private List<Price> prices;

    public Check() {
    }

    public Check(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;

        Check check = (Check) o;

        if (id != check.id) return false;
        if (patients != null ? !patients.equals(check.patients) : check.patients != null) return false;
        return prices != null ? prices.equals(check.prices) : check.prices == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (patients != null ? patients.hashCode() : 0);
        result = 31 * result + (prices != null ? prices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", patients=" + patients +
                ", prices=" + prices +
                '}';
    }
}
