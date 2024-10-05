/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;
import nodos.*;
/**
 *
 * @author sergiob.t.
 */
public class LinkedQueue {
    private Nodo front, rear;
    private int size;
    
    public void enqueue(Object value){
        Nodo n=new Nodo();
        n.setValor(value);
        if(isEmpty()){
            front=n;
            rear=n;
        }else{
            rear.setEnlace(n);
            rear=n;
        }
        size++;
    }
    
    public Object dequeue(){
        Object value =null;
        if(!isEmpty()){
            size--;
            value=front.getValor();
            front=front.getEnlace();
            
        }
        return value;
    }
    
    @Override
    public String toString(){
        String s="";
        Nodo t=front;
        while(null!=t){
            s+=t.getValor()+"<";
            t=t.getEnlace();
        }
        return s;
    }
    
    public LinkedQueue(){
        front=null;
        rear=null;
        size=0;
    }
   //size
   public int size(){
      return size;
   }
   //isEmpty
   public boolean isEmpty(){
      return size == 0;
   }
}



