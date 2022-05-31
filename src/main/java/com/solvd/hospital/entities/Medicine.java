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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (medicineName != null ? !medicineName.equals(medicine.medicineName) : medicine.medicineName != null)
            return false;
        return used != null ? used.equals(medicine.used) : medicine.used == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (medicineName != null ? medicineName.hashCode() : 0);
        result = 31 * result + (used != null ? used.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicineName='" + medicineName + '\'' +
                ", used='" + used + '\'' +
                '}';
    }
}
