package com.iti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryCSVDAO {
    public String row;

    public List<Country> readCountryFromCSV(String fileName){
        BufferedReader csvReader = null;
        List<Country> lst = new ArrayList<>();
        try {
            //read cities first
            CityCSVDAO city_dao = new CityCSVDAO();
            String city_file_name = "cities.csv";
            List<City> city_lst = city_dao.readCityFromCSV(city_file_name);

            Map<String, List<City>> country_map = new HashMap<String, List<City>>();
            country_map = city_lst.stream().collect(
                    Collectors.groupingBy(City::getCode, Collectors.mapping(City::getCity,Collectors.toList()))
            );

            csvReader = new BufferedReader(new FileReader(fileName));
                csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data;
                data = row.split(",");
                String code = data[0];
                String name = data[1];
//                if(Character.isLetter(code.charAt(0))){continue;}
                Country country= new Country(code, name, country_map.get(code));

                lst.add(country);
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lst;
    }
}

