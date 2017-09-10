import java.util.Arrays;
import java.util.Scanner;
/**
 * Write a description of class MonedasVoraz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonedasVoraz{
  private static void monedas(int[] monedas, int valor, int i, int[] resp){
      resp[i] = valor / monedas[i];
      if (valor % monedas[i] != 0) {
          monedas(monedas, valor % monedas[i], i + 1, resp);
      }
  }
  
  public static int[] monedas(int[] denominacionesOrdenadas, int valor){
      int[] resp = new int[denominacionesOrdenadas.length];
      monedas(denominacionesOrdenadas, valor, 0, resp);
      return resp;
  }
  
  public static void main(String[] args){
      System.out.println(Arrays.toString(monedas(new int[] {1000,500,200,100,50}, 2650)));
  }
}

