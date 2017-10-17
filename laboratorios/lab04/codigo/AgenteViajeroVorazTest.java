

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * The test class AgenteViajeroVorazTest.
 *
 * @author  Camilo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class AgenteViajeroVorazTest
{
    /**
     * Default constructor for test class AgenteViajeroVorazTest
     */
    public AgenteViajeroVorazTest()
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
     * Test del método agenteViajero.
     * @params g - Grafo para hacer el recorrido. v - Vértice inicial.
     * @return respuesta - Array con el recorrido resultante.
     */
    @After
    public int[] dijkstra(Graph g, int v)
    {
        int[] respuesta = new int[g.size()];
        for (int i = 0; i < g.size(); i++)
        	respuesta[i] = Integer.MAX_VALUE;
        respuesta[v] = 0;
        boolean[] visitados = new boolean[g.size()];
        while (v != Integer.MAX_VALUE){
          visitados[v] = true;
          ArrayList<Integer> ss = g.getSuccessors(v);
          for (Integer s : ss)
          	respuesta[s] = Math.min(respuesta[s],
                       respuesta[v] + g.getWeight(v,s));
          v = Integer.MAX_VALUE;
          for(int i = 0; i < g.size(); i++)
             if (!visitados[i] && respuesta[i] < v)
               v = respuesta[i];
        }    
        return respuesta; 
    }
}
