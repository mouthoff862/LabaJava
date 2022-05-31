package com.solvd.hospital.entities;

public class Diagnosis {
    private int id;
    private String name;

    public Diagnosis() {
    }

    public Diagnosis(int id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (id != diagnosis.id) return false;
        return name != null ? name.equals(diagnosis.name) : diagnosis.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
