
/**
 * Levenshtein.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */
public class Levenshtein
{
    /** Método minimum, el cual verifica cual es el número menor entres tres números.
      * @params a - primer número entero. b - segundo número entero. c tercer número entero
      * @return el menor número.
      */
    int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
    /** Método Levenshtein, el cual calcula el número mínimo de operaciones requeridas para
     * transformar una cadena de caracteres en otra.
      * @params lhs - cadena de caracteres. rhs - cadena de caracteres.
      * @return distance - número mínimo de operaciones requeridas para
     * transformar una cadena de caracteres en otra.
      */
    int Levenshtein(String lhs, String rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() +1];
        for (int i = 0; i <= lhs.length(); i++) {
            distance[i][0] = i;
        }
        
        for (int j = 1; j <= rhs.length(); j++) {
            distance[0][j] = j;
        }
        
        for (int i = 1; i <= lhs.length(); i++) {
            for (int j = 1; j <= rhs.length(); j++) {
                distance[i][j] = minimum(
                distance[i - 1][j] + 1,
                distance[i][j - 1] + 1,
                distance[i - 1][j - 1] +
                ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));
            }
        }
        return distance[lhs.length()][rhs.length()];
    }
}
