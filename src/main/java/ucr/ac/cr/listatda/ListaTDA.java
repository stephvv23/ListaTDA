/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.listatda;

/**
 *
 * @author Stephanie
 */
public class ListaTDA {

    private Nodo primero;
    private Nodo ultimo;

    public ListaTDA() {
        primero = null;
        ultimo = null;
    }

    public void insertar(int dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
        if (this.esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {

            Nodo aux = null;
            Nodo indice = primero;
            int contador = 0;

            while (indice != null) {

                if (posicion == contador) {
                    System.out.println("B");
                    nuevo.setSiguiente(indice);
                    aux.setSiguiente(nuevo);
                    break;
                } else if (indice == ultimo) {
                    System.out.println("A");
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
                Nodo indice = primero;
                Nodo anterior = null;
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

    public int recupera(int posicion) {

        Nodo indice = this.primero;
        int contador = 0;
        while (indice != null) {

            if (contador == posicion) {
                return indice.getDato();
            }
            contador++;
            indice = indice.getSiguiente();
        }
        return -1;
    }

    // DEBERIA SER CON DATO, no con carnet
    public Integer localiza(int dato) {
        Nodo nodoIndice = primero;
        int indice = 0;
        while (nodoIndice != null) {

            if (nodoIndice.getDato() == dato) {
                return indice;
            }
            nodoIndice = nodoIndice.getSiguiente();
            indice++;
        }
        return -1;
    }

    public String imprimirLista() {
        Nodo indice = primero;
        int contador = 0;
        String mensaje = "Lista: \n";
        while (indice != null) {
            mensaje += contador + " [" + indice.getDato() + "],";
            contador++;
            indice = indice.getSiguiente();
        }
        return mensaje;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void anula() {
        primero = null;
        ultimo = null;
    }

    public int primero() {
        return primero.getDato();
    }
}
