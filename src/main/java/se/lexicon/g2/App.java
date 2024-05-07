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
        citySearchResult.forEach(System.out::println);



    }
}
