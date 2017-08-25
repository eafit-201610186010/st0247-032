import java.util.ArrayList;

/**
 * Taller 5 - Backtracking con grafos
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar
 */
public class Taller5 {
    final int V = 4;
    int color[];

    public  boolean mColoring(Digraph g, int m) {
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        if (!mColoring(g, m, color, 0))
        {
            System.out.println("No existe solución");
            return false;
        }
 
        return true;
    }

    // recomendacion
    private boolean isSafe(Digraph g, int v, int[] colors, int c) {
        for (int i = 0; i < V; i++)
           if (g.getSuccessors(i).contains(1) && c == color[i])
                return false;
        return true;
    }

    // recomendacion
    private boolean mColoring(Digraph g, int v, int[] colors, int m) {
        if (v == V)
            return true;
 
        for (int c = 1; c <= m; c++)
        {
            if (isSafe(g, v, color, c))
            {
                color[v] = c;
                if (mColoring(g, m,
                                      color, v + 1))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }
}