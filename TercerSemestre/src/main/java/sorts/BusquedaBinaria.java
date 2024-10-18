/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author sergiob.t.
 */
public class BusquedaBinaria {

    public static int BusquedaBinaria(int[] numeros, int valor) {
        int min = 0, max = numeros.length - 1, mitad, resultado=-1;
        while (min <= max) {
            mitad = min + ((max - min) / 2);
            if (numeros[mitad] == valor) {
                resultado= mitad;
                break;
            } else if (numeros[mitad] < valor) {
                min = mitad + 1;
            } else {
                max = mitad - 1;
            }
        }
        return resultado;
    }
}
