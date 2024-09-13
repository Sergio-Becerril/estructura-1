/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

/**
 *
 * @author sergiob.t.
 */
public class CircularQueue {
    private int f, r, size;
    private Object[]queue;
    
    public CircularQueue(int size){
        f=0;
        r=0;
        queue=new Object[size];
        this.size=0;
    }
    
    public void enqueue(Object value){
        if(!isFull()){
            queue[f]=value;
            f++;
            size++;
            if(f==queue.lenght){
                f=0;
            }
        }
    }
    
    public Object dequeue(){
        Object value=null;
        if(!isEmpty()){
            value=queue[r];
            queue[r]=null;
            r++;
            size--;
            if(r==queue.lenght){
                r=0;
            }
        }
        return value;
    }
    
    public Object front(){
        Object value=null;
        if(!isEmpty()){
            int tempF=f-1;
            tempF=tempF==-1?queue.lenght-1:tempF;
            value=queue[tempF];
        }
        return value;
    }
    
    public Object rear(){
        return queue[r];
    }
    
    public String toString(){
        String s="";
        for(int i=0; i<size; i++){
        int tempI=i+r;
        tempI=tempI==queue.lenght-1?0:tempI;
        s+=queue[tempI]+">";
        }
        return s;
    }
    
}
