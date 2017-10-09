
/**
 * Taller8
 * 
 * @author Camilo Cruz Villegas, Cristian Villamizar 
 * @version 1
 */
public class Taller8
{
    private int[] numeros;
    private int[] helper;

    private int numero;

    public void mergeSort(int[] a) {
        this.numeros = a;
        numero = a.length;
        this.helper = new int[numero];
        mergeSortAux(0, numero - 1);
    }

    private void mergeSortAux(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSortAux(low, middle);
            mergeSortAux(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numeros[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numeros[k] = helper[i];
                i++;
            } else {
                numeros[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numeros[k] = helper[i];
            k++;
            i++;
        }
    } 
 
    private int length;
    
    public void quickSort(int[] a) {
         
        if (a == null || a.length == 0) {
            return;
        }
        this.numeros = a;
        length = a.length;
        quickSortAux(0, length - 1);
    }
 
    private void quickSortAux(int low, int high) {
         
        int i = low;
        int j = high;
        int pivote = numeros[low+(high-low)/2];
        while (i <= j) {
            while (numeros[i] < pivote) {
                i++;
            }
            while (numeros[j] > pivote) {
                j--;
            }
            if (i <= j) {
                Intercambiarnumeros(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSortAux(low, j);
        if (i < high)
            quickSortAux(i, high);
    }
 
    private void Intercambiarnumeros(int i, int j) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }
     
    public static void main(String a[]){
        Taller8 sorter = new Taller8();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        
        System.out.println("Merge Sort: ");
        
        sorter.mergeSort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("Quick Sort: ");
        
        sorter.quickSort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }
}
