import java.util.ArrayList;
/**
 * Write a description of class taller7 here.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */
public class taller7
{
    private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i=0; i<dist.length; i++) {
           if (!v[i] && dist[i]<x) {
               y=i; 
               x=dist[i];
            }
        }
        return y;
    }
    
    static int [] dijsktra(Graph dg, int source) {
        final int [] dist = new int [dg.size()];  
        final int [] pred = new int [dg.size()];  
        final boolean [] visited = new boolean [dg.size()];
        
        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE; 
        }
        dist[source] = 0;
  
        for (int i=0; i<dist.length; i++) {
           final int next = minVertex (dist, visited);
           visited[next] = true;
  
           final ArrayList<Integer> n = dg.getSuccessors (next); 
           for (int j=0; j<n.size(); j++) {
              final int v = n.get(j);
              final int d = dist[next] + dg.getWeight(next,v);
              if (dist[v] > d) {
                 dist[v] = d;
                 pred[v] = next;
              }
           }
        }
        return pred;
    }

    public static int [] prim (Graph G, int s) {
        final int [] dist = new int [G.size()];  
        final int [] pred = new int [G.size()];  
        final boolean [] visited = new boolean [G.size()]; 
  
        for (int i=0; i<dist.length; i++) {
           dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
  
        for (int i=0; i<dist.length; i++) {
           final int next = minVertex (dist, visited);
           visited[next] = true;
  
           final ArrayList<Integer> n = G.getSuccessors (next);
           for (int j=0; j<n.size(); j++) {
              final int v = n.get(j);
              final int d = G.getWeight(next,v);
              if (dist[v] > d) {
                 dist[v] = d;
                 pred[v] = next;
              }
           }
        }
        return pred;
     }
}
