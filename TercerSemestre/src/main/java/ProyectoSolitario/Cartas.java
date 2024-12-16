/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSolitario;

import java.util.*;
//import stack.ArrayStack;

/**
 *
 * @author sergiob.t.
 *
 */
public class Cartas {

    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_RED = "\033[31m";

    //String[] palos = {"♥", "♦", "♣", "♠"};
    //int[] valores = new int[52];
    public Stack<Integer> mazo = new Stack<>();

    public Stack<Integer> reserva = new Stack<>();

    //bases
    public Stack<Integer> base1 = new Stack<>();
    public Stack<Integer> base2 = new Stack<>();
    public Stack<Integer> base3 = new Stack<>();
    public Stack<Integer> base4 = new Stack<>();

    //pilas
    public Stack<Integer> columna1 = new Stack<>();
    public Stack<Integer> columna2 = new Stack<>();
    public Stack<Integer> columna3 = new Stack<>();
    public Stack<Integer> columna4 = new Stack<>();
    public Stack<Integer> columna5 = new Stack<>();
    public Stack<Integer> columna6 = new Stack<>();
    public Stack<Integer> columna7 = new Stack<>();

    public void barajar() {
        System.out.println();
        int contador = 0;
        while (contador < 52) {

            mazo.add(contador);
            contador++;
        }
        Collections.shuffle(mazo);
    }

    public void distribuir() {

        int contador = 0;
        columna1.push(mazo.removeLast());
        while (contador < 2) {
            columna2.push(mazo.removeLast());
            contador++;
        }
        while (contador < 5) {
            columna3.push(mazo.removeLast());
            contador++;
        }
        while (contador < 9) {
            columna4.push(mazo.removeLast());
            contador++;
        }
        while (contador < 14) {
            columna5.push(mazo.removeLast());
            contador++;
        }
        while (contador < 20) {
            columna6.push(mazo.removeLast());
            contador++;
        }
        while (contador < 27) {
            columna7.push(mazo.removeLast());
            contador++;
        }
    }

    public void valoresACartasS(Stack<Integer> columna, int index) {
        String carta = null;
        if (!columna.isEmpty()) {
            int valor = columna.get(index);
            //corazones
            if (valor < 13) {
                if (valor == 0) {
                    carta = ANSI_RED + "♥A" + ANSI_RESET;
                } else if (valor == 10) {
                    carta = ANSI_RED + "♥J" + ANSI_RESET;
                } else if (valor == 11) {
                    carta = ANSI_RED + "♥Q" + ANSI_RESET;
                } else if (valor == 12) {
                    carta = ANSI_RED + "♥K" + ANSI_RESET;
                } else {
                    carta = ANSI_RED + "♥" + (valor + 1) + ANSI_RESET;
                }
            }

            //diamantes
            if (valor > 12 && valor < 26) {
                if (valor == 13) {
                    carta = ANSI_RED + "♦A" + ANSI_RESET;
                } else if (valor == 23) {
                    carta = ANSI_RED + "♦J" + ANSI_RESET;
                } else if (valor == 24) {
                    carta = ANSI_RED + "♦Q" + ANSI_RESET;
                } else if (valor == 25) {
                    carta = ANSI_RED + "♦K" + ANSI_RESET;
                } else {
                    carta = ANSI_RED + "♦" + (valor - 12) + ANSI_RESET;
                }
            }

            //picas
            if (valor > 25 && valor < 39) {
                if (valor == 26) {
                    carta = "♠A";
                } else if (valor == 36) {
                    carta = "♠J";
                } else if (valor == 37) {
                    carta = "♠Q";
                } else if (valor == 38) {
                    carta = "♠K";
                } else {
                    carta = "♠" + (valor - 25);
                }
            }

            //treboles
            if (valor > 38 && valor < 52) {
                if (valor == 39) {
                    carta = "♣A";
                } else if (valor == 49) {
                    carta = "♣J";
                } else if (valor == 50) {
                    carta = "♣Q";
                } else if (valor == 51) {
                    carta = "♣K";
                } else {
                    carta = "♣" + (valor - 38);
                }
            }

            System.out.print(carta);
            System.out.print(" ");
        }
    }

    public Stack<Integer> selectPila(String opcion) {
        Stack<Integer> result = null;
        switch (opcion) {
            case "1":
                result = columna1;
                break;
            case "2":
                result = columna2;
                break;
            case "3":
                result = columna3;
                break;
            case "4":
                result = columna4;
                break;
            case "5":
                result = columna5;
                break;
            case "6":
                result = columna6;
                break;
            case "7":
                result = columna7;
                break;
            case "8":
                result = reserva;
                break;
            case "q":
                result = base1;
                break;
            case "w":
                result = base2;
                break;
            case "e":
                result = base3;
                break;
            case "r":
                result = base4;
                break;

        }
        return result;
    }

    public void sacarMazo() {
        if (!mazo.isEmpty()) {
            reserva.add(mazo.pop());
        } else {
            if (!reserva.isEmpty()) {
                mazo.addAll(reserva);
                reserva.removeAllElements();
                Collections.shuffle(mazo);
            } else {
                System.out.println("El mazo esta vacio");
            }
        }
    }

    public void permitido(Stack<Integer> firstPile, Stack<Integer> secondPile, int index) {
        int contador=firstPile.size() - index;
        
        while(contador<firstPile.size()){
        secondPile.add(firstPile.remove(contador));
        }
    }

    public boolean movimientoPilas(String primeraPila, String segundaPila, int index) {
        Validaciones val = new Validaciones();
        boolean result = false;
        Stack<Integer> firstPile = selectPila(primeraPila), secondPile = selectPila(segundaPila);

        if (secondPile.size() == 0) {
            permitido(firstPile, secondPile, index);
            result = true;
        } else if (firstPile.get(firstPile.size() - index) == 12 || firstPile.get(firstPile.size() - index) == 25
                || firstPile.get(firstPile.size() - index) == 38 || firstPile.get(firstPile.size() - index) == 51) {
            val.movimientoNoValido();

        } else if (firstPile.get(firstPile.size() - index) < 13) {
            if (secondPile.peek() == firstPile.get(firstPile.size() - index) + 27
                    || secondPile.peek() == firstPile.get(firstPile.size() - index) + 40) {
                permitido(firstPile, secondPile, index);
                result = true;
            } else {
                val.movimientoNoValido();
            }

        } else if (firstPile.get(firstPile.size() - index) < 26) {
            if (secondPile.peek() == firstPile.get(firstPile.size() - index) + 14
                    || secondPile.peek() == firstPile.get(firstPile.size() - index) + 27) {
                permitido(firstPile, secondPile, index);
                result = true;
            } else {
                val.movimientoNoValido();
            }

        } else if (firstPile.get(firstPile.size() - index) < 39) {
            if (secondPile.peek() == firstPile.get(firstPile.size() - index) - 12
                    || secondPile.peek() == firstPile.get(firstPile.size() - index) - 25) {
                permitido(firstPile, secondPile, index);
                result = true;
            } else {
                val.movimientoNoValido();
            }

        } else if (firstPile.get(firstPile.size() - index) < 52) {
            if (secondPile.peek() == firstPile.get(firstPile.size() - index) - 25
                    || secondPile.peek() == firstPile.get(firstPile.size() - index) - 38) {
                permitido(firstPile, secondPile, index);
                result = true;
            } else {
                val.movimientoNoValido();
            }

        }
        return result;
    }

    public boolean pilasABase(String primeraPila, String segundaPila) {
        Validaciones val = new Validaciones();
        boolean result = false;
        Stack<Integer> firstPile = selectPila(primeraPila), secondPile = selectPila(segundaPila);
        int index = 1;
        if (!firstPile.isEmpty()) {
            if (firstPile.peek() == 0 || firstPile.peek() == 13 || firstPile.peek() == 26
                    || firstPile.peek() == 39) {
                if (secondPile.size() == 0) {
                    permitido(firstPile, secondPile, index);
                    result = true;
                } else {
                    val.movimientoNoValido();
                }
            } else if (firstPile.peek() == (secondPile.peek() + 1)) {
                permitido(firstPile, secondPile, index);
                result = true;
            } else {
                val.movimientoNoValido();
            }
        } else {
            val.movimientoNoValido();
        }
        return result;
    }

}

