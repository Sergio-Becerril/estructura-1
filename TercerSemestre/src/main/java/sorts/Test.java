/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

import queue.*;
import java.util.Date;

/**
 *
 * @author sergiob.t.
 */
public class Test {

    public static void main(String[] args) {
        /*
        //Testing: PriorityDateQueue (DateNodo)
        Date d1 = new Date(1); //Before
        Date d2 = new Date();  // Current date 
        Date d3 = new Date(9999999999999L); //After
        Date d4 = new Date(); 
        PriorityDateQueue q=new PriorityDateQueue();
        q.enqueue(1, d1);
        q.enqueue(2, d2);
        q.enqueue(3, d3);
        q.enqueue(0, d4);
        q.enqueue(3, d3);
        q.enqueue(2, d2);
        q.enqueue(1, d1);
        q.enqueue(3, d3);
        System.out.println(q.toString());
        System.out.println("1: "+d1);
        System.out.println("2: "+d2);
        System.out.println("3: "+d3);
        System.out.println(q.dequeue());
        System.out.println(q.toString());
         */

        
        //Testing: Quicksort y Shellsort
        int numeros [] = new int[10];
        Quicksort p=new Quicksort();
        Shellsort s=new Shellsort();
        Array a=new Array();
        a.Asign(numeros);
        a.PrintArray(numeros);
        p.Quicksort(numeros, 0, numeros.length-1);
        //s.Shellsort(numeros);
        System.out.println("///");
        a.PrintArray(numeros);
        
        
        /*
        //Testing: BusquedaBinaria
        BusquedaBinaria b = new BusquedaBinaria();
        int numeros[] = {1, 2, 3, 4, 5, 10, 20};
        int x = 10;
        int resultado = b.BusquedaBinaria(numeros, x);
        if (resultado == -1) {
            System.out.println("No se encontro el numero");
        } else {
            System.out.println("Numero en el indice: " + resultado);
        }
        */

    }

}
