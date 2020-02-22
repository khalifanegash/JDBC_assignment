package se.ecutb.khalifa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import se.ecutb.khalifa.data.City;
import se.ecutb.khalifa.data.CityDao;
import se.ecutb.khalifa.data.CityDaoJDBC;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private CityDao cityDao = new CityDaoJDBC();

    @Test
    public void find_by_id_test()
    {
        assertEquals( 100,cityDao.findById(100).getId() );
    }

    @Test
    public void find_by_code_test()
    {
        assertEquals( 28,cityDao.findByCode("nld").size() );
    }

    @Test
    public void find_by_name_test()
    {
        assertEquals( "Breda",cityDao.findByName("Breda").get(0).getName() );
    }
    @Test
    public void find_all_test()
    {
        assertEquals( 4079,cityDao.findAll().size() );
    }

    @Test
    public void add_test()
    {
        City city = new City("Ronneby","RON","Ronneby",30000);
        assertEquals( city,cityDao.add(city) );
    }

    @Test
    public void update_test()
    {
        City city = new City("Ronneby","RON","Ronneby",30000);
        city.setCountryCode("BLK");
        assertEquals( city,cityDao.uppdate(city) );
    }

    @Test
    public void delete_test()
    {
        City city = new City("Ronneby","RON","Ronneby",30000);

        assertEquals( 0,cityDao.delete(city) );
    }
}
