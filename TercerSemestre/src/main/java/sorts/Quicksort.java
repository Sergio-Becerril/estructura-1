/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author sergiob.t.
 */
public class Quicksort {

    public static void Quicksort(int numeros[], int izq, int der) {
        int pivote = numeros[izq];
        int left = izq, right = der, guia;
        while (left < right) {
            while (numeros[left] <= pivote && left < right) {
                left++;
            }
            while (numeros[right] > pivote) {
                right--;
            }
            if (left < right) {
                guia = numeros[left];
                numeros[left] = numeros[right];
                numeros[right] = guia;
            }
        }
        numeros[izq] = numeros[right];
        numeros[right] = pivote;
        if (izq < right - 1) {
            Quicksort(numeros, izq, right - 1);
        }
        if (right + 1 < der) {
            Quicksort(numeros, right + 1, der);
        }
    }

}
