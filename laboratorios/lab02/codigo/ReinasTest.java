

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ReinasTest.
 *
 * @author  Camilo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class ReinasTest
{
    /**
     * Default constructor for test class ReinasTest
     */
    public ReinasTest()
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
    public void EightQueens()
    {
       Reinas nReinas = new Reinas();
       nReinas.reinas(8);
    }
}
