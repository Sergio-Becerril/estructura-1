/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorts;

/**
 *
 * @author sergiob.t.
 */
public class Shellsort {

    public static void Shellsort(int[] numeros) {
        int N = numeros.length;
        int k = N / 2;
        while (k >= 1) {
            for (int i = 0; i < k; i++) {
                for (int j = k + i; j < N; j += k) {
                    int v = numeros[j];
                    int n = j - k;
                    while (n >= 0 && numeros[n] > v) {
                        numeros[n + k] = numeros[n];
                        n -= k;
                    }
                    numeros[n + k] = v;
                }
            }
            k=k/2;
        }

    }
}
