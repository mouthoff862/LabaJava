package com.solvd.animals.enums;

public enum SubAnimals {

    LION("Lion"), ZEBRA("Zebra"), OPOSSUM("Opossum"), SPARROW("Sparrow"), MEAT("Meat"), GRASS("Grass"), AFRICA("Africa"),
    ITALY("Italy");

    private String value;

    private SubAnimals(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
