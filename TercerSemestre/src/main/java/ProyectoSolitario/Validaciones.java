/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoSolitario;
import java.util.*;

/**
 *
 * @author sergiob.t.
 */
public class Validaciones {
    
    public boolean opcionValida(String opcion){
        boolean result=false;
        if ((!opcion.equals("1"))&&(!opcion.equals("2"))&&(!opcion.equals("3"))&&
                (!opcion.equals("4"))&&(!opcion.equals("5"))&&(!opcion.equals("6"))&&
                (!opcion.equals("7"))&&(!opcion.equals("9"))&&(!opcion.equals("q"))&&
                (!opcion.equals("w"))&&(!opcion.equals("e"))&&(!opcion.equals("r"))){
            System.out.println("Opcion no valida");
            result=false;
        } else {
            result=true;
        }
        return result;
    }
    public boolean numeroVali(String opcion){
        boolean result=false;
        if ((!opcion.equals("1"))&&(!opcion.equals("2"))&&(!opcion.equals("3"))&&
                (!opcion.equals("4"))&&(!opcion.equals("5"))&&(!opcion.equals("6"))&&
                (!opcion.equals("7"))&&(!opcion.equals("8"))&&(!opcion.equals("9"))&&
                (!opcion.equals("10"))&&(!opcion.equals("11"))&&(!opcion.equals("12"))){
        } else {
            result=true;
        }
        return result;
    }
    public void movimientoNoValido(){
        System.out.println("Movimiento no valido");
    }
    public void movimientoValido(){
        System.out.println("Movimiento no valido");
    }
}
