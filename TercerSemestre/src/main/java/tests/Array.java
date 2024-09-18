/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;
import java.util.Random;
/**
 *
 * @author sergiob.t.
 */
public class Array {
    public static void Asign(int[] numero) {
        Random random = new Random();
        for (int i = 0; i < numero.length; i++) {
            numero[i] = random.nextInt(99);
        }
    }
    public static void PrintArray (int[] numero) {
        for (int i = 0; i < numero.length; i++) {
            System.out.println(numero[i]);
        }
    }
}
