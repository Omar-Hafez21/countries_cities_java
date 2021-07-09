package com.iti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Country implements Serializable{
    private String code, name;
    private List<City> cities = new ArrayList<>();

    public Country(String code, String name,List<City> cities) {
        this.code = code;
        this.name = name;
        this.cities = cities;
    }
    public Country getCountry() {
        Country country = new Country(getCode(),getName(),cities);
        return country;
    }

    public List<City> getCities(){return cities;}

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }


}
