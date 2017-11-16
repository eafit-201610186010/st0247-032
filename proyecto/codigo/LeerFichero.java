import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

/**
 * Lectura de ficheros
 *
 * @author Camilo Cruz Villegas
 * @author Cristian Villamizar
 */
public class LeerFichero {

    private ArrayList<Integer> keys = new ArrayList<Integer>();

    /**
     * Metodo que lee la entrada tipo archivo
     *
     * @param fichero fichero de entrada
     * @return retorna los verices y las coordenadas
     * @throws FileNotFoundException, IOException
     */
    public HashMap read(String fichero) throws FileNotFoundException, IOException {
        Scanner lectura = new Scanner(new File(fichero));//"medellin_colombia-grande.txt"

        HashMap<Integer, Pareja> nodos = new HashMap<Integer, Pareja>();
        while (lectura.hasNextLine()) {
            String vectortxt = lectura.nextLine();
            String[] vectort = vectortxt.split(" ");

            int id = Integer.parseInt(vectort[0]);
            double y = Double.parseDouble(vectort[1]);
            double x = Double.parseDouble(vectort[2]);
            Pareja par = new Pareja(y, x);

            keys.add(id);
            nodos.put(id, par);
        }
        return nodos;
    }

    public ArrayList<Integer> getKeys() {
        return keys;
    }
}