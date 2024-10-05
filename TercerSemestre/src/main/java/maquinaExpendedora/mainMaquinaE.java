/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maquinaExpendedora;

import java.util.Scanner;
import queue.CircularQueue;

/**
 * @author sergiob.t.
 */
public class mainMaquinaE {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String opcionMenu = null, numeroValidacion = null, opcionProductoA = null,
                comprarProducto = null, monedaIngresada = null;
        int numero = 0, contadorM10 = 0, contadorM5 = 0, contadorM2 = 0, contadorM1 = 0, contadorM05 = 0;
        double totalIngresado = 0, cambio = 0;
        boolean esNumero = true;
        //Monedas
        CircularQueue m10 = new CircularQueue(15);
        CircularQueue m5 = new CircularQueue(15);
        CircularQueue m2 = new CircularQueue(15);
        CircularQueue m1 = new CircularQueue(15);
        CircularQueue mp5 = new CircularQueue(15);
        //Productos
        CircularQueue p1 = new CircularQueue(10);//X1: Runners,    62g,   $15
        CircularQueue p2 = new CircularQueue(10);//X2: Doritos,    76g,   $15.5
        CircularQueue p3 = new CircularQueue(10);//X3: Takis,      56g,   $14.5
        CircularQueue p4 = new CircularQueue(10);//X4: Cheetos,    61g,   $14
        CircularQueue p5 = new CircularQueue(10);//X5: Sabritas,   45g,   $18
        CircularQueue p6 = new CircularQueue(10);//Y1: Dr. pepper, 600ml, $17
        CircularQueue p7 = new CircularQueue(10);//Y2: Fanta,      355ml, $10
        CircularQueue p8 = new CircularQueue(10);//Y3: Sprite,     600ml, $15.5
        CircularQueue p9 = new CircularQueue(10);//Y4: Pepsi,      355ml, $9.5
        CircularQueue p10 = new CircularQueue(10);//Y5: Coca-cola, 600ml, $17.5        

        for (int index = 0; index < 8; index++) {
            //p
            p1.enqueue("Runners");
            p2.enqueue("Doritos");
            p3.enqueue("Takis");
            p4.enqueue("Cheetos");
            p5.enqueue("Sabritas");
            p6.enqueue("Dr. pepper");
            p7.enqueue("Fanta");
            p8.enqueue("Sprite");
            p9.enqueue("Pepsi");
            p10.enqueue("Coca-cola");
            //m
            m10.enqueue("10");
            m5.enqueue("5");
            m2.enqueue("2");
            m1.enqueue("1");
            mp5.enqueue("0.5");
        }
        System.out.println("Acercandose...\n");
        do {
            System.out.println("\nMaquina Expendedora(M.E)\n"
                    + "|------------------------------|\n"
                    + "|X1: Runners,    62g,   $15    |\n"
                    + "|X2: Doritos,    76g,   $15.5  |\n"
                    + "|X3: Takis,      56g,   $14.5  |\n"
                    + "|X4: Cheetos,    61g,   $14    |\n"
                    + "|X5: Sabritas,   45g,   $18    |\n"
                    + "|------------------------------|\n"
                    + "|Y1: Dr. pepper, 600ml, $17    |\n"
                    + "|Y2: Fanta,      355ml, $10    |\n"
                    + "|Y3: Sprite,     600ml, $15.5  |\n"
                    + "|Y4: Pepsi,      355ml, $9.5   |\n"
                    + "|Y5: Coca-cola,  600ml, $17.5  |\n"
                    + "|------------------------------|\n");
            System.out.println("MC--Que deberia hacer...\n"
                    + "1: Comprar\n"
                    + "2: Ver lo que hay (Imprimir estado)\n"
                    + "3: Irse\n"
                    + "???: Ingresar 'Key'");
            opcionMenu = read.nextLine();
            switch (opcionMenu) {
                case "Key"://AgregarProducto
                    System.out.println("MC--Deberia rellenar la maquina\n"
                            + "Abriendo M.E...\n"
                            + "MC--Que deberia llenar...\n"
                            + "1: Productos\n"
                            + "2: Monedas");
                    opcionMenu = read.nextLine();
                    if (opcionMenu.equals("1")) {
                        do {
                            System.out.println("M.E--Producto a abastecer\n"
                                    + "MC--Cual producto elijo...\n"
                                    + "X1, X2, X3, X4, X5\n"
                                    + "Y1, Y2, Y3, Y4, Y5\n"
                                    + "0: Ninguno");
                            opcionProductoA = read.nextLine();
                            if (!opcionProductoA.equals("0")) {
                                do {
                                    System.out.println("M.E--Cantidad a abastecer");
                                    numeroValidacion = read.nextLine();
                                    if (!numeroValidacion.equals("0") && !numeroValidacion.equals("1") && !numeroValidacion.equals("2")
                                            && !numeroValidacion.equals("3") && !numeroValidacion.equals("10")
                                            && !numeroValidacion.equals("4") && !numeroValidacion.equals("5")
                                            && !numeroValidacion.equals("6") && !numeroValidacion.equals("7")
                                            && !numeroValidacion.equals("8") && !numeroValidacion.equals("9")) {
                                        System.out.println("M.E--Error: Debe ser un numero entero entre 0 y 10");
                                        esNumero = false;
                                    } else {
                                        esNumero = true;
                                    }
                                } while (esNumero == false);
                                numero = Integer.parseInt(numeroValidacion);
                            }
                            switch (opcionProductoA) {
                                case "X1"://p1
                                    if (p1.isFull() == false && (p1.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p1.enqueue("Runners");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p1.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "X2"://p2
                                    if (p2.isFull() == false && (p2.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p2.enqueue("Doritos");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p2.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "X3"://p3
                                    if (p3.isFull() == false && (p3.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p3.enqueue("Takis");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p3.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "X4"://p4
                                    if (p4.isFull() == false && (p4.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p4.enqueue("Cheetos");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p4.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "X5"://p5
                                    if (p5.isFull() == false && (p5.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p5.enqueue("Sabritas");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p5.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "Y1"://p6
                                    if (p6.isFull() == false && (p6.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p6.enqueue("Dr. pepper");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p6.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "Y2"://p7
                                    if (p7.isFull() == false && (p7.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p7.enqueue("Fanta");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p7.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                case "Y3"://p8
                                    if (p8.isFull() == false && (p8.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p8.enqueue("Sprite");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p8.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "Y4"://p9
                                    if (p9.isFull() == false && (p9.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p9.enqueue("Pepsi");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p9.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "Y5"://p10
                                    if (p10.isFull() == false && (p10.size() + numero) < 11) {
                                        for (int index = 0; index < numero; index++) {
                                            p10.enqueue("Coca-cola");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (p10.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar del producto"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "0"://Cancelar
                                    System.out.println("Cerrando M.E...\n");
                                    opcionProductoA = "0";
                                    break;
                                default:
                                    System.out.println("M.E--Error: Ingresa un codigo de producto aceptable\n"
                                            + "MC--Parece que no puedo hacer eso\n");
                                    break;
                            }
                        } while (opcionProductoA != "0");
                    } else if (opcionMenu.equals("2")) {
                        do {
                            System.out.println("M.E--Moneda a abastecer\n"
                                    + "MC--Cual moneda elijo...\n"
                                    + "10, 5, 2, 1, 0.5\n"
                                    + "0: Ninguno");
                            opcionProductoA = read.nextLine();
                            if (!opcionProductoA.equals("0")) {
                                do {
                                    System.out.println("M.E--Cantidad a abastecer");
                                    numeroValidacion = read.nextLine();
                                    if (!numeroValidacion.equals("0") && !numeroValidacion.equals("2")
                                            && !numeroValidacion.equals("3") && !numeroValidacion.equals("10")
                                            && !numeroValidacion.equals("4") && !numeroValidacion.equals("5")
                                            && !numeroValidacion.equals("6") && !numeroValidacion.equals("7")
                                            && !numeroValidacion.equals("8") && !numeroValidacion.equals("9")
                                            && !numeroValidacion.equals("11") && !numeroValidacion.equals("12")
                                            && !numeroValidacion.equals("13") && !numeroValidacion.equals("15")
                                            && !numeroValidacion.equals("14") && !numeroValidacion.equals("1")) {
                                        System.out.println("M.E--Error: Debe ser un numero entero entre 0 y 15");
                                        esNumero = false;
                                    } else {
                                        esNumero = true;
                                    }
                                } while (esNumero == false);
                                numero = Integer.parseInt(numeroValidacion);
                            }
                            switch (opcionProductoA) {
                                case "10"://m10
                                    if (m10.isFull() == false && (m10.size() + numero) < 16) {
                                        for (int index = 0; index < numero; index++) {
                                            m10.enqueue("10");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (m10.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar de la moneda"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "5"://m5
                                    if (m5.isFull() == false && (m5.size() + numero) < 16) {
                                        for (int index = 0; index < numero; index++) {
                                            m5.enqueue("5");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (m5.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar de la moneda"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "2"://m2
                                    if (m2.isFull() == false && (m2.size() + numero) < 16) {
                                        for (int index = 0; index < numero; index++) {
                                            m2.enqueue("2");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (m2.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar de la moneda"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "1"://m1
                                    if (m1.isFull() == false && (m1.size() + numero) < 16) {
                                        for (int index = 0; index < numero; index++) {
                                            m1.enqueue("1");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (m1.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar de la moneda"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "0.5"://mp5
                                    if (mp5.isFull() == false && (mp5.size() + numero) < 16) {
                                        for (int index = 0; index < numero; index++) {
                                            mp5.enqueue("0.5");
                                            System.out.println("Rellenando...");
                                        }
                                    } else if (mp5.isFull()) {
                                        System.out.println("M.E--Error: Cantidad maxima alcanzada\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    } else {
                                        System.out.println("M.E--Error: El numero que se quiere ingresar de la moneda"
                                                + "sobrepasara la cantidad maxima\n"
                                                + "MC--Parece que no puedo hacer eso\n");
                                    }
                                    break;
                                case "0"://Cancelar
                                    System.out.println("Cerrando M.E...\n");
                                    opcionProductoA = "0";
                                    break;
                                default:
                                    System.out.println("M.E--Error: Ingresa una denominacion de moneda aceptable\n"
                                            + "MC--Parece que no puedo hacer eso\n");
                                    break;
                            }
                        } while (opcionProductoA != "0");
                    } else {
                        System.out.println("Cerrando M.E...\n");
                    }
                    break;

                case "1"://ComprarProducto
                    do {
                        contadorM10 = 0;
                        contadorM5 = 0;
                        contadorM2 = 0;
                        contadorM1 = 0;
                        contadorM05 = 0;
                        totalIngresado = 0;
                        System.out.println("MC--Que compro...\n"
                                + "X1, X2, X3, X4, X5\n"
                                + "Y1, Y2, Y3, Y4, Y5\n"
                                + "0: Nada");
                        comprarProducto = read.nextLine();
                        if (!comprarProducto.equals("X1") && !comprarProducto.equals("Y1")
                                && !comprarProducto.equals("X2") && !comprarProducto.equals("Y2")
                                && !comprarProducto.equals("X3") && !comprarProducto.equals("Y3")
                                && !comprarProducto.equals("X4") && !comprarProducto.equals("Y4")
                                && !comprarProducto.equals("X5") && !comprarProducto.equals("Y5") && !comprarProducto.equals("0")) {
                            System.out.println("M.E--Error: Ingresa un codigo de producto aceptable\n"
                                    + "MC--Parece que no puedo hacer eso\n");
                        }
                    } while (!comprarProducto.equals("X1") && !comprarProducto.equals("Y1")
                            && !comprarProducto.equals("X2") && !comprarProducto.equals("Y2")
                            && !comprarProducto.equals("X3") && !comprarProducto.equals("Y3")
                            && !comprarProducto.equals("X4") && !comprarProducto.equals("Y4")
                            && !comprarProducto.equals("X5") && !comprarProducto.equals("Y5") && !comprarProducto.equals("0"));
                    if (!comprarProducto.equals("0")) {
                        System.out.println("M.E--Ingresar dinero\n");
                        do {
                            System.out.println("MC--Que moneda uso...\n"
                                    + "10\n"
                                    + "5\n"
                                    + "2\n"
                                    + "1\n"
                                    + "0.5\n"
                                    + "0: Dejar de meter monedas");
                            monedaIngresada = read.nextLine();
                            switch (monedaIngresada) {
                                case "10":
                                    if (!m10.isFull()) {
                                        m10.enqueue("10");
                                        totalIngresado += 10;
                                        contadorM10++;
                                    } else {
                                        System.out.println("M.E--Error: Limite de monedas alcanzado\n"
                                                + "MC--Parece que ya no puedo usar monedas de este valor\n");
                                    }
                                    break;
                                case "5":
                                    if (!m5.isFull()) {
                                        m5.enqueue("5");
                                        totalIngresado += 5;
                                        contadorM5++;
                                    } else {
                                        System.out.println("M.E--Error: Limite de monedas alcanzado\n"
                                                + "MC--Parece que ya no puedo usar monedas de este valor\n");
                                    }
                                    break;
                                case "2":
                                    if (!m2.isFull()) {
                                        m2.enqueue("2");
                                        totalIngresado += 2;
                                        contadorM2++;
                                    } else {
                                        System.out.println("M.E--Error: Limite de monedas alcanzado\n"
                                                + "MC--Parece que yano  puedo usar monedas de este valor\n");
                                    }
                                    break;
                                case "1":
                                    if (!m1.isFull()) {
                                        m1.enqueue("1");
                                        totalIngresado += 1;
                                        contadorM1++;
                                    } else {
                                        System.out.println("M.E--Error: Limite de monedas alcanzado\n"
                                                + "MC--Parece que ya no puedo usar monedas de este valor\n");
                                    }
                                    break;
                                case "0.5":
                                    if (!mp5.isFull()) {
                                        mp5.enqueue("0.5");
                                        totalIngresado += 0.5;
                                        contadorM05++;
                                    } else {
                                        System.out.println("M.E--Error: Limite de monedas alcanzado\n"
                                                + "MC--Parece que ya no puedo usar monedas de este valor\n");
                                    }
                                    break;
                                case "0":
                                    System.out.println("MC--Eso deberia ser suficiente");
                                    monedaIngresada = "0";
                                    break;
                                default:
                                    System.out.println("M.E--Error: Ingresa una denominacion de moneda aceptable\n"
                                            + "MC--Parece que no puedo hacer eso\n");
                                    break;
                            }
                        } while (!monedaIngresada.equals("0"));
                    }

                    switch (comprarProducto) {
                        case "X1":
                            if (!p1.isEmpty() && (totalIngresado - 15) >= 0) {
                                cambio = totalIngresado - 15;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p1.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p1.dequeue());
                                }
                            } else if (p1.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 15) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "X2":
                            if (!p2.isEmpty() && (totalIngresado - 15.5) >= 0) {
                                cambio = totalIngresado - 15.5;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p2.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p2.dequeue());
                                }
                            } else if (p2.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 15.5) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "X3":
                            if (!p3.isEmpty() && (totalIngresado - 14.5) >= 0) {
                                cambio = totalIngresado - 14.5;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p3.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p3.dequeue());
                                }
                            } else if (p3.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 14.5) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "X4":
                            if (!p4.isEmpty() && (totalIngresado - 14) >= 0) {
                                cambio = totalIngresado - 14;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p4.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p4.dequeue());
                                }
                            } else if (p4.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 14) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "X5":
                            if (!p5.isEmpty() && (totalIngresado - 18) >= 0) {
                                cambio = totalIngresado - 18;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p5.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p5.dequeue());
                                }
                            } else if (p5.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 18) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "Y1":
                            if (!p6.isEmpty() && (totalIngresado - 17) >= 0) {
                                cambio = totalIngresado - 17;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p6.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p6.dequeue());
                                }
                            } else if (p6.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 17) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "Y2":
                            if (!p7.isEmpty() && (totalIngresado - 10) >= 0) {
                                cambio = totalIngresado - 10;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p7.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p7.dequeue());
                                }
                            } else if (p7.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 10) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "Y3":
                            if (!p8.isEmpty() && (totalIngresado - 15.5) >= 0) {
                                cambio = totalIngresado - 15.5;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p8.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p8.dequeue());
                                }
                            } else if (p8.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 15.5) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "Y4":
                            if (!p9.isEmpty() && (totalIngresado - 9.5) >= 0) {
                                cambio = totalIngresado - 9.5;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p9.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p9.dequeue());
                                }
                            } else if (p9.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 9.5) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        case "Y5":
                            if (!p10.isEmpty() && (totalIngresado - 17.5) >= 0) {
                                cambio = totalIngresado - 17.5;
                                if (cambio != 0) {
                                    System.out.println("Cambio:");
                                    do {
                                        if (cambio % 10 == 0 && !m10.isEmpty()) {
                                            System.out.println(m10.dequeue());
                                            cambio -= 10;
                                        } else if (cambio % 5 == 0 && !m5.isEmpty()) {
                                            System.out.println(m5.dequeue());
                                            cambio -= 5;
                                        } else if (cambio % 2 == 0 && !m2.isEmpty()) {
                                            System.out.println(m2.dequeue());
                                            cambio -= 2;
                                        } else if (cambio % 1 == 0 && !m1.isEmpty()) {
                                            System.out.println(m1.dequeue());
                                            cambio -= 1;
                                        } else if (cambio % 0.5 == 0 && !mp5.isEmpty()) {
                                            System.out.println(mp5.dequeue());
                                            cambio -= 0.5;
                                        } else {
                                            System.out.println("M.E--Error: Monedas insuficientes para devolver el cambio\n"
                                                    + "MC--Parece que se acabaron las monedas\n");
                                            System.out.println("M.E--Regresando monedas\n");
                                            cambio = -1;
                                            for (int index = 0; index < contadorM10; index++) {
                                                System.out.println(m10.dequeue());
                                            }
                                            for (int index = 0; index < contadorM5; index++) {
                                                System.out.println(m5.dequeue());
                                            }
                                            for (int index = 0; index < contadorM2; index++) {
                                                System.out.println(m2.dequeue());
                                            }
                                            for (int index = 0; index < contadorM1; index++) {
                                                System.out.println(m1.dequeue());
                                            }
                                            for (int index = 0; index < contadorM05; index++) {
                                                System.out.println(mp5.dequeue());
                                            }
                                        }
                                    } while (cambio != 0 && cambio != -1);
                                    if (cambio == 0) {
                                        System.out.println("\n*Clank*\n" + p10.dequeue());
                                    }
                                } else {
                                    System.out.println("\n*Clank*\n" + p10.dequeue());
                                }
                            } else if (p10.isEmpty()) {
                                System.out.println("M.E--Error: Producto agotado\n"
                                        + "MC--Parece que se acabo\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            } else if ((totalIngresado - 17.5) < 0) {
                                System.out.println("M.E--Error: Cantidad incorrecta\n"
                                        + "MC-- ...Parece que no\n");
                                System.out.println("M.E--Regresando monedas\n");
                                for (int index = 0; index < contadorM10; index++) {
                                    System.out.println(m10.dequeue());
                                }
                                for (int index = 0; index < contadorM5; index++) {
                                    System.out.println(m5.dequeue());
                                }
                                for (int index = 0; index < contadorM2; index++) {
                                    System.out.println(m2.dequeue());
                                }
                                for (int index = 0; index < contadorM1; index++) {
                                    System.out.println(m1.dequeue());
                                }
                                for (int index = 0; index < contadorM05; index++) {
                                    System.out.println(mp5.dequeue());
                                }
                            }
                            break;
                        default:
                            System.out.println("MC--Nada me llama la atencion\n");
                            break;
                    }
                    break;
                case "2"://ImprimirEstado
                    System.out.println("\n" + p1.toString());
                    System.out.println(p2.toString());
                    System.out.println(p3.toString());
                    System.out.println(p4.toString());
                    System.out.println(p5.toString());
                    System.out.println(p6.toString());
                    System.out.println(p7.toString());
                    System.out.println(p8.toString());
                    System.out.println(p9.toString());
                    System.out.println(p10.toString());
                    //m
                    System.out.println(m10.toString());
                    System.out.println(m5.toString());
                    System.out.println(m2.toString());
                    System.out.println(m1.toString());
                    System.out.println(mp5.toString() + "\n");
                    break;
                case "3"://Irte
                    System.out.println("Alejandose...");
                    opcionMenu = "3";
                    break;
                default:
                    System.out.println("MC--Deberia elegir algo\n");
                    break;
            }
        } while (opcionMenu != "3");
        read.close();
    }
}