package com.solvd.hospital.entities;

import java.util.List;

public class Price {
    private int id;
    private int price;
    private List<PatientService> patientServices;

    public Price() {
    }

    public Price(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<PatientService> getPatientServices() {
        return patientServices;
    }

    public void setPatientServices(List<PatientService> patientServices) {
        this.patientServices = patientServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price priceOne = (Price) o;

        if (id != priceOne.id) return false;
        if (price != priceOne.price) return false;
        return patientServices != null ? patientServices.equals(priceOne.patientServices) : priceOne.patientServices == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + price;
        result = 31 * result + (patientServices != null ? patientServices.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", patientServices=" + patientServices +
                '}';
    }
}
