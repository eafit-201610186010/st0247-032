

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QueensTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class QueensTest
{
    /**
     * Default constructor for test class QueensTest
     */
    public QueensTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test 1 para el problema de las N reinas
     */
    @Test
    public void FourQueens()
    {
       Queens nReinas = new Queens(4);
       nReinas.queens();
    }
}
