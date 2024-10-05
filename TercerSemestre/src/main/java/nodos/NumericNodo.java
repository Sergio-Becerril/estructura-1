/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodos;

/**
 *
 * @author sergiob.t.
 */
public class NumericNodo {

    private NumericNodo enlace;
    private Integer prioridad;
    private Object valor;

    public NumericNodo getEnlace() {
        return enlace;
    }

    public void setEnlace(NumericNodo enlace) {
        this.enlace = enlace;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object dato) {
        this.valor = dato;
    }
}
