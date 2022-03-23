package com.laba.animal;

public class AnimalCountries {

    private String countryName;
    private String countryDescription;
    public AnimalCountries(String countryName, String countryDescription) {
        this.countryName = countryName;
        this.countryDescription = countryDescription;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

}
