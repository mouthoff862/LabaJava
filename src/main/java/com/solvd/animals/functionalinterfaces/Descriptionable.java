package com.solvd.animals.functionalinterfaces;

import com.solvd.animals.animal.Animals;

@FunctionalInterface
public interface Descriptionable {

    String description(String animalType, String animalTypeSecond);

}
