package com.solvd.animals.enums;


public enum MainAnimals {

    ANIMAL {
        public String getValue() {
            return "ANIMAL :";
        }
    },
    FAVOURITE_FOOD {
        public String getValue() {
            return "FAVOURITE FOOD :";
        }
    },
    COUNTRY {
        public String getValue() {
            return "COUNTRY : ";
        }
    };

    private String value;

    public String getValue() {
        return value;
    }

}
