/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tercersemestre;
import java.util.Scanner;
import stack.*;
import notacionPolacaInversa.*;
//import notacionPolacaInversa.*;
/**
 *
 * @author sergiob.t.
 */
public class Principal {

    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      NotacionPolaca polaca = new NotacionPolaca();
      String ecuacion = null;
      String caracter = null;
      int contadorParentesis=0;
      
      System.out.println("Ingresa tu ecuacion: ");
      ecuacion = read.nextLine();
      
      int resultado = polaca.resolverPolaca(ecuacion);
      System.out.println("Resultado: " + resultado);
      
      
      
      
      ArrayStack pila = new ArrayStack(ecuacion.length());
      for(int i=0;i<ecuacion.length();i++){
          caracter=ecuacion.substring(i, i+1);
          if(caracter.equals("(")){
              pila.push(caracter);
          }else if (caracter.equals(")")){
              if(pila.isEmpty()==true&&pila.pop()==null){
                contadorParentesis++;
              }
              pila.pop();
          }
      }
      if(pila.size()==0&&contadorParentesis==0){
          System.out.println("Los parentesis estan bien colocados");
      }else{
          System.out.println("Los parentesis estan mal colocados");
      }
      
      read.close();
      
    }
    
}
