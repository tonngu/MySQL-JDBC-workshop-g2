package se.lexicon.g2;

import se.lexicon.g2.data.daoImpl.CityDaoJDBC;
import se.lexicon.g2.db.MySQLConnection;
import se.lexicon.g2.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<City> citySearchResult = new ArrayList<>();
        CityDaoJDBC prelimTest = new CityDaoJDBC();
        //citySearchResult = prelimTest.findByCode("SWE");
        //citySearchResult = prelimTest.findByName("Hanoi");
        //citySearchResult.forEach(System.out::println);
        /*City city = prelimTest.findById(5);
        System.out.println(city);*/

        /*City addedCity1 = new City("TestCity","SWE", "TestDistrict", 500000);
        prelimTest.add(addedCity1);*/
        //City added with id 4081

        City updatedCity = prelimTest.findById(4081);
        updatedCity.setName("TestCity2");
        prelimTest.update(updatedCity);
        //updated successfully, city previously with id 4081 previously named TestCity is now TestCity2

        prelimTest.delete(updatedCity);
        //city with id 4081 is now gone from MySQL City table



    }
}
