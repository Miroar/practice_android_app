package com.example.myapplication2;

public class Country {

    private String countryName;
    private String flagName;
    private String description;

    public Country(String countryName, String flagName, String description) {
        this.countryName= countryName;
        this.flagName= flagName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }
}
