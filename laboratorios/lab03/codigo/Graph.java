import java.util.ArrayList;
/**
 * Abstract class for implementations of Digraphs
 * 
 * @author Mauricio Toro
 * @version 1
 */
public abstract class Graph
{
   /** Atributo para almacenar el tamaño del grafo */
   protected int size;
   
   /**
    * Método constructor.
    * @params vertices - Número de vértices del grafo.
    * Almacena en la variable size la cantidad de vértices del grafo.
    */
   public  Graph(int vertices) 
   {
       size = vertices;
   }
   /** Método para añadir un arco al grafo */
   public  abstract void addArc(int source, int destination, int weight);
   /** Método para obtener los sucesores de un vértice */
   public abstract ArrayList<Integer> getSuccessors(int vertice);
   /** Método para obtener el peso */
   public abstract int getWeight(int source, int destination);
   /** Método que retorna el tamaño del grafo */
   public  int size() {return size;}
}
