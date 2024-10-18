/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

import java.util.Scanner;
import queue.*;

/*
 * @author sergiob.t.
 */
public class mainBank {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String opcionMenu = null, opcionCaja = null, opcionCola = null,
                mensaje = null;
        double retiro = 0;
        int personas = 0, ingreso = 0, opcionIngresoMoneda = 0, cuentaTipo = 0;
        String menuDenominacion = "Denominacion a ingresar:\n"
                + "9: 1000\n"
                + "8: 500\n"
                + "7: 200\n"
                + "6: 100\n"
                + "5: 20\n"
                + "4: 10\n"
                + "3: 5\n"
                + "2: 2\n"
                + "1: 1\n"
                + "0: 0.5\n"
                + "-1: Dejar de ingresar dinero";
        //Cajas
        int[] cajas = {0, 0, 0, 0};
        //Colas
        NumericPriorityQueue colaCon = new NumericPriorityQueue();
        LinkedQueue colaSin = new LinkedQueue();
        //v1
        //LinkedQueue colaCon = new LinkedQueue();

        for (int index = 0; index < 3; index++) {
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
        LinkedQueue[] cajaE = caja1D;

        //Abastecimiento inicial
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < 10; i++) {
                caja1D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < 10; i++) {
                caja2D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < 10; i++) {
                caja3D[index].enqueue(1);
            }
        }
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < 10; i++) {
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
                    //v1
                    /*
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
                    else if (opcionCola.equals("2")) {
                        System.out.println("Cantidad de personas:");
                        personas = read.nextInt();
                        for (int index = 0; index < personas; index++) {
                            colaSin.enqueue(1);
                        }
                    } else {
                        System.out.println("Error: Elige una opcion valida");
                    }
                    */
                    
                    //v2
                    System.out.println("Elige una opcion\n"
                            + "1: Agregar persona con cuenta\n"
                            + "2: Agregar persona sin cuenta");
                    opcionCola = read.nextLine();
                    if (opcionCola.equals("1")) {
                        System.out.println("Tipo de cuenta: "
                                + "\n1: 042"
                                + "\n2: 022"
                                + "\n3: 011");
                        cuentaTipo = read.nextInt();
                        if (cuentaTipo > 0 && cuentaTipo < 4) {
                            System.out.println("Cantidad de personas:");
                            personas = read.nextInt();
                            for (int index = 0; index < personas; index++) {
                                colaCon.enqueue(cuentaTipo, cuentaTipo);
                            }
                        } else {
                            System.out.println("Error: Elige una opcion valida");
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
                    do {
                        if (!colaCon.isEmpty()) {
                            if (cajas[0] < 1) {
                                cajas[0] = 1;
                                colaCon.dequeue();
                            } else if (cajas[1] < 1) {
                                cajas[1] = 1;
                                colaCon.dequeue();
                            } else if (cajas[2] < 1) {
                                cajas[2] = 1;
                                colaCon.dequeue();
                            } else if (cajas[3] < 1) {
                                cajas[3] = 1;
                                colaCon.dequeue();
                            }
                        }
                        if (!colaSin.isEmpty()) {
                            if (cajas[0] < 1) {
                                cajas[0] = 1;
                                colaSin.dequeue();
                            } else if (cajas[1] < 1) {
                                cajas[1] = 1;
                                colaSin.dequeue();
                            } else if (cajas[2] < 1) {
                                cajas[2] = 1;
                                colaSin.dequeue();
                            } else if (cajas[3] < 1) {
                                cajas[3] = 1;
                                colaSin.dequeue();
                            }
                        }
                        if (!colaCon.isEmpty()) {
                            if (cajas[0] < 1) {
                                cajas[0] = 1;
                                colaCon.dequeue();
                            } else if (cajas[1] < 1) {
                                cajas[1] = 1;
                                colaCon.dequeue();
                            } else if (cajas[2] < 1) {
                                cajas[2] = 1;
                                colaCon.dequeue();
                            } else if (cajas[3] < 1) {
                                cajas[3] = 1;
                                colaCon.dequeue();
                            }
                        }
                        if (!colaSin.isEmpty()) {
                            if (cajas[0] < 1) {
                                cajas[0] = 1;
                                colaSin.dequeue();
                            } else if (cajas[1] < 1) {
                                cajas[1] = 1;
                                colaSin.dequeue();
                            } else if (cajas[2] < 1) {
                                cajas[2] = 1;
                                colaSin.dequeue();
                            } else if (cajas[3] < 1) {
                                cajas[3] = 1;
                                colaSin.dequeue();
                            }
                        }
                        if (colaCon.isEmpty() && colaSin.isEmpty()) {
                            if (cajas[0] < 1) {
                                cajas[0] = -1;
                            }
                            if (cajas[1] < 1) {
                                cajas[1] = -1;
                            }
                            if (cajas[2] < 1) {
                                cajas[2] = -1;
                            }
                            if (cajas[3] < 1) {
                                cajas[3] = -1;
                            }
                        }
                    } while (cajas[0] == 0 || cajas[1] == 0 || cajas[2] == 0 || cajas[3] == 0);
                    System.out.println("Cajas:");
                    mensaje = (cajas[0] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 1: " + mensaje);
                    mensaje = (cajas[1] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 2: " + mensaje);
                    mensaje = (cajas[2] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 3: " + mensaje);
                    mensaje = (cajas[3] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 4: " + mensaje);
                    break;
                case "3"://Accion en caja
                    System.out.println("Elige una opcion\n"
                            + "1: caja 1\n"
                            + "2: caja 2\n"
                            + "3: caja 3\n"
                            + "4: caja 4\n"
                            + "Otro: Ninguna");
                    opcionCaja = read.nextLine();
                    if (opcionCaja.equals("1")) {
                        if (cajas[0] == 1) {
                            cajaE = caja1D;
                            System.out.println("Elige una opcion\n"
                                    + "1: Depositar\n"
                                    + "2: Retirar");
                            opcionCaja = read.nextLine();
                            if (opcionCaja.equals("1")) {
                                System.out.println(menuDenominacion);
                                opcionIngresoMoneda = read.nextInt();
                                if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                    System.out.println("Cantidad de monedas:");
                                    ingreso = read.nextInt();
                                    agregar(cajaE, opcionIngresoMoneda, ingreso);
                                    cajas[0] = 0;
                                } else {
                                    System.out.println("Regresando");
                                }
                            } else if (opcionCaja.equals("2")) {
                                System.out.println("Cantidad a retirar:");
                                retiro = read.nextDouble();
                                retiro(cajaE, retiro);
                                cajas[0] = 0;
                            } else {
                                System.out.println("Error: Opcion no valida");
                            }
                        } else if (cajas[0] < 1) {
                            System.out.println("Error: La caja esta vacia");
                        }
                    } else if (opcionCaja.equals("2")) {
                        if (cajas[1] == 1) {
                            cajaE = caja2D;
                            System.out.println("Elige una opcion\n"
                                    + "1: Depositar\n"
                                    + "2: Retirar");
                            opcionCaja = read.nextLine();
                            if (opcionCaja.equals("1")) {
                                System.out.println(menuDenominacion);
                                opcionIngresoMoneda = read.nextInt();
                                if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                    System.out.println("Cantidad de monedas:");
                                    ingreso = read.nextInt();
                                    agregar(cajaE, opcionIngresoMoneda, ingreso);
                                    cajas[1] = 0;
                                } else {
                                    System.out.println("Regresando");
                                }
                            } else if (opcionCaja.equals("2")) {
                                System.out.println("Cantidad a retirar:");
                                retiro = read.nextDouble();
                                retiro(cajaE, retiro);
                                cajas[1] = 0;
                            } else {
                                System.out.println("Error: Opcion no valida");
                            }
                        } else if (cajas[1] < 1) {
                            System.out.println("Error: La caja esta vacia");
                        }
                    } else if (opcionCaja.equals("3")) {
                        if (cajas[2] == 1) {
                            cajaE = caja3D;
                            System.out.println("Elige una opcion\n"
                                    + "1: Depositar\n"
                                    + "2: Retirar");
                            opcionCaja = read.nextLine();
                            if (opcionCaja.equals("1")) {
                                System.out.println(menuDenominacion);
                                opcionIngresoMoneda = read.nextInt();
                                if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                    System.out.println("Cantidad de monedas:");
                                    ingreso = read.nextInt();
                                    agregar(cajaE, opcionIngresoMoneda, ingreso);
                                    cajas[2] = 0;
                                } else {
                                    System.out.println("Regresando");
                                }
                            } else if (opcionCaja.equals("2")) {
                                System.out.println("Cantidad a retirar:");
                                retiro = read.nextDouble();
                                retiro(cajaE, retiro);
                                cajas[2] = 0;
                            } else {
                                System.out.println("Error: Opcion no valida");
                            }
                        } else if (cajas[2] < 1) {
                            System.out.println("Error: La caja esta vacia");
                        }
                    } else if (opcionCaja.equals("4")) {
                        if (cajas[3] == 1) {
                            cajaE = caja4D;
                            System.out.println("Elige una opcion\n"
                                    + "1: Depositar\n"
                                    + "2: Retirar");
                            opcionCaja = read.nextLine();
                            if (opcionCaja.equals("1")) {
                                System.out.println(menuDenominacion);
                                opcionIngresoMoneda = read.nextInt();
                                if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                    System.out.println("Cantidad de monedas:");
                                    ingreso = read.nextInt();
                                    agregar(cajaE, opcionIngresoMoneda, ingreso);
                                    cajas[3] = 0;
                                } else {
                                    System.out.println("Regresando");
                                }
                            } else if (opcionCaja.equals("2")) {
                                System.out.println("Cantidad a retirar:");
                                retiro = read.nextDouble();
                                retiro(cajaE, retiro);
                                cajas[3] = 0;
                            } else {
                                System.out.println("Error: Opcion no valida");
                            }
                        } else if (cajas[3] < 1) {
                            System.out.println("Error: La caja esta vacia");
                        }
                    } else {
                        System.out.println("Regresando");
                    }
                    break;
                case "4"://Ingreso o retiro de dinero
                    System.out.println("Elige una opcion\n"
                            + "1: caja 1\n"
                            + "2: caja 2\n"
                            + "3: caja 3\n"
                            + "4: caja 4\n"
                            + "Otro: Ninguna");
                    opcionCaja = read.nextLine();
                    if (opcionCaja.equals("1")) {
                        cajaE = caja1D;
                        System.out.println("Elige una opcion\n"
                                + "1: Ingresar\n"
                                + "2: Vaciar");
                        opcionCaja = read.nextLine();
                        if (opcionCaja.equals("1")) {
                            System.out.println(menuDenominacion);
                            opcionIngresoMoneda = read.nextInt();
                            if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                System.out.println("Cantidad de monedas:");
                                ingreso = read.nextInt();
                                agregar(cajaE, opcionIngresoMoneda, ingreso);
                            } else {
                                System.out.println("Regresando");
                            }
                        } else if (opcionCaja.equals("2")) {
                            System.out.println("Cantidad a retirar:");
                            retiro = read.nextDouble();
                            retiro(cajaE, retiro);
                        } else {
                            System.out.println("Error: Opcion no valida");
                        }
                    } else if (opcionCaja.equals("2")) {
                        cajaE = caja2D;
                        System.out.println("Elige una opcion\n"
                                + "1: Depositar\n"
                                + "2: Retirar");
                        opcionCaja = read.nextLine();
                        if (opcionCaja.equals("1")) {
                            System.out.println(menuDenominacion);
                            opcionIngresoMoneda = read.nextInt();
                            if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                System.out.println("Cantidad de monedas:");
                                ingreso = read.nextInt();
                                agregar(cajaE, opcionIngresoMoneda, ingreso);
                            } else {
                                System.out.println("Regresando");
                            }
                        } else if (opcionCaja.equals("2")) {
                            System.out.println("Cantidad a retirar:");
                            retiro = read.nextDouble();
                            retiro(cajaE, retiro);
                        } else {
                            System.out.println("Error: Opcion no valida");
                        }
                    } else if (opcionCaja.equals("3")) {
                        cajaE = caja3D;
                        System.out.println("Elige una opcion\n"
                                + "1: Depositar\n"
                                + "2: Retirar");
                        opcionCaja = read.nextLine();
                        if (opcionCaja.equals("1")) {
                            System.out.println(menuDenominacion);
                            opcionIngresoMoneda = read.nextInt();
                            if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                System.out.println("Cantidad de monedas:");
                                ingreso = read.nextInt();
                                agregar(cajaE, opcionIngresoMoneda, ingreso);
                            } else {
                                System.out.println("Regresando");
                            }
                        } else if (opcionCaja.equals("2")) {
                            System.out.println("Cantidad a retirar:");
                            retiro = read.nextDouble();
                            retiro(cajaE, retiro);
                        } else {
                            System.out.println("Error: Opcion no valida");
                        }
                    } else if (opcionCaja.equals("4")) {
                        cajaE = caja4D;
                        System.out.println("Elige una opcion\n"
                                + "1: Depositar\n"
                                + "2: Retirar");
                        opcionCaja = read.nextLine();
                        if (opcionCaja.equals("1")) {
                            System.out.println(menuDenominacion);
                            opcionIngresoMoneda = read.nextInt();
                            if (opcionIngresoMoneda > -1 && opcionIngresoMoneda < 10) {
                                System.out.println("Cantidad de monedas:");
                                ingreso = read.nextInt();
                                agregar(cajaE, opcionIngresoMoneda, ingreso);
                            } else {
                                System.out.println("Regresando");
                            }
                        } else if (opcionCaja.equals("2")) {
                            System.out.println("Cantidad a retirar:");
                            retiro = read.nextDouble();
                            retiro(cajaE, retiro);
                        } else {
                            System.out.println("Error: Opcion no valida");
                        }
                    } else {
                        System.out.println("Regresando");
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
                    mensaje = (cajas[0] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 1: " + mensaje);
                    mensaje = (cajas[1] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 2: " + mensaje);
                    mensaje = (cajas[2] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 3: " + mensaje);
                    mensaje = (cajas[3] == 1) ? "Ocupado" : "Vacio";
                    System.out.println("Caja 4: " + mensaje);
                    //Cajas Dinero
                    System.out.println("Dinero:");
                    System.out.println("Caja 1: " + dineroCaja(caja1D));
                    System.out.println("Caja 2: " + dineroCaja(caja2D));
                    System.out.println("Caja 3: " + dineroCaja(caja3D));
                    System.out.println("Caja 4: " + dineroCaja(caja4D));

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
        total = (((caja[0].size() * 0.5)
                + (caja[1].size() * 1)
                + (caja[2].size() * 2)
                + (caja[3].size() * 5)
                + (caja[4].size() * 10)
                + (caja[5].size() * 20)
                + (caja[6].size() * 100)
                + (caja[7].size() * 200)
                + (caja[8].size() * 500)
                + (caja[9].size() * 1000)));
        return total;
    }

    //Retiro
    public static double retiro(LinkedQueue[] caja, double retiro) {
        double totalCaja = dineroCaja(caja);
        double retiro1 = totalCaja - retiro;
        int m05 = 0, m1 = 0, m2 = 0, m5 = 0, m10 = 0, m20 = 0, m100 = 0, m200 = 0, m500 = 0, m1000 = 0;
        if ((retiro1) >= 0) {
            if (retiro1 == 0) {
                for (int index = 0; index < 10; index++) {
                    for (int i = 0; i < caja[index].size(); i++) {
                        caja[index].dequeue();
                    }
                }
            } else if (retiro1 != 0) {
                System.out.println("retirando: " + retiro);
                do {
                    if (retiro % 1000 == 0 && !caja[9].isEmpty()) {
                        m1000++;
                        retiro -= 1000;
                    } else if (retiro % 500 == 0 && !caja[8].isEmpty()) {
                        m500++;
                        retiro -= 500;
                    } else if (retiro % 200 == 0 && !caja[7].isEmpty()) {
                        m200++;
                        retiro -= 200;
                    } else if (retiro % 100 == 0 && !caja[6].isEmpty()) {
                        m100++;
                        retiro -= 100;
                    } else if (retiro % 20 == 0 && !caja[5].isEmpty()) {
                        m20++;
                        retiro -= 20;
                    } else if (retiro % 10 == 0 && !caja[4].isEmpty()) {
                        m10++;
                        retiro -= 10;
                    } else if (retiro % 5 == 0 && !caja[3].isEmpty()) {
                        m5++;
                        retiro -= 5;
                    } else if (retiro % 2 == 0 && !caja[2].isEmpty()) {
                        m2++;
                        retiro -= 2;
                    } else if (retiro % 1 == 0 && !caja[1].isEmpty()) {
                        m1++;
                        retiro -= 1;
                    } else if (retiro % 0.5 == 0 && !caja[0].isEmpty()) {
                        m05++;
                        retiro -= 0.5;
                    } else {
                        System.out.println("Error: Dinero insuficiente para el retiro\n");
                        retiro1 = -1;
                    }
                } while (retiro != 0 && retiro != -1);
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
        } else if ((retiro1) < 0) {
            System.out.println("Error: Dinero insuficiente para el retiro\n");
            retiro1 = -1;
        }
        return retiro1;
    }
}