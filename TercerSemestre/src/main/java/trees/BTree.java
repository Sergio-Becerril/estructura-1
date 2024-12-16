/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trees;
import nodos.*;
/**
 *
 * @author sergiob.t.
 */
public class BTree {
	/*
	R=raiz
	I=izquierda
	D=derecha
	
	Preorden  R I D
	Inorden   I R D
	Postorden I D R
	*/
	private DoubleNodo r;

	public BTree() {
		r = null;
	}

	public boolean isEmpty() {
		return r == null;
	}

	public void add(Object value) {
		DoubleNodo n = new DoubleNodo();
		n.setValor(value);
		if (isEmpty()) {
			r = n;
		} else {
			add(n, r);
		}
	}

	private void add(DoubleNodo n, DoubleNodo root) {
		if ((int) n.getValor() > (int) root.getValor()) {
			if (root.getDerecha() == null) {
				root.setDerecha(n);
			} else {
				add(n, root.getDerecha());
			}
		} else {
			if (root.getIzquierda() == null) {
				root.setIzquierda(n);
			} else {
				add(n, root.getIzquierda());
			}
		}
	}

	// Preorden: R I D
	public void preorden() {
		preorden(r);
	}

	private void preorden(DoubleNodo actual) {
		if (actual != null) {
			System.out.println(actual.getValor());
			preorden(actual.getIzquierda());
			preorden(actual.getDerecha());
		}
	}

	// Inorden: I R D
	public void inorden() {
		inorden(r);
	}

	private void inorden(DoubleNodo actual) {
		if (actual != null) {
			inorden(actual.getIzquierda());
			System.out.println(actual.getValor());
			inorden(actual.getDerecha());
		}
	}

	// Postorden: I D R
	public void postorden() {
		postorden(r);
	}

	private void postorden(DoubleNodo actual) {
		if (actual != null) {
			postorden(actual.getIzquierda());
			postorden(actual.getDerecha());
			System.out.println(actual.getValor());
		}
	}

	// Encuentra el valor más pequeño en el árbol
	public Object findMin() {
		if (isEmpty()) {
			return null;
		}
		DoubleNodo current = r;
		while (current.getIzquierda() != null) {
			current = current.getIzquierda();
		}
		return current.getValor();
	}

	// Encuentra el valor más grande en el árbol
	public Object findMax() {
		if (isEmpty()) {
			return null;
		}
		DoubleNodo current = r;
		while (current.getDerecha() != null) {
			current = current.getDerecha();
		}
		return current.getValor();
	}
}

