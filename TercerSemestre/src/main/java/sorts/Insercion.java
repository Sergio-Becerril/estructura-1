/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author sergiob.t.
 */
public class Insercion {

    public static void MetodoInsercion(int[] numero) {
        System.out.println("Insercion");
        Array.Asign(numero);
        System.out.println("Arreglo inicial:");
        Array.PrintArray(numero);
        int guia = 0;
        for (int i = 0; i < numero.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numero[j] > numero[j - 1]) {
                    guia = numero[j];
                    numero[j] = numero[j - 1];
                    numero[j - 1] = guia;
                }
            }
        }
    }
}
