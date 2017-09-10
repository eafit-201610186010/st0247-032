import java.util.Scanner;
/**
 * Esta clase es una implementación del problema de las n reinas
 * 
 * @author Camilo Cruz Villegas, Cristian Villlamizar 
 * @version 1
 */
public class Reinas
{   /**
    * Método reinas - Crea un arreglo de tamaño n, llama al método reinasAux y calcula el tiempo de ejecución
    * @param n - Número de reinas
    */
    public static void reinas(int n) {
        int[] tablerito = new int[n];
        long startTime = System.currentTimeMillis();
        reinasAux(tablerito, 0);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Se demoró " + estimatedTime + " ms para n = " + n);
    }

    /**
    * Método reinasAux - Realiza las n! permutaciones 
    * @params tablerito - Tablero en el que se deben colocar las n reinas, index - índice 
    */
    private static void reinasAux(int[] tablerito, int index) {     
        // Condición parada
        if (index == tablerito.length) {
            if (!seAtacan(tablerito))
                imprimir(tablerito);
            } else
            for(int i = 0; i < tablerito.length; i++)
            {
                tablerito[index] = i;
                reinasAux(tablerito, index+1);
            }
    }
   
    /**
    * Método seAtacan - verifica si la reina i ataca a la reina j.
    * @param tablerito - Tablero en el que se deben colocar las n reinas
    * @return true si las reinas no se atacan o false en lo contrario
    */
    public static boolean seAtacan(int[] tablerito) { 
        for(int i = 0; i < tablerito.length; i++)
            for(int j = i+1; j < tablerito.length; j++)
                if (tablerito[i] == tablerito[j] || 
                    Math.abs(tablerito[i] - tablerito[j]) == Math.abs(i - j))
                    return true; 
            return false;
    }

    /**
    * Método imprimir - Imprime el tablero de ajedrez con las reinas colocadas, de tal manera que no se ataquen
    * @param arreglo - Tablero en el que se deben colocar las n reinas
    */
    public static void imprimir(int[] arreglo) {  
        for(int i = 0; i < arreglo.length; i++) {
            for(int j = 0; j < arreglo.length; j++)
                if (j == arreglo[i])
                    System.out.print("Q");
                else
                System.out.print("*");
            System.out.println();
      }
      System.out.println();
    }

    /**
    * Metodo main que activa los metodos
    */
    public static void main(String[] args) {
        System.out.println("Introduzca el número de reinas: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        reinas(num);
    }
}