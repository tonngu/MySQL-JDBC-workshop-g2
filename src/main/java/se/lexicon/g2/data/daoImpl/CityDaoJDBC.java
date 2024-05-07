package se.lexicon.g2.data.daoImpl;

import se.lexicon.g2.data.CityDao;
import se.lexicon.g2.db.MySQLConnection;
import se.lexicon.g2.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityDaoJDBC implements CityDao {
    @Override
    public City findById(int id) {
        City city = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from city where id = ?")) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int cityId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String countryCode = resultSet.getString(3);
                    String district = resultSet.getString(4);
                    int population = resultSet.getInt(5);
                    city = new City(cityId, name, countryCode, district, population);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from city where CountryCode = ?")) {
            preparedStatement.setString(1, code);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int cityId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String countryCode = resultSet.getString(3);
                    String district = resultSet.getString(4);
                    int population = resultSet.getInt(5);
                    City city = new City(cityId, name, countryCode, district, population);
                    cityList.add(city);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from city where `name` = ?")) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int cityId = resultSet.getInt(1);
                    String cityName = resultSet.getString(2);
                    String countryCode = resultSet.getString(3);
                    String district = resultSet.getString(4);
                    int population = resultSet.getInt(5);
                    City city = new City(cityId, cityName, countryCode, district, population);
                    cityList.add(city);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }


    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();

        try (Connection connection = MySQLConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM city")) {

            while (resultSet.next()) {
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
        String query = "insert into city(name, CountryCode, District, Population) values (?, ?, ?, ?)";
        try (Connection connection = MySQLConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());


            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted >0){
                System.out.println("City added successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City update(City city) {
        String query = "update city set name = ?, CountryCode = ?, District = ?, Population = ? where id = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getCityId());


            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("City updated successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public int delete(City city) {
        String query = "delete from city where id = ?";
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, city.getCityId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("City updated successfully");
            }
            return rowsUpdated;
        } catch(SQLException e){
            e.printStackTrace();
        return 0;}
    }
}
