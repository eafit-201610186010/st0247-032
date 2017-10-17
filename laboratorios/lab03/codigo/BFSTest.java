import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class BFSTest.
 *
 * @author  Camilo Cruz Villegas, Cristian Villamizar
 * @version (a version number or a date)
 */
public class BFSTest
{
    GraphAL gal;
    /**
     * Default constructor for test class BFSTest
     */
    public BFSTest()
    {
        gal = new GraphAL(11);
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
     * Test 1 
     */
    @Test
    public void BFSTest()
    {
        System.out.println("---BFS con Listas---");
        BfsBacktracking bback = new BfsBacktracking();
         gal.addArc(1,2,0);
         gal.addArc(1,3,0);
         gal.addArc(2,4,0);
         gal.addArc(2,5,0);
         gal.addArc(3,5,0);
         gal.addArc(3,6,0);
         gal.addArc(6,7,0);
         gal.addArc(6,8,0);
       
         ArrayList<Integer> path3 = bback.bfs(gal,1);
         
         for (int i  = 0; i < path3.size(); i++)
           System.out.println(path3.get(i));
    }
}
