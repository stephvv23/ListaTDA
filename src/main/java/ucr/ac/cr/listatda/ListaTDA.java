/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.listatda;

/**
 *
 * @author Stephanie
 */
public class ListaTDA<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public ListaTDA() {
        primero = null;
        ultimo = null;
    }

    public void insertar(T dato, int posicion) {
        Nodo<T> nuevo = new Nodo<T>(dato);
        if (this.esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {

            Nodo<T> aux = null;
            Nodo<T> indice = primero;
            int contador = 0;

            while (indice != null) {

                if (posicion == contador) {
                    nuevo.setSiguiente(indice);
                    aux.setSiguiente(nuevo);
                    break;
                } else if (indice == ultimo) {
                    this.ultimo.setSiguiente(nuevo);
                    this.ultimo = nuevo;
                    break;
                }

                contador++;
                aux = indice;
                indice = indice.getSiguiente();
            }

        }
    }

    public void suprime(int posicion) {
        if (!esVacia()) {

            if (posicion == 0) {

                // Eliminar el primer nod0
                if (primero.getSiguiente() != null) {
                    this.primero = primero.getSiguiente();
                } else {
                    this.anula();
                }

            } else {
                // Eliminar un nodo en medio de la lista
                Nodo<T> indice = primero;
                Nodo<T> anterior = null;
                int contador = 0;

                while (indice != null) {
                    if (posicion == contador) {

                        if (indice == ultimo) {
                            ultimo = anterior;
                        } else {
                            anterior.setSiguiente(indice.getSiguiente());
                        }
                    }

                    contador++;
                    anterior = indice;
                    indice = indice.getSiguiente();
                }

            }

        }

    }

    public T recupera(int posicion) {

        Nodo<T> indice = this.primero;
        int contador = 0;
        T elemento = null;
        while (indice != null) {

            if (contador == posicion) {
                elemento = indice.getDato();
            }
            contador++;
            indice = indice.getSiguiente();
        }
        return elemento;
    }

    // DEBERIA SER CON DATO, no con carnet
    public Integer localiza(T dato) {
        Nodo<T> nodoIndice = primero;
        int contador = 0;
        while (nodoIndice != null) {

            if (nodoIndice.getDato().equals(dato)) {
                return contador;
            }
            nodoIndice = nodoIndice.getSiguiente();
            contador++;
        }
        return null;
    }

    public String imprimirLista() {
        Nodo<T> indice = primero;
        String mensaje = "";
        while (indice != null) {
            mensaje += "[" + indice.getDato().toString() + "]  ";
            indice = indice.getSiguiente();
        }
        return mensaje+"\n";
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void anula() {
        primero = null;
        ultimo = null;
    }

    public T primero() {
        return primero.getDato();
    }
}
