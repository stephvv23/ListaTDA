/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.listatda;

/**
 *
 * @author Stephanie
 */
public class Nodo {

    private int dato;
    private Nodo siguiente;

    public Nodo() {
        this.dato = 0;
        this.siguiente = null;
    }

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(int dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return this.dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }
}
