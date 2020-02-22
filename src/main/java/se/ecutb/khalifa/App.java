package se.ecutb.khalifa;

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

        daoJDBC.findByName("Breda").forEach(System.out::println);



    }
}
