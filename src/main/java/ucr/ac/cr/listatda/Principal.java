/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.listatda;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal {

    ListaTDA<Integer> listaTDA;

    public Principal() {
         listaTDA = new ListaTDA<Integer>();
        menu();
    }

    public void menu() {
        int opcion = 0, dato = 0, posicion = 0, valorABuscar = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion:\n"
                    + "1. Insertar un elemento en una posicion exacta. \n"
                    + "2. Obtener la posicion de ´x´ elemento \n"
                    + "3. Recupera un elemento segun su posicion.\n"
                    + "4. Suprime un elemento segun su posicion. \n"
                    + "5. Limpiar lista. \n"
                    + "6. Obtener el primer objeto.\n"
                    + "7. Imprimir toda la lista.\n"
                    + "8. Salir.\n"));

            switch (opcion) {
                case 1: //Insertar
                    dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor a almacenar7"));
                    posicion = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion donde desea almacenarlo"));

                    listaTDA.insertar(dato, posicion);
                    break;
                case 2: //Localiza
                    dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el elemento"));
                    JOptionPane.showMessageDialog(null, Integer.toString(listaTDA.localiza(dato)));
                    break;
                case 3://Recupera
                    posicion = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la posicion a buscar",
                            "Insertar DESPUES de..", JOptionPane.QUESTION_MESSAGE));
                    JOptionPane.showMessageDialog(null, listaTDA.recupera(posicion));
                    break;
                case 4://Suprime
                    dato = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion del elemento que desea eliminar "));
                    listaTDA.suprime(dato);
                    break;
                case 5://anula
                    dato = Integer.parseInt(JOptionPane.showInputDialog("Segur@? 1.SI 2.NO"));
                    if (dato == 1) {
                        listaTDA.anula();
                    }
                    break;
                case 6://primero
                    JOptionPane.showMessageDialog(null, listaTDA.primero());
                    break;
                case 7://imprimirLista
                    JTextArea textArea = new JTextArea(20, 25);
                    textArea.setText(listaTDA.imprimirLista());
                    textArea.setEditable(false);

                    JScrollPane scrollPane = new JScrollPane(textArea);
                    JOptionPane.showMessageDialog(null, scrollPane, "Reporte", JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 8://Salir
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Numero incorrecto");
            }//Fin switch
        } while (opcion != 8);

    }//Fin del main

    public static void main(String arg[]) {
        Principal principal = new Principal();
    }//Fin del main
}//Fin clase OperaNodo
