/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import nodos.DateNodo;
import java.util.Date;

/**
 *
 * @author sergiob.t.
 */
public class PriorityDateQueue {

    private DateNodo front;
    private DateNodo rear;
    private Object[] queue;
    private int size;

    public PriorityDateQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue1(DateNodo nodo) {
        if (isEmpty()) {
            front = nodo;
            rear = nodo;
        } else {
            rear.setEnlace(nodo);
            rear = nodo;
        }
    }

    public void enqueue(Object value, Date fecha) {
        DateNodo n = new DateNodo();
        n.setValor(value);
        n.setFecha(fecha);
        if (isEmpty()) {
            front = n;
            rear = n;
        } else {
            if (fecha.compareTo(rear.getFecha())>=0) {
                enqueue1(n);
            } else {
                DateNodo actual = front;
                DateNodo siguiente = front.getEnlace();
                if (fecha.compareTo(front.getFecha())==-1) {
                    n.setEnlace(front);
                    front = n;
                } else {
                    while (null != siguiente) {
                        if (fecha.compareTo(siguiente.getFecha())==-1) {
                            break;
                        }
                        actual = siguiente;
                        siguiente = siguiente.getEnlace();
                    }
                    actual.setEnlace(n);
                    n.setEnlace(siguiente);
                }
            }
        }
        size++;
    }

    public Object dequeue() {
        Object value = null;
        if (!isEmpty()) {
            size--;
            value = front.getValor();
            front = front.getEnlace();
        }
        return value;
    }

    public String toString() {
        String s = "";
        DateNodo t = front;
        while (null != t) {
            s += t.getValor() + "<";
            t = t.getEnlace();
        }
        return s;
    }
}