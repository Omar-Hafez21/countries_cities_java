package com.iti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityCSVDAO {
    public String row;

    public List<City> readCityFromCSV(String fileName){
        BufferedReader csvReader = null;
        List<City> lst = new ArrayList<>();
        Map<String, List<City>> map = new HashMap<String, List<City>>();

        try {
            csvReader = new BufferedReader(new FileReader(fileName));

            //this line to ignore the header of the table
            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data;
                data = row.split(",");

                String code = data[0];
                String name = data[1];
                String continent = data[2];
                String surface_area = data[3];
                String population = data[4];
                String capital = data[5];
                City city= new City(code, name, continent, surface_area, Integer.parseInt(population), Boolean.parseBoolean(capital));
                lst.add(city);
                map.put(code, lst);
//                System.out.println(city);

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
