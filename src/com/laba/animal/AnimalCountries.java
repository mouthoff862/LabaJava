package com.laba.animal;

public class AnimalCountries implements Geography{

    private String countryName;
    private String countryDescription;
    public AnimalCountries(String countryName, String countryDescription) {
        this.countryName = countryName;
        this.countryDescription = countryDescription;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDescription() {
        return this.countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    @Override
    public void countries(AnimalCountries countries) {
        String name = countries.getCountryName();
        String continent = countries.getCountryDescription();
        System.out.println("The animal is from country: " + name + ".\n" +
                "This country is in:" + continent);
    }
}
