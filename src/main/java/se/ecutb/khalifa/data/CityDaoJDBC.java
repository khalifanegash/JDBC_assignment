package se.ecutb.khalifa.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static se.ecutb.khalifa.data.Database.getConnection;

public class CityDaoJDBC implements CityDao {

    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id = ?";

    private static final String FIND_BY_CODE = "SELECT * FROM city WHERE countrycode = ?";

    private static final String FIND_BY_NAME = "SELECT * FROM city WHERE name = ?";

    private static final String FIND_ALL = "SELECT * FROM city ";


    private static final String INSERT = "INSERT INTO city(name,countrycode,district,population) VALUES(?,?,?,?)";

    private static final String UPDATE = "UPDATE city SET name =?,countrycode =? ,district =? ,population=? WHERE id= ?";

    private static final String DELETE = "DELETE FROM city WHERE id =?";
    @Override
    public City findById(int id) {
        City city = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = createFindById(connection,id);
                ResultSet set = statement.executeQuery()
                ){
            while (set.next()){
                city = new City(set.getInt("id"),
                        set.getString("name"),
                        set.getString("countryCode"),
                        set.getString("district"),
                        set.getLong("population"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    private PreparedStatement createFindById(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        return statement;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> cityList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = createFindByCode(connection,code);
                ResultSet set = statement.executeQuery()
        ){
            while (set.next()){
                cityList.add(new City(set.getInt("id"),
                        set.getString("name"),
                        set.getString("countryCode"),
                        set.getString("district"),
                        set.getLong("population")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    private PreparedStatement createFindByCode(Connection connection, String code) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_CODE);
        statement.setString(1,code);
        return statement;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> cityList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = createFindByName(connection,name);
                ResultSet set = statement.executeQuery()
        ){
            while (set.next()){
                cityList.add(new City(set.getInt("id"),
                        set.getString("name"),
                        set.getString("countryCode"),
                        set.getString("district"),
                        set.getLong("population")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    private PreparedStatement createFindByName(Connection connection, String name) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
        statement.setString(1,name);
        return statement;
    }

    @Override
    public List<City> findAll() {
        List<City> cityList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(FIND_ALL);
                ResultSet set = statement.executeQuery()
        ){
            while (set.next()){
                cityList.add(new City(set.getInt("id"),
                        set.getString("name"),
                        set.getString("countryCode"),
                        set.getString("district"),
                        set.getLong("population")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City add(City city) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)
        ){
           statement.setString(1,city.getName());
            statement.setString(2,city.getCountryCode());
            statement.setString(3,city.getDistrict());
            statement.setLong(4,city.getPopulation());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City uppdate(City city) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ){
            statement.setString(1,city.getName());
            statement.setString(2,city.getCountryCode());
            statement.setString(3,city.getDistrict());
            statement.setLong(4,city.getPopulation());
            statement.setInt(5,city.getId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public int delete(City city) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ){
            statement.setInt(1,city.getId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (findById(city.getId()) !=null){
            return 1;
        }
        return 0;
    }
}
