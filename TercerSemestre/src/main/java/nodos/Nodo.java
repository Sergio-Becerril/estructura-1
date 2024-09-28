/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 *
 * @author sergiob.t.
 */
public class Nodo {
    private Object valor;
    private Nodo enlace;
public Object getValor(){
    return valor;
    }
public Nodo getEnlace(){ //Leva al siguiente lugar
    return enlace;
    }
public void setValor(Object valor){
    this.valor=valor;
    }
public void setEnlace(Nodo enlace){
    this.enlace=enlace;
    }
}
