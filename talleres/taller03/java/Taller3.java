package Taller__3;

public class Taller3 {

	//Ejercicio 1	
	
	public static void torresDeHannoi(int n) {
		torresDeHannoiAux(n, 1, 2, 3);
	}
	private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
		if(n == 1){
			System.out.println("Mover disco "+  n + " desde " + origen + " hasta " + destino);
		}
		else{
			torresDeHannoiintermedio(n-1, origen, destino, intermedio);
			
			System.out.println("Mover disco " + n + " desde " + origen + " hasta " + destino  );
			
			torresDeHannoiintermedio(n-1, intermedio, origen, destino);	
		}
	}
		
		
	//Ejercicio 2	
	
	public static void combinations(String s) { 
		combinationsAux("", s); 
		}
	private static void combinationsAux(String prefix, String s) {  
		if (s.length() > 0) {
            		System.out.println(prefix + s.charAt(0));
            		combinationsintermedio(prefix + s.charAt(0), s.substring(1));
            		combinationsintermedio(prefix, s.substring(1));
        	}
	}
		
		
	//Ejercicio 3	
	
	public static void permutation(String str) {
		permutation("", str); 
	}
	
	private static void permutation(String prefix, String str) {
		int n = str.length();
        	if (n == 0) System.out.println(prefix);
        	else {
            		for (int i = 0; i < n; i++)
                	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            	}	
	}
}
