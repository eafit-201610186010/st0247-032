
/**
 * SubsecuenciaComunMasLarga.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */
public class SubsecuenciaComunMasLarga
{
    /** Método lcsdyn.
      * @params x - cadena de caracteres. y - cadena de caracteres.
      * @return table - longitud de la secuencia más larga presente en ambas cadenas.
      */
    public static int lcsdyn(String x, String y) {
        int i,j;
        int lenx = x.length();
        int leny = y.length();
        int[][] table = new int[lenx+1][leny+1];
        // Inicializa la tabla para guardar los prefijos
        // Esta inicialización para las cadenas vacías
        for (i=0; i<=lenx; i++) {
            table[i][0] = 0;
        }
        
        for (i=0; i<=leny; i++) {
            table[0][i] = 0;
        }
        
        // Llena cada valor de arriba a abajo
        // y de izquierda a derecha
        for (i = 1; i<=lenx; i++) {
            for (j = 1; j<=leny; j++) {
                // Si el último caracter es igual
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    table[i][j] = 1+table[i-1][j-1];
                } else {// De lo contrario, tome el máximode los adyacentes
                    table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            // Retornar la respuesta (tipo entero, ojo)
        }
        return table[lenx][leny];
    }
}
