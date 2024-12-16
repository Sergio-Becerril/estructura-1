/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSolitario;

import java.util.*;
import stack.ArrayStack;

/**
 *
 * @author sergiob.t.
 */
public class Principal {

    public static void main(String[] args) {
        Cartas deck = new Cartas();
        Validaciones val = new Validaciones();
        Scanner read = new Scanner(System.in);
        int i1 = 0, i2 = 1, i3 = 2, i4 = 3, i5 = 4, i6 = 5, i7 = 6;
        String opcionMenu = "0", opcionJuego = "0", eleccion2 = "0", multiple = "0";

        deck.barajar();
        deck.distribuir();

        do {

            System.out.println("Ingresa el número de la opción que deseas realizar\n"
                    + "\n0- Salir"
                    + "\n1- Jugar"
                    + "\n2- Como jugar");
            opcionMenu = read.nextLine();

            switch (opcionMenu) {
                case "1":
                    do {
                        if ((!deck.base1.isEmpty() && !deck.base2.isEmpty()
                                && !deck.base3.isEmpty() && !deck.base4.isEmpty())
                                && (deck.base1.peek() == 12 && deck.base2.peek() == 25
                                && deck.base3.peek() == 38 && deck.base4.peek() == 51)) {
                            System.out.println("Has ganado!");
                            opcionJuego = "0";
                        } else {
                            System.out.println("\nMazo:                                         Bases:");
                            if (deck.mazo.size() == 0) {
                                System.out.print("\n[ ]");
                            } else {
                                System.out.print("\n[X]");
                            }
                            if (deck.reserva.size() == 0) {
                                System.out.print("  [ ]");
                            } else {
                                System.out.print("  ");
                                deck.valoresACartasS(deck.reserva, (deck.reserva.size() - 1));
                            }
                            if (deck.base1.size() == 0) {
                                System.out.print("                                      [ ]");
                            } else {
                                System.out.print("                                      ");
                                deck.valoresACartasS(deck.base1, (deck.base1.size() - 1));
                            }
                            if (deck.base2.size() == 0) {
                                System.out.print("  [ ]");
                            } else {
                                System.out.print("  ");
                                deck.valoresACartasS(deck.base2, (deck.base2.size() - 1));
                            }
                            if (deck.base3.size() == 0) {
                                System.out.print("  [ ]");
                            } else {
                                System.out.print("  ");
                                deck.valoresACartasS(deck.base3, (deck.base3.size() - 1));
                            }
                            if (deck.base4.size() == 0) {
                                System.out.print("  [ ]");
                            } else {
                                System.out.print("  ");
                                deck.valoresACartasS(deck.base4, (deck.base4.size() - 1));
                            }
                            System.out.print("\n\n\n");
                            System.out.println("Pilas:");
                            System.out.print("1: ");
                            mostrar(deck.columna1, i1);
                            System.out.print("\n");
                            System.out.print("2: ");
                            mostrar(deck.columna2, i2);
                            System.out.print("\n");
                            System.out.print("3: ");
                            mostrar(deck.columna3, i3);
                            System.out.print("\n");
                            System.out.print("4: ");
                            mostrar(deck.columna4, i4);
                            System.out.print("\n");
                            System.out.print("5: ");
                            mostrar(deck.columna5, i5);
                            System.out.print("\n");
                            System.out.print("6: ");
                            mostrar(deck.columna6, i6);
                            System.out.print("\n");
                            System.out.print("7: ");
                            mostrar(deck.columna7, i7);
                            System.out.println("\nMover:                                                                                [Presiona 0 para salir]");
                            System.out.println("Eleccion 1:");
                            opcionJuego = read.nextLine();
                        }
                        switch (opcionJuego) {
                            //
                            case "1":
                                if (!deck.columna1.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        deck.pilasABase(opcionJuego, eleccion2);
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna1, i1) && !eleccion2.equals("9")) {
                                                deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple));
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "2":
                                if (!deck.columna2.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i2 != 0) {
                                                i2--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna2, i2) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i2 != 0) {
                                                        i2--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i2 != 0&& deck.columna2.size() <= i2) {
                                                    i2--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "3":
                                if (!deck.columna3.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i3 != 0 && deck.columna3.size() <= i3) {
                                                i3--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna3, i3) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i3 != 0) {
                                                        i3--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i3 != 0&& deck.columna3.size() <= i3) {
                                                    i3--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "4":
                                if (!deck.columna4.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i4 != 0 && deck.columna4.size() <= i4) {
                                                i4--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna4, i4) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i4 != 0) {
                                                        i4--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i4 != 0&& deck.columna4.size() <= i4) {
                                                    i4--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "5":
                                if (!deck.columna5.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i5 != 0 && deck.columna5.size() <= i5) {
                                                i5--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna5, i5) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i5 != 0) {
                                                        i5--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i5 != 0&& deck.columna5.size() <= i5) {
                                                    i5--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "6":
                                if (!deck.columna6.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i6 != 0 && deck.columna6.size() <= i6) {
                                                i6--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna6, i6) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i6 != 0) {
                                                        i6--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i6 != 0&& deck.columna6.size() <= i6) {
                                                    i6--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "7":
                                if (!deck.columna7.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        if (deck.pilasABase(opcionJuego, eleccion2)) {
                                            if (i7 != 0 && deck.columna7.size() <= i7) {
                                                i7--;
                                            }
                                        }
                                    } else if (val.opcionValida(eleccion2)) {
                                        if (eleccion2.equals("9")) {
                                            System.out.println("Eleccion 2:");
                                            eleccion2 = read.nextLine();
                                            System.out.println("Posicion:");
                                            multiple = read.nextLine();
                                            if (multipleV(multiple, deck.columna7, i7) && !eleccion2.equals("9")) {
                                                if (deck.movimientoPilas(opcionJuego, eleccion2, Integer.parseInt(multiple))) {
                                                    if (i7 != 0) {
                                                        i7--;
                                                    }
                                                }
                                            } else {
                                                System.out.println("nop");
                                            }

                                        } else {
                                            if (deck.movimientoPilas(opcionJuego, eleccion2, 1)) {
                                                if (i7 != 0&& deck.columna7.size() <= i7) {
                                                    i7--;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            //
                            case "8":
                                if (!deck.reserva.isEmpty()) {
                                    System.out.println("Eleccion 2:");
                                    eleccion2 = read.nextLine();
                                    if (eleccion2.equals("q") || eleccion2.equals("w") || eleccion2.equals("e") || eleccion2.equals("r")) {
                                        deck.pilasABase(opcionJuego, eleccion2);
                                    } else if (!eleccion2.equals("9") && val.opcionValida(eleccion2)) {
                                        deck.movimientoPilas(opcionJuego, eleccion2, 1);
                                    } else {
                                        System.out.println("nop");
                                    }
                                } else {
                                    System.out.println("La pila esta vacia");
                                }
                                break;
                            case "d":
                                deck.sacarMazo();
                                break;
                            case "0":
                                opcionJuego = "0";
                                opcionMenu = "0";
                                break;
                            default:
                                System.out.println("Error: Ingresa una opcion valida");
                                break;
                        }

                    } while (opcionJuego != "0");
                    break;
                case "2":
                    System.out.println("Como jugar:\n"
                            + "\nBases:\n"
                            + "\n"
                            + "Crea 4 bases de pilas en orden ascendente del as al rey\n"
                            + "\n"
                            + "Para iniciar una pila de base, coloca un As en la base.\n"
                            + "\n"
                            + "Con el As en la base, ahora se puede mover allí un “2” del  mismo “palo”\n"
                            + "\n"
                            + "La pila de base continua en orden así y termina con un rey. \n"
                            + "\n"
                            + "Pilas:\n"
                            + "\n"
                            + "Las cartas se descubren al quitar la carta descubierta encima.\n"
                            + "\n"
                            + "Las cartas deben estar en orden ascendente (derecha a izquierda) y alternar los colores del palo (Los corazones y diamantes son rojos, y las picas y treboles negros) para cambiar de una pila a otra. (Ejemplo: [X] ♦5  ♣4 ).\n"
                            + "\n"
                            + "Se pueden mover varias cartas a la vez, siempre y cuando la carta seleccionada sea menor y de diferente color que la ultima de la pila a la que se quiere cambiar.\n"
                            + "\n"
                            + "Los reyes se pueden mover a una columna vacía para descubrir las cartas boca abajo que tienen debajo.\n"
                            + "\n"
                            + "Reserva:\n"
                            + "\n"
                            + "Si no hay mas cartas que se puedan usar en la pilas, usa la pila del mazo. Presiona “d” para robar una carta nueva del mazo y agregarla a la pila del mazo.\n"
                            + "\n"
                            + "Cuando la pila del mazo este vacía, vuelve a seleccionarla para volver a recorrerla.");
                    System.out.println("\nControles:\n"
                            + "\nEscoge un numero del '1' al '7' para seleccionar la pila respectiva\n"
                            + "\nLas bases se eligen con 'q' 'w' 'e' 'r' \n"
                            + "\nel numero '8' es para elegir la pila de reserva\n"
                            + "\nla 'd' se usa para tomar una carta del mazo y agregarla a la pila de reserva\n"
                            + "\nla primera eleccion que hagas va a ser la pila de la cual se va a tomar ultima la carta, y la segunda eleccion es la pila a la que sera agregada dicha carta\n"
                            + "\npara agregar mas de una carta a una pila de otra (excepto la pila de reserva):\n"
                            + "\ntu primera eleccion sera de la pila que se tomaran las cartas, cuando debas ingresar la siguiente opcion, ingresa el numero '9'\n"
                            + "\nesto indicara que multiples cartas seran seleccionadas, despues ingresa la pila a la que seran agregadas,\n"
                            + "\ny al final ingresa la posicion de la que seran tomadas las cartas\n"
                            + "\n(la carta que este en la posicion ingresada sera ocupada para comparar con la ultima carta de la pila a la que quieren ser agregadas las cartas)\n");
                    System.out.println("Ejmplos:"
                            + "Mazo:                                         Bases:\n"
                            + "\n"
                            + "[X]  [ ]                                      [ ]  [ ]  [ ]  [ ]\n"
                            + "\n"
                            + "\n"
                            + "Pilas:\n"
                            + "1: ♠Q \n"
                            + "2: [X]♥2 \n"
                            + "3: [X][X]♥5 \n"
                            + "4: [X][X][X]♥A \n"
                            + "5: [X][X][X][X]♠7 \n"
                            + "6: [X][X][X][X][X]♥6 \n"
                            + "7: [X][X][X][X][X][X]♣4 \n"
                            + "Mover:                                                                                [Presiona 0 para salir]\n"
                            + "Eleccion 1:\n"
                            + "4\n"
                            + "Eleccion 2:\n"
                            + "q\n"
                            + "\n"
                            + "Mazo:                                         Bases:\n"
                            + "\n"
                            + "[X]  [ ]                                      ♥A   [ ]  [ ]  [ ]\n"
                            + "\n"
                            + "\n"
                            + "Pilas:\n"
                            + "1: ♠Q \n"
                            + "2: [X]♥2 \n"
                            + "3: [X][X]♥5 \n"
                            + "4: [X][X]♣7 \n"
                            + "5: [X][X][X][X]♠7 \n"
                            + "6: [X][X][X][X][X]♥6 \n"
                            + "7: [X][X][X][X][X][X]♣4 \n"
                            + "Mover:                                                                                [Presiona 0 para salir]\n"
                            + "Eleccion 1:\n"
                            + "Pilas:\n"
                            + "1: ♠Q \n"
                            + "2: [X]♥2 \n"
                            + "3: [X][X]♥5 \n"
                            + "4: [X][X]♣7 \n"
                            + "5: [X][X][X][X]♠7 \n"
                            + "6: [X][X][X][X][X]♥6 \n"
                            + "7: [X][X][X][X][X][X]♣4 \n"
                            + "Mover:                                                                                [Presiona 0 para salir]\n"
                            + "Eleccion 1:\n"
                            + "7\n"
                            + "Eleccion 2:\n"
                            + "3\n"
                            + "\n"
                            + "Mazo:                                         Bases:\n"
                            + "\n"
                            + "[X]  [ ]                                      ♥A   [ ]  [ ]  [ ]\n"
                            + "\n"
                            + "\n"
                            + "Pilas:\n"
                            + "1: ♠Q \n"
                            + "2: [X]♥2 \n"
                            + "3: [X][X]♥5 ♣4 \n"
                            + "4: [X][X]♣7 \n"
                            + "5: [X][X][X][X]♠7 \n"
                            + "6: [X][X][X][X][X]♥6 \n"
                            + "7: [X][X][X][X][X]♦9 \n"
                            + "Mazo:                                         Bases:\n"
                            + "\n"
                            + "[X]  ♥K                                       ♠A   [ ]  [ ]  [ ]\n"
                            + "\n"
                            + "\n"
                            + "Pilas:\n"
                            + "1: ♦5 ♠4 \n"
                            + "2: [X]♦8 \n"
                            + "3: [X][X]♣8 ♥7 ♠6 \n"
                            + "4: [X][X][X]♣10 \n"
                            + "5: [X][X][X]♣5 ♥4 \n"
                            + "6: [X][X][X][X]♠J \n"
                            + "7: [X][X][X][X][X]♣2 \n"
                            + "Mover:                                                                                [Presiona 0 para salir]\n"
                            + "Eleccion 1:\n"
                            + "1\n"
                            + "Eleccion 2:\n"
                            + "9\n"
                            + "Eleccion 2:\n"
                            + "3\n"
                            + "Posicion:\n"
                            + "2\n"
                            + "\n"
                            + "Mazo:                                         Bases:\n"
                            + "\n"
                            + "[X]  ♥K                                       ♠A   [ ]  [ ]  [ ]\n"
                            + "\n"
                            + "\n"
                            + "Pilas:\n"
                            + "1: [ ]\n"
                            + "2: [X]♦8 \n"
                            + "3: [X][X]♣8 ♥7 ♠6 ♦5 ♠4 \n"
                            + "4: [X][X][X]♣10 \n"
                            + "5: [X][X][X]♣5 ♥4 \n"
                            + "6: [X][X][X][X]♠J \n"
                            + "7: [X][X][X][X][X]♣2 \n"
                            + "Mover:                                                                                [Presiona 0 para salir]\n"
                            + "Eleccion 1:\n"
                            + "");
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    opcionMenu = "0";
                    break;
                default:
                    System.out.println("Error: Ingresa una opcion valida");
                    break;
            }

        } while (opcionMenu != "0");
    }

    public static void bocaAbajo(int index) {
        int contador = 0;
        while (contador < index) {
            System.out.print("[X]");
            contador++;
        }
    }

    public static void mostrar(Stack<Integer> columna, int counter) {
        Cartas deck = new Cartas();
        if (!columna.isEmpty()) {
            bocaAbajo(counter);
            while (counter < columna.size()) {
                deck.valoresACartasS(columna, counter);
                counter++;
            }
        } else {
            System.out.print("[ ]");
        }
    }

    public static boolean multipleV(String opcion, Stack<Integer> columna, int iN) {
        Validaciones val = new Validaciones();
        boolean result = false;
        int valor = 0;
        if (val.numeroVali(opcion)) {
            valor = Integer.parseInt(opcion);
            if (valor > 0 && valor <= columna.size() && (columna.size() - valor) >= iN) {
                result = true;
            } else {
                val.movimientoNoValido();
            }
        } else {
            System.out.println("Opcion no valida");
        }
        return result;
    }

}
