package com.iti;
/*Develop and application that reads two files for cities and countries and store each in a List.
        Each city entry contains code, name, continent, Surface Area, population
        Create a map that uses the country code as keys and a list of cities as the value for each country.
        For a given country code sort the cities according to the population*/


import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CountryCSVDAO country_dao = new CountryCSVDAO();
        List<Country> country_lst = new ArrayList<>();
        String country_file_name = "countries.csv";
        country_lst = country_dao.readCountryFromCSV(country_file_name);
        System.out.println("*****************************************************************************************");
        System.out.println(country_lst.get(0));

        Map<String, List<Country>> country_map = new HashMap<String, List<Country>>();
        country_map = country_lst.stream().collect(
                Collectors.groupingBy(Country::getCode, Collectors.mapping(Country::getCountry,Collectors.toList()))
        );
        System.out.println("*****************************************************************************************");
        System.out.println(country_map.get("0"));

        country_lst.forEach((Country country) ->{
            Collections.sort(country.getCities(),City.CityPopulation);
        });
        System.out.println("*****************************************************************************************");
        System.out.println(country_lst);

    }

}

