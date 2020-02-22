package se.ecutb.khalifa;

import se.ecutb.khalifa.data.City;
import se.ecutb.khalifa.data.CityDaoJDBC;
import se.ecutb.khalifa.data.Database;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        //Database.getConnection();
        CityDaoJDBC daoJDBC = new CityDaoJDBC();
        //System.out.println(daoJDBC.findById(1));

        //daoJDBC.findByCode("Nld").forEach(System.out::println);
        // System.out.println(daoJDBC.findByCode("nld").size());

        //daoJDBC.findByName("Breda").forEach(System.out::println);

        City city = new City("Amersfoort","NLD","Utrecht",126270);
        //System.out.println(daoJDBC.add(city));
        //System.out.println(daoJDBC.delete(city));

        //daoJDBC.findAll().forEach(System.out::println);
        System.out.println(daoJDBC.findAll().size());



    }
}
