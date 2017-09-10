import java.util.ArrayList;
/**
 * Esta clase es una implementación del problema del agente viajero usando algoritmo voraz.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */
public class AgenteViajeroVoraz {
    
    /** Método Agente viajero usando algoritmo voraz 
      * @params g - Grafo para hacer el recorrido. comienzo - Nodo inicial.
      * @return respuesta - Array con el recorrido resultante.
      */
    public static int[] agenteViajero(Graph g, int comienzo) {
         int indice = 0;
         int[] respuesta = new int[g.size() + 1];
         boolean[] sucesores = new boolean[g.size()];
         int actual = comienzo;
         do {
             ArrayList<Integer> destino = g.getSuccessors(actual);
             sucesores[actual] = true;
             int cercano = -1;
             int pesoAlMasCercano = 1000000; //infinito
             for (int i = 0; i < destino.size(); i++) {               
                 if (g.getWeight(actual, destino.get(i)) < pesoAlMasCercano 
                               && !sucesores[destino.get(i)]
                               && destino.get(i) != actual) {
                     pesoAlMasCercano = g.getWeight(actual,destino.get(i));
                     cercano = destino.get(i);
                 }
             }
             respuesta[indice++] = actual;
             actual = cercano;
         } while (indice < g.size());
         respuesta[indice] = comienzo; 
         return respuesta;
    }
}
