/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author sergiob.t.
 */
public class Seleccion {

    public static void MetodoSeleccion(int[] numero) {
        System.out.println("Seleccion");
        Array.Asign(numero);
        System.out.println("Arreglo inicial");
        Array.PrintArray(numero);
        int guia = 0, menor = 0, index = 0;
        for (int i = 0; i < numero.length; i++) {
            menor = numero[i];
            index = i;
            for (int j = i + 1; j < numero.length; j++) {
                if (numero[j] < menor) {
                    menor = numero[j];
                    index = j;
                }
            }
            guia = numero[i];
            numero[i] = menor;
            numero[index] = guia;
        }
    }
}
