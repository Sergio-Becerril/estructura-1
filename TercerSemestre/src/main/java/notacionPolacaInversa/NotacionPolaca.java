/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notacionPolacaInversa;
import stack.*;

/**
 *
 * @author sergiob.t.
 */
public class NotacionPolaca {
    
    public static int normalAPolaca(String ecuacion){
        ArrayStack pilaCoeficiente = new ArrayStack(ecuacion.length());
        ArrayStack pilaOperadores = new ArrayStack(ecuacion.length());
        for (int i=0;i<ecuacion.length();i++){
        
        }
        int resultado=0;
        return resultado;
    }
    
    
    public static int resolverPolaca(String ecuacionPolaca) {
        ArrayStack pila = new ArrayStack(ecuacionPolaca.length());
        int a,b,resultado=0;
        char caracter;
        for (int i=0;i<ecuacionPolaca.length();i++) {
            caracter=ecuacionPolaca.charAt(i);
            if (Character.isDigit(caracter)) {
                pila.push(caracter);
            } else {
                String stringB = pila.pop().toString();
                b = Integer.parseInt(stringB);
                String stringA = pila.pop().toString();
                a = Integer.parseInt(stringA);
                switch (caracter) {
                    case '+':
                        pila.push(a + b);
                        pila.push(a+b);
                        String stringResultado = pila.pop().toString();
                        resultado = Integer.parseInt(stringResultado);
                        break;
                    case '-':
                        pila.push(a - b);
                        pila.push(a - b);
                        stringResultado = pila.pop().toString();
                        resultado = Integer.parseInt(stringResultado);
                        break;
                    case '*':
                        pila.push(a * b);
                        pila.push(a * b);
                        stringResultado = pila.pop().toString();
                        resultado = Integer.parseInt(stringResultado);
                        break;
                    case '/':
                        pila.push(a / b);
                        pila.push(a / b);
                        stringResultado = pila.pop().toString();
                        resultado = Integer.parseInt(stringResultado);
                        break;
                }
            }
        }
        return resultado;
    }
    
}
