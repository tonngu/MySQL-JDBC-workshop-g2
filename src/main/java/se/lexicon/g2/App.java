package se.lexicon.g2;

import se.lexicon.g2.data.daoImpl.CityDaoJDBC;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        CityDaoJDBC testDb = new CityDaoJDBC();
        testDb.findAll();
    }
}
