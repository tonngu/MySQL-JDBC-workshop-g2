package se.lexicon.g2.data.daoImpl;

import se.lexicon.g2.data.CityDao;
import se.lexicon.g2.db.MySQLConnection;
import se.lexicon.g2.model.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {
    @Override
    public City findById(int id) {
        return null;
    }

    @Override
    public List<City> findByCode(String code) {
        return null;
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }

    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();
        try{
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from city");


            while(resultSet.next()){
                int cityId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String countryCode = resultSet.getString(3);
                String district = resultSet.getString(4);
                int population = resultSet.getInt(5);
                City city = new City(cityId, name, countryCode, district, population);
                cityList.add(city);
            }



            } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }
        cityList.forEach(System.out::println);
        return cityList;
    }

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }
}
