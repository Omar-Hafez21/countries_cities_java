package com.iti;

import java.util.Comparator;

public class City {
    private String code, name, continent, surface_area;
    private int population;
    private boolean capital;
    public City(String code, String name, String continent, String surface_area, int population, boolean capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surface_area = surface_area;
        this.population = population;
        this.capital = capital;
    }
    public City getCity() {
        City city = new City(getCode(),getName(),getContinent(),getSurface_area(),getPopulation(),getCapital());
        return city;
    }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getSurface_area() {
        return surface_area;
    }

    public int getPopulation() {
        return population;
    }

    public boolean getCapital() {
        return capital;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setSurface_area(String surface_area) {
        this.surface_area = surface_area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCapital(boolean capital) { this.capital = capital; }

    @Override
    public String toString() {
        return "City{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surface_area='" + surface_area + '\'' +
                ", population='" + population + '\'' +
                ", capital='" + capital + '\'' +
                "}\n";
    }

    public static Comparator<City> CityPopulation = new Comparator<City>() {

        public int compare(City s1, City s2) {
            /*For ascending order*/
            return s1.getPopulation()-s2.getPopulation();

        }};


}
