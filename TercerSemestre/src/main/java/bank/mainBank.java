/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.util.Scanner;
import queue.LinkedQueue;

/**
 *
 * @author sergiob.t.
 */
public class mainBank {

    public static void main(String[] args) {
        String opcionMenu = null, opcionCaja = null, opcionCola = null;
        Scanner read = new Scanner(System.in);
        double retiro = 0;
        int personas = 0;
        
        //Cajas
        int[] cajas = {0, 0, 0, 0};
        //Colas
        LinkedQueue colaCon = new LinkedQueue(), colaSin = new LinkedQueue();

        for (int index = 0; index < 10; index++) {
            colaCon.enqueue(1);
        }
        for (int index = 0; index < 10; index++) {
            colaSin.enqueue(1);
        }
        //Monedas
        LinkedQueue m05c1 = new LinkedQueue(), m05c2 = new LinkedQueue(), m05c3 = new LinkedQueue(), m05c4 = new LinkedQueue();
        LinkedQueue m1c1 = new LinkedQueue(), m1c2 = new LinkedQueue(), m1c3 = new LinkedQueue(), m1c4 = new LinkedQueue();
        LinkedQueue m2c1 = new LinkedQueue(), m2c2 = new LinkedQueue(), m2c3 = new LinkedQueue(), m2c4 = new LinkedQueue();
        LinkedQueue m5c1 = new LinkedQueue(), m5c2 = new LinkedQueue(), m5c3 = new LinkedQueue(), m5c4 = new LinkedQueue();
        LinkedQueue m10c1 = new LinkedQueue(), m10c2 = new LinkedQueue(), m10c3 = new LinkedQueue(), m10c4 = new LinkedQueue();
        LinkedQueue m20c1 = new LinkedQueue(), m20c2 = new LinkedQueue(), m20c3 = new LinkedQueue(), m20c4 = new LinkedQueue();
        LinkedQueue m100c1 = new LinkedQueue(), m100c2 = new LinkedQueue(), m100c3 = new LinkedQueue(), m100c4 = new LinkedQueue();
        LinkedQueue m200c1 = new LinkedQueue(), m200c2 = new LinkedQueue(), m200c3 = new LinkedQueue(), m200c4 = new LinkedQueue();
        LinkedQueue m500c1 = new LinkedQueue(), m500c2 = new LinkedQueue(), m500c3 = new LinkedQueue(), m500c4 = new LinkedQueue();
        LinkedQueue m1000c1 = new LinkedQueue(), m1000c2 = new LinkedQueue(), m1000c3 = new LinkedQueue(), m1000c4 = new LinkedQueue();

        LinkedQueue[] caja1D = {m05c1, m1c1, m2c1, m5c1, m10c1, m20c1, m100c1, m200c1, m500c1, m1000c1};
        LinkedQueue[] caja2D = {m05c2, m1c2, m2c2, m5c2, m10c2, m20c2, m100c2, m200c2, m500c2, m1000c2};
        LinkedQueue[] caja3D = {m05c3, m1c3, m2c3, m5c3, m10c3, m20c3, m100c3, m200c3, m500c3, m1000c3};
        LinkedQueue[] caja4D = {m05c4, m1c4, m2c4, m5c4, m10c4, m20c4, m100c4, m200c4, m500c4, m1000c4};
        //Abastecimiento inicial
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < caja1D[index].size(); i++) {
                caja1D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < caja2D[index].size(); i++) {
                caja2D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < caja3D[index].size(); i++) {
                caja3D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < caja4D[index].size(); i++) {
                caja4D[index].enqueue(1);
            }
        }
        //Inicio del menu
        do {
            System.out.println("Elige una opcion\n"
                    + "1: Agregar personas a las colas\n"
                    + "2: Ingreso a caja\n"
                    + "3: Accion en caja\n"
                    + "4: Llenar o vaciar caja\n"
                    + "5: Imprimir estado\n"
                    + "6: Salir");
            opcionMenu = read.nextLine();
            switch (opcionMenu) {
                case "1"://Cola
                    System.out.println("Elige una opcion\n"
                            + "1: Agregar persona con cuenta\n"
                            + "2: Agregar persona sin cuenta");
                    opcionCola = read.nextLine();
                    if (opcionCola.equals("1")) {
                        System.out.println("Cantidad de personas:");
                        personas = read.nextInt();
                        for (int index = 0; index < personas; index++) {
                            colaCon.enqueue(1);
                        }
                    } else if (opcionCola.equals("2")) {
                        System.out.println("Cantidad de personas:");
                        personas = read.nextInt();
                        for (int index = 0; index < personas; index++) {
                            colaSin.enqueue(1);
                        }
                    } else {
                        System.out.println("Error: Elige una opcion valida");
                    }
                    break;
                case "2"://Ingreso a caja
                    if(!colaCon.isEmpty()&&cajas[0]==0){
                        cajas[0]=1;
                        colaCon.dequeue();
                    }
                    if(!colaCon.isEmpty()&&cajas[1]==0){
                        cajas[1]=1;
                        colaCon.dequeue();
                    }
                    if(!colaCon.isEmpty()&&cajas[2]==0){
                        cajas[2]=1;
                        colaCon.dequeue();
                    }
                    if(!colaCon.isEmpty()&&cajas[3]==0){
                        cajas[3]=1;
                        colaCon.dequeue();
                    }
                    break;
                case "3"://Accion en caja
                    System.out.println("Elige una opcion\n"
                            + "1: caja 1\n"
                            + "2: caja 2\n"
                            + "3: caja 3\n"
                            + "4: caja 4");
                    opcionCaja = read.nextLine();
                    if (opcionCaja.equals("1")) {
                        LinkedQueue[] cajaE = caja1D;
                    } else if (opcionCaja.equals("2")) {
                        LinkedQueue[] cajaE = caja2D;
                    }else if (opcionCaja.equals("3")) {
                        LinkedQueue[] cajaE = caja3D;
                    }else if (opcionCaja.equals("4")) {
                        LinkedQueue[] cajaE = caja4D;
                    }
                    System.out.println("Elige una opcion\n"
                            + "1: Depositar\n"
                            + "2: Retirar");
                    opcionCaja = read.nextLine();
                    if (opcionCaja.equals("1")) {
                        System.out.println("Cantidad a depositar:");
                        retiro = read.nextDouble();
                        
                    } else if (opcionCaja.equals("2")) {
                        System.out.println("Cantidad a retirar:");
                        retiro = read.nextDouble();
                        //retiro(cajaE, retiro);
                    } else {
                        System.out.println("Error: Elige una opcion valida");
                    }
                    break;
                case "4"://Ingreso o retiro de dinero
                    System.out.println("Elige una opcion\n"
                            + "1: Ingresar dinero\n"
                            + "2: Retirar dinero");
                    opcionCaja = read.nextLine();
                    if (opcionCaja.equals("1")) {

                    } else if (opcionCaja.equals("2")) {
                        System.out.println("Cantidad a retirar:");
                        retiro = read.nextDouble();

                    } else {
                        System.out.println("Error: Elige una opcion valida");
                    }
                    break;
                case "5"://Imprimir estado
                    //Colas
                    System.out.println("Cola de personas con cuentas");
                    System.out.println(colaCon.toString());
                    System.out.println("Cola de personas sin cuentas");
                    System.out.println(colaSin.toString());
                    //Cajas
                    System.out.println("Cajas:");
                    System.out.println(cajas[0]);
                    System.out.println(cajas[1]);
                    System.out.println(cajas[2]);
                    System.out.println(cajas[3]);
                    //Cajas Dinero
                    System.out.println("Dinero:");
                    System.out.println("Caja 1: "+dineroCaja(caja1D));
                    System.out.println("Caja 2: "+dineroCaja(caja2D));
                    System.out.println("Caja 3: "+dineroCaja(caja3D));                    
                    System.out.println("Caja 4: "+dineroCaja(caja4D));
                    
                    break;
                case "6":
                    System.out.println("Saliendo");
                    opcionMenu = "6";
                    break;
                default:
                    System.out.println("Error: Elige una opcion valida");
                    break;
            }
        } while (opcionMenu != "6");

    }

    //Agregar monedas
    public static void agregar(LinkedQueue[] caja, int moneda, int cantidad) {
        for (int index = 0; index < cantidad; index++) {
            caja[moneda].enqueue(1);
        }
    }

    //Dinero en caja
    public static double dineroCaja(LinkedQueue[] caja) {
        double total = 0;
        total = ((caja[0].size() * 0.5)
                + (caja[1].size() * 1)
                + (caja[2].size() * 2)
                + (caja[3].size() * 5)
                + (caja[4].size() * 10)
                + (caja[5].size() * 20)
                + (caja[6].size() * 100)
                + (caja[7].size() * 200)
                + (caja[8].size() * 500)
                + (caja[9].size() * 1000));
        return total;
    }

    //Retiro
    public static double retiro(LinkedQueue[] caja, double retiro) {
        double totalCaja = dineroCaja(caja), retiro1 = totalCaja - retiro;
        int m05 = 0, m1 = 0, m2 = 0, m5 = 0, m10 = 0, m20 = 0, m100 = 0, m200 = 0, m500 = 0, m1000 = 0;
        if ((retiro1) >= 0) {
            if (retiro1 == 0) {
                for (int index = 0; index < 10; index++) {
                    for (int i = 0; i < caja[index].size(); i++) {
                        caja[index].dequeue();
                    }
                }
            } else if (retiro1 != 0) {
                System.out.println("retirando:");
                do {
                    if (retiro1 % 1000 == 0 && !caja[9].isEmpty()) {
                        m1000++;
                        retiro1 -= 1000;
                    } else if (retiro1 % 500 == 0 && !caja[8].isEmpty()) {
                        m500++;
                        retiro1 -= 500;
                    } else if (retiro1 % 200 == 0 && !caja[7].isEmpty()) {
                        m200++;
                        retiro1 -= 200;
                    } else if (retiro1 % 100 == 0 && !caja[6].isEmpty()) {
                        m100++;
                        retiro1 -= 100;
                    } else if (retiro1 % 20 == 0 && !caja[5].isEmpty()) {
                        m20++;
                        retiro1 -= 20;
                    } else if (retiro1 % 10 == 0 && !caja[4].isEmpty()) {
                        m10++;
                        retiro1 -= 10;
                    } else if (retiro1 % 5 == 0 && !caja[3].isEmpty()) {
                        m5++;
                        retiro1 -= 5;
                    } else if (retiro1 % 2 == 0 && !caja[2].isEmpty()) {
                        m2++;
                        retiro1 -= 2;
                    } else if (retiro1 % 1 == 0 && !caja[1].isEmpty()) {
                        m1++;
                        retiro1 -= 1;
                    } else if (retiro1 % 0.5 == 0 && !caja[0].isEmpty()) {
                        m05++;
                        retiro1 -= 0.5;
                    } else {
                        System.out.println("Error: Dinero insuficiente para el retiro\n");
                        retiro1 = -1;
                    }
                } while (retiro1 != 0 && retiro1 != -1);
                if (retiro == 0) {
                    for (int index = 0; index < m05; index++) {
                        caja[0].dequeue();
                    }
                    for (int index = 0; index < m1; index++) {
                        caja[1].dequeue();
                    }
                    for (int index = 0; index < m2; index++) {
                        caja[2].dequeue();
                    }
                    for (int index = 0; index < m5; index++) {
                        caja[3].dequeue();
                    }
                    for (int index = 0; index < m10; index++) {
                        caja[4].dequeue();
                    }
                    for (int index = 0; index < m20; index++) {
                        caja[5].dequeue();
                    }
                    for (int index = 0; index < m100; index++) {
                        caja[6].dequeue();
                    }
                    for (int index = 0; index < m200; index++) {
                        caja[7].dequeue();
                    }
                    for (int index = 0; index < m500; index++) {
                        caja[8].dequeue();
                    }
                    for (int index = 0; index < m1000; index++) {
                        caja[9].dequeue();
                    }
                }
            }
        } else if ((totalCaja - retiro) < 0) {
            System.out.println("Error: Dinero insuficiente para el retiro\n");
            retiro1 = -1;
        }
        return retiro1;
    }
}
