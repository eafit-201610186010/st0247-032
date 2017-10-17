import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Ejercicio
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class Ejercicio {
    /**
     * @param g - Grafo. start - vertice inicial. end - vertice final. weight - peso entre ambos vertices.
     */
    public static void addVertex(Graph g, int start, int end, int weight) {
        g.addArc(start, end, weight);
        g.addArc(end, start, weight);
    }

    /**
     * Main.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while (!(s = Input.readLine()).equals("0")) {
            StringTokenizer tokenI = new StringTokenizer(s);
            int numVert = Integer.parseInt(tokenI.nextToken()) + 1;
            int numArc = Integer.parseInt(tokenI.nextToken());
            GraphAL gAl = new GraphAL(numVert);
            StringTokenizer token = new StringTokenizer(Input.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weightI = Integer.parseInt(token.nextToken());
            addVertex(gAl, start, end, weightI);

            while (numArc - 1 != 0) {
                token = new StringTokenizer(Input.readLine());
                int first = Integer.parseInt(token.nextToken());
                int second = Integer.parseInt(token.nextToken());
                int weight = Integer.parseInt(token.nextToken());
                addVertex(gAl, first, second, weight);
                --numArc;
            }
            
            System.out.println(dfs(gAl, 1));

        }
    }
    
    /** Método DFS.
      * @params g - gAl para aplicar DFS. source - Vértice para comenzar el recorrido.
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
      * @params g - gAl para aplicar DFS. source - Vértice para comenzar el recorrido.
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
}