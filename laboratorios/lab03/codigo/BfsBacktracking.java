import java.util.ArrayList;
import java.util.LinkedList;
/**
 * BFSBacktracking.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar. 
 * @version 1
 */


public class BfsBacktracking {
    /** Método BFS
      * @params g - Grafo para aplicar BFS. source - Vértice para comenzar el recorrido.
      * @return output - ArrayList con el recorrido resultante al aplicar BFS.
      */
    public static ArrayList<Integer> bfs(Graph g, int source)
     {
       ArrayList<Integer> output = new ArrayList<Integer>();
       boolean [] visited = new boolean[g.size];
       for (int i=0; i<visited.length; i++){
           visited[i]=false;
       }
       
       LinkedList cola = new LinkedList<Integer>();
       cola.addFirst(source);
       visited[source]=true;
       while(!cola.isEmpty()){
           int var=(int)cola.removeFirst();
           output.add(var);
           LinkedList suc = new LinkedList(g.getSuccessors(var));
           for(int i=suc.size()-1; i>=0; i--){
               if(!visited[(int)suc.get(i)]){
                   cola.addFirst((int)suc.get(i));
                   visited[(int)suc.get(i)]=true;
                }
            }
        }
        return output;
     }
     
     public static void main(String[] args)
    {
        System.out.println("---BFS con Listas---");
        GraphAL gal = new GraphAL(7);
        gal.addArc(0,1,4);
        gal.addArc(0,2,8);
        gal.addArc(1,2,9);
        gal.addArc(1,4,10);
        gal.addArc(1,3,8);
        gal.addArc(2,3,2);
        gal.addArc(2,5,1);
        gal.addArc(3,4,7);
        gal.addArc(3,5,9);
        gal.addArc(4,5,5);
        gal.addArc(4,6,6);
        gal.addArc(5,6,2);
          
        ArrayList<Integer> path = bfs(gal,0);
        for (int i  = 0; i < path.size(); i++)
            System.out.println(path.get(i));
    }
}