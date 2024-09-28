/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author sergiob.t.
 */
public class ArrayStack {
   private Object[] stack;
   private int a;
   public ArrayStack(int size){
      this.stack = new Object[size];
      this.a = 0;
   }
   //Size
   public int size(){
      return a;
   }
   //isEmpty
   public boolean isEmpty(){
      return a == 0;
   }
   //isFull
   public Boolean isFull(){
      return a == stack.length;
   }
   //Peek
   public Object peek(){
      Object val = null;
      if(!isEmpty()){
         val = stack[a-1];
      }
      return val;
   }
   //push
   public void push (Object val){
      if(!isFull()){
         stack[a] = val;
         a ++;
      }
   }
   //pop
   public Object pop(){
    Object val = null;
    if(!isEmpty()){
       a --;
       val = stack[a];
    }
    return val;
   }
   //Imprimir arreglo
   public String toString(){
      String s = " ";
      for(int i = 0; i<a; i++){
         s += stack[i]+ "=";
      }
      return s;
   }
}

