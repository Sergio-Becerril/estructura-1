/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.Random;
import lists.*;
import queue.*;
import sorts.*;

/**
 *
 * @author sergiob.t.
 */
public class SegundoParcial {

    public static void main(String[] args) {
        double[] numeros=new double[5];
        numeros[0]=1;
        numeros[1]=2;
        numeros[2]=3;
        numeros[3]=4;
        numeros[4]=5;
        
        System.out.println(numeros.length);
        System.out.println(promedioNumerosReales(numeros, 0));
       /* ArrayList l = new ArrayList(50);
        LinkedList ll3 = new LinkedList();
        LinkedList ll4 = new LinkedList();
        LinkedQueue e3 = new LinkedQueue();
        LinkedQueue e5 = new LinkedQueue();
        Shellsort s = new Shellsort();
        int[] mediana = new int[50];
        int masVeces = 0, moda=0;
        Random random = new Random();

        //1
        System.out.println("Ejercicio 1:");
        int suma = 0, ran, contador = 0;
        do {
            ran = random.nextInt(1, 100);
            l.add(ran);
            System.out.println(ran);
        } while (l.size() < 50);
        System.out.println(l.toString());
        do {
            String stringA = l.get(contador).toString();
            suma += Integer.parseInt(stringA);
            mediana[contador] = Integer.parseInt(stringA);
            contador += 1;
        } while (contador < 50);
        System.out.println("media aritmetica: " + suma / 50);
        
        s.Shellsort(mediana);
        System.out.println("mediana: " + mediana[24]);
        
        for (int i = 0; i < 50; i++) {
            contador = 0;
            String stringA = l.get(i).toString();
            for (int j = 0; j < 50; j++) {
                String stringB = l.get(j).toString();
                if (stringA.equals(stringB)) {
                    contador += 1;
                }
            }
            if (contador > masVeces) {
                masVeces = contador;
                String stringB = l.get(i).toString();
                moda = Integer.parseInt(stringB);
            }

        }
        System.out.println("moda: " + moda);
        
        //3
        System.out.println("\nEjercicio 3:");
        do {
            ran = random.nextInt(1, 50);
            e3.enqueue(ran);
            System.out.println(ran);
        } while (e3.size() < 50);
        System.out.println(e3.toString());
        for (int i = 0; i < 50; i++) {
            contador = 0;
            String stringA = e3.dequeue().toString();
            for (int j = 0; j < 50; j++) {
                String stringB = l.get(j).toString();
                if (stringA.equals(stringB)) {
                    contador += 1;
                }
            }
            if (contador ==0) {
                ll3.add(stringA);
            }
            
        }
        
        System.out.println("Numeros que no se repiten: "+ll3.toString());
        
        //5
        contador=0;
        System.out.println("\nEjercicio 5:");
        do {
            ran = random.nextInt(1, 50);
            e5.enqueue(ran);
            System.out.println(ran);
            if(ran ==25){
                contador+=1;
                e5.dequeue();
                e5.dequeue();
                e5.dequeue();
               
            }
        } while (e5.size() < 50);
        System.out.println("veces que se eliminaron: "+contador);
        System.out.println(e5.toString());*/
    }
    
    public static double promedioNumerosReales(double[] numeros, int inicio){
        double result=0;
        int lenght=numeros.length, guia=0+inicio;
        if(guia<lenght){
            result=(numeros[guia]/lenght)+promedioNumerosReales(numeros,inicio+1);
        }
        return result;
    }
}
