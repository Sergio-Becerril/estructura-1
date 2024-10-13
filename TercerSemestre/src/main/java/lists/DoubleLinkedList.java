/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

import nodos.*;

/**
 *
 * @author sergiob.t.
 */
public class DoubleLinkedList {
    private int size;
    private DoubleNodo a;
    public DoubleLinkedList() {
            size=0;
            a=null;
    }

    public int size() {
            return size;
    }
    public boolean isEmpty() {
            return size==0;
    }
    public Object get(int index) {
            Object value=null;
            if(index>=0&&index<size&&!isEmpty()) {
                    DoubleNodo actual=a;
                    for(int i=size-1;i>index;i--) {
                            actual=actual.getDerecha();
                    }
                    value=actual.getValor();



            }
            return value;
    }
    public Object set(int index,Object value) {
            Object returnVal=null;
            if(index>=0&&index<size&&!isEmpty()) {
                    DoubleNodo actual=a;
                    for(int i=size-1;i>index;i--) {
                            actual=actual.getDerecha();
                    }
                    returnVal=actual.getValor();
                    actual.setValor(value);	
            }
            return returnVal;
    }
}
