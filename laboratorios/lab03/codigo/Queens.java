import java.util.Arrays;
import java.util.Scanner;

/**
 * Queens con Backtracking.
 * 
 * @author Camiloo Cruz Villegas, Cristian Villamizar
 * @version 1
 */
public class Queens
{
    int[] x;
    
    /** Constructor Queens.
      * @params n - número de reinas.
      */
    public Queens(int n) {
        x = new int[n];
    }
    
    /** método queens.
     * Llama al método placeNqueens
      */
    public void queens() {
        placeNqueens(0, x.length);
    }

     /** Método canPlaceQueen.
      * @params r - fila del tablero. c - columna del tablero.
      * @return true si una reina puede ser colocada en la fila r, columna c
      * de lo contrario retorna false
      */
    public boolean canPlaceQueen(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }

    /** Método printQueens, imprime el tablero con las reinas colocadas.
      * @params x - Tablero de ajedrez.
      */
    public void printQueens(int[] x) {
        int N = x.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /** Método placeNqueens, imprime todos los posibles colocamientos de las n reinas en un
     * tablero de ajedrez de longitud n x n.
      * @params r - fila del tablero. c - columna del tablero.
      */
    public void placeNqueens(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (canPlaceQueen(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    printQueens(x);
                } else {
                    placeNqueens(r + 1, n);
                }
            }
        }
    }

    /** Main
     */
    public static void main(String[] args) {
        System.out.println("Introduzca el número de reinas: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Queens q = new Queens(num);
        q.queens();
    }
}
