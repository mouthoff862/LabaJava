package com.solvd.hospital.entities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nurse)) return false;

        Nurse nurse = (Nurse) o;

        if (id != nurse.id) return false;
        return name != null ? name.equals(nurse.name) : nurse.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
