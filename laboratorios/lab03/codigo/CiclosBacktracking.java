import java.util.ArrayList;
/**
 * CiclosBacktracking.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class CiclosBacktracking
{
    /** Método para identificar si hay al menos un ciclo en un grafo aplicando DFS. */
     public static boolean ciclos_dfs (Graph g, int source, int[] marcas,int wanted){
         ArrayList<Integer> successors = g.getSuccessors(source);
         marcas[source] = 1;
         boolean ciclo = false;
         for (int i = 0; i < successors.size()&& !ciclo; i++)
         {
             if (successors.get(i)==wanted)
             ciclo = true;
             else if (marcas[successors.get(i)]!=1) ciclo |= ciclos_dfs(g,successors.get(i),marcas,wanted);            
         }
         return ciclo;
     }
     
     /** Método ciclos. */
     public static boolean ciclos (Graph g){
         int[] marcas = new int[g.size()];
         boolean ciclos;
         for (int i=0;i<g.size();++i){
            for (int p=0; p < marcas.length; p++)
                marcas[p] = 0;
            if (ciclos_dfs(g, i,marcas, i))return true;
         }
         return false;
     }
}
