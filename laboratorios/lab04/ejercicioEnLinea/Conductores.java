import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
/**
 * Ejercicio Conductores.
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */

public class Conductores {
    public static int numeroConductores;
    public static int distancia;
    public static int excedente;
	public static int[] mañana;
	public static int[] tarde;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner input = new Scanner(System.in);
		
		while(true){
			numeroConductores = input.nextInt();
			distancia = input.nextInt();
			excedente = input.nextInt();
			if(numeroConductores == 0 && distancia == 0 && excedente == 0){
			    break;
			 }
			
			mañana = new int[numeroConductores];
			tarde = new int[numeroConductores];
			
			for(int i = 0; i < numeroConductores; i++){
			    mañana[i] = input.nextInt();
			 }
			 
			for(int i = 0; i < numeroConductores; i++){
			    tarde[i] = -input.nextInt();
			 }
			
			Arrays.sort(mañana);
			Arrays.sort(tarde);
			
			int valor = 0;
			for(int i = 0; i < numeroConductores; i++){
	            int resultado = mañana[i] + (-tarde[i]);
	            if(resultado > distancia){
	                valor += (resultado - distancia) * excedente;
	            }
	        }
			System.out.println(valor);
		}
	}
}
	
	
