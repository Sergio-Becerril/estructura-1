/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.*;
import lists.ArrayList;
import sorts.Shellsort;
import trees.BTree;
import queue.NumericPriorityQueue;

/**
 *
 * @author sergiob.t.
 */
public class ExamenFinal {

    public static void main(String[] args) {
        Stack<String> texto = new Stack<>();
        Stack<String> reserva = new Stack<>();
        NumericPriorityQueue libros = new NumericPriorityQueue();
        Scanner read = new Scanner(System.in);
        NumericPriorityQueue words = new NumericPriorityQueue();
        Random ran = new Random();

        String opcion1 = null, opcion2 = null, opcion3 = null;
        String object = null, prioridad = null;

        //1
        /*
        do {
            System.out.println("Desea agregar un libro?"
                    + "\n'1' si"
                    + "\n cualquier otro, no");
            opcion1 = read.nextLine();
            switch (opcion1) {
                case "1":
                    agregarLibro(libros);
                    break;
                default:
                    opcion1 = "0";
                    break;
            }
        } while (opcion1!="0");
         */
        //2
        /*
        System.out.println("('f' para salir; '1' para deshacer y '2' para rehacer) "
                + "\nIngrese su texto: \n");
        do {
            opcion2 = read.nextLine();
            if (opcion2.equals("f")) {
                opcion2 = "f";
            } else {
                deshacer( texto,reserva, opcion2);
            } 
        } while (opcion2 != "f");
         */
        //3
        //palabras();
        /*
        do {
            System.out.println("Desea agregar otro elemento a la lista?"
                    + "\n'1' si"
                    + "\n cualquier otro, no");
            opcion3 = read.nextLine();
            switch (opcion3) {
                case "1":
                    System.out.println("Ingresa el valor");
                    object = read.nextLine();
                    System.out.println("Ingresa la prioridad:");
                    prioridad = read.nextLine();
                    palabrasPrioridad(words, object, prioridad);
                    break;
                default:
                    opcion3 = "0";
                    break;
            }

        } while (opcion3 != "0");
        */
        //4
        bTree();
        

    }

    //1
    public static void agregarLibro(NumericPriorityQueue libros) {
        Random ran = new Random();

        int year = ran.nextInt(1990, 2007), num = ran.nextInt(0, 9999);
        String number = null, isbn = null, id = null;

        if (num < 10) {
            number = "000" + num;
        } else if (num < 100) {
            number = "00" + num;
        } else if (num < 1000) {
            number = "0" + num;
        } else {
            number = String.valueOf(num);
        }
        id = "ISBN-" + year + "-" + number + "";
        isbn = String.valueOf(year) + number;

        libros.enqueue(id, Integer.parseInt(isbn));

        System.out.println("Libro agregado: " + id);
        System.out.println(libros.toString());
    }

    //2
    public static void deshacer(Stack<String> texto, Stack<String> reserva, String ingreso) {

        switch (ingreso) {
            case "1":
                if (!texto.isEmpty()) {
                    reserva.add(texto.pop());
                    System.out.println("Deshaciendo");
                    System.out.println("Texto completo: " + texto.toString());
                } else {
                    System.out.println("No hay nada que deshacer");
                }
                break;
            case "2":
                if (!reserva.isEmpty()) {
                    texto.add(reserva.pop());
                    System.out.println("Rehaciendo");
                    System.out.println("Texto completo: " + texto.toString());
                } else {
                    System.out.println("No hay nada que rehacer");
                }

                break;
            default:
                texto.add(ingreso);
                break;
        }

    }

    //3
    public static void palabras() {
        NumericPriorityQueue words = new NumericPriorityQueue();
        words.enqueue("Menos", 2);
        words.enqueue("Avion", 3);
        words.enqueue("Nabucodonosor", 6);
        words.enqueue("Bebida", 3);
        words.enqueue("planta", 2);
        words.enqueue("Centro comercial", 6);
        words.enqueue("Angelópolis", 5);
        words.enqueue("Ana", 2);
        words.enqueue("Corleone", 4);
        words.enqueue("Cthulhu", 2);
        System.out.println(words.toString());
    }

    public static void palabrasPrioridad(NumericPriorityQueue words, Object objecto, String palabra) {
        
        int index = 0;
        switch (palabra) {
            case "Menos":
                index = 2;

                break;
            case "Avion":
                index = 3;

                break;
            case "Nabucodonosor":
                index = 6;

                break;
            case "Bebida":
                index = 3;

                break;
            case "planta":
                index = 2;

                break;
            case "Centro comercial":
                index = 6;

                break;
            case "Angelópolis":
                index = 5;

                break;
            case "Ana":
                index = 2;
                break;
            case "Cthulhu":
                index = 2;
                break;
            case "Corleone":
                index = 4;
                break;
            default:
                index = -1;
                break;
        }
        if (index == -1) {
            System.out.println("Error");
        } else {
            words.enqueue(objecto, index);
        }

        System.out.println(words.toString());
    }

    //4
    public static void bTree(){
        BTree tree=new BTree();
        tree.add(67);
        tree.add(43);
        tree.add(80);
        tree.add(11);
        tree.add(55);
        tree.add(70);
        tree.add(92);
        tree.add(5);
        tree.add(13);
        tree.add(50);
        tree.add(56);
        tree.add(68);
        tree.add(74);
        tree.add(90);
        tree.add(95);
        System.out.println("Preorden:");
        tree.preorden();
        System.out.println("Postorden:");
        tree.postorden();
        System.out.println("Inorden");
        tree.inorden();
        
    }
}
