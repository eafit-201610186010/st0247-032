import java.util.ArrayList;
/**
 * DFS
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class DFS
{
    /** Método DFS.
      * @params g - Grafo para aplicar DFS. source - Vértice para comenzar el recorrido.
      * @return output - ArrayList con el recorrido resultante al aplicar DFS.
      */
     public static ArrayList<Integer> dfs(Graph g, int source)
     {
         int[] marcas = new int[g.size()]; // Para marcar por donde ya pasé
         for (int i = 0; i < marcas.length; i++){
            marcas[i] = 0;   
        }
         return dfsAux(g, source, marcas);
     }
     
    /** Método dfsAux.
      * @params g - Grafo para aplicar DFS. source - Vértice para comenzar el recorrido.
      * @return output - ArrayList con el recorrido resultante al aplicar DFS.
      */
     private static ArrayList<Integer> dfsAux(Graph g, int source, int[] marcas)
     {
         ArrayList<Integer> successors = g.getSuccessors(source);
         ArrayList<Integer> output = new ArrayList<Integer>();
         if (successors.size() == 0 || marcas[source] == 1)
           {
             return output;
           }
         else
           {
             marcas[source] = 1;
             output.add(source);
             for (int i = 0; i < successors.size(); i++)
             {
                 ArrayList<Integer> recursiveOutput = dfsAux(g,successors.get(i),marcas);
                 output.addAll(recursiveOutput);                
             }
             return output;
            }
     }
     
     /**
     * Método para probar DFS con un grafo completo.
     */  
    public static void main(String[] args) {
        System.out.println("---DFS con Listas---");
         GraphAL gal = new GraphAL(11);
         gal.addArc(1,2,0);
         gal.addArc(1,3,0);
         gal.addArc(2,4,0);
         gal.addArc(2,5,0);
         gal.addArc(3,5,0);
         gal.addArc(3,6,0);
         gal.addArc(6,7,0);
         gal.addArc(6,8,0);
         
         ArrayList<Integer> path3 = dfs(gal,1);
         
         for (int i  = 0; i < path3.size(); i++)
           System.out.println(path3.get(i));
    }
}
