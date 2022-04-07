package com.solvd.animals.enums;

public enum AnimalDesc {

    LION(MainAnimals.ANIMAL, SubAnimals.LION),
    ZEBRA(MainAnimals.ANIMAL, SubAnimals.ZEBRA),
    SPARROW(MainAnimals.ANIMAL, SubAnimals.SPARROW),
    OPOSSUM(MainAnimals.ANIMAL, SubAnimals.OPOSSUM),
    FOOD_GRASS(MainAnimals.FAVOURITE_FOOD, SubAnimals.GRASS),
    FOOD_MEAT(MainAnimals.FAVOURITE_FOOD,SubAnimals.MEAT),
    AFRICA(MainAnimals.COUNTRY, SubAnimals.AFRICA),
    ITALY(MainAnimals.COUNTRY, SubAnimals.ITALY);

    private MainAnimals mainAnimals;
    private SubAnimals subAnimals;

    private AnimalDesc(MainAnimals mainAnimals, SubAnimals subAnimals) {
        this.mainAnimals = mainAnimals;
        this.subAnimals = subAnimals;
    }

    public MainAnimals getMainAnimals() {
        return mainAnimals;
    }

    public SubAnimals getSubAnimals() {
        return subAnimals;
    }

}
