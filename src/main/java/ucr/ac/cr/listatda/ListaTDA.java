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
    }

    //Inserta un elemento x en la posicion p.
    public String insertar(int elemento, int posicion) {
        Nodo nuevo = new Nodo(elemento);
        if (this.esVacia()) {

            this.primero = nuevo;
            this.ultimo = nuevo;
            return "La lista esta vacia, por tanto se añadio al inicio";
        }
        if (posicion == 1) {
            nuevo.setSiguiente(this.primero);
            primero = nuevo;
            return "Añadido con exito";
        }
        if (posicion > this.contarElementos()) {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
        } else {
            Nodo aux = null;
            Nodo indice = this.primero;
            int contador = 0;
            while (indice != null) {
                if (contador == posicion - 1) {
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(indice);
                    return "Añadido con exito";
                }
                aux = indice;
                indice = indice.getSiguiente();
                contador++;
            }
        }
        return "no se pudo añadir";
    }

    public int localiza(int elemento) {
        if (elemento != ultimo.getDato()) {
            Nodo indice = this.primero;
            int contador = 0;

            while (indice != null) {
                contador++;//Para dar la posicion que el usuario espera
                if (indice.getDato() == elemento) {
                    return contador;
                }
                indice = indice.getSiguiente();
            }
        } else {
            return this.contarElementos(); // [0][1][2][3] (contar devuelve 4 y efectivamente pra el usuario serala posicion 4
        }

        return -1;
    }

//    public int recupera(int posicion) {
//
//            Nodo indice = this.primero;
//            int contador = 0;
//            while (indice != null) {
//                
//                if (contador == posicion) {
//                    return indice.getDato();
//                }
//                contador++;
//                indice = indice.getSiguiente();
//            }
//        }
//        return -1;
//
//    }
    public Nodo recupera(int posicion) {
        if (posicion <= this.contarElementos()) {
            if (posicion == this.contarElementos()) {
                return ultimo;
            }
            Nodo indice = this.primero;
            int contador = 0;
            while (indice != null) {
                contador++;//Para dar la posicion que el usuario espera
                if (contador == posicion) {
                    return indice;
                }
                indice = indice.getSiguiente();
            }
        }
        return null;

    }

    public void suprime(int posicion) {
        if (!esVacia()) {
            if (posicion <= this.contarElementos()) {

                if (posicion == 1) {
                    // Eliminar el primer nodo
                    if (1 < this.contarElementos()) {
                        this.primero = primero.getSiguiente();
                    } else {
                        this.anula();
                    }
                } else if (posicion == contarElementos()) {
                    // Eliminar el último nodo
                    Nodo anterior = recupera(contarElementos() - 1);
                    anterior.setSiguiente(null);
                    ultimo = anterior;
                } else {
                    // Eliminar un nodo en medio de la lista
                    Nodo anterior = recupera(posicion - 1);
                    Nodo nodoEliminar = recupera(posicion);
                    anterior.setSiguiente(nodoEliminar.getSiguiente());

                }
            }
        }
    }
    public void anula() {
        this.primero = null;
        this.ultimo = null;
    }

    public int primero() {
        return primero.getDato();
    }

    public String imprimirLista() {
        Nodo indice = primero;
        String mensaje = "Lista:";
        while (indice != null) {
            mensaje += "[" + indice.getDato() + "] ";
            indice = indice.getSiguiente();
        }
        return mensaje;
    }

    public int contarElementos() {
        Nodo indice = this.primero;
        int contador = 0;
        while (indice != null) {
            contador++;
            indice = indice.getSiguiente();
        }
        return contador;
    }

    //Metodo para verificar si la lista enlazada esta vacia o no
    public boolean esVacia() {
        if (this.primero == null) {
            return true; //La lista esta vacia
        }
        return false; //La lista ya tiene al menos el primer nodo
    }
}
