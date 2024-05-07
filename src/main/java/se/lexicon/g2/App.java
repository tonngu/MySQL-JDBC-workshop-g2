package se.lexicon.g2;

import se.lexicon.g2.data.daoImpl.CityDaoJDBC;
import se.lexicon.g2.db.MySQLConnection;
import se.lexicon.g2.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        CityDaoJDBC prelimTest = new CityDaoJDBC();
        prelimTest.findAll();



    }
}
