package eci.edu.arsw.linkedList;

/**
 * Clase que representa un nodo de una lista enlazada (LinkedList) para almacenar un valor double.
 * Cada nodo tiene un valor y una referencia al siguiente nodo en la lista.
 * 
 * @author Alejandro Prieto
 */
public class Node {

    /**
     * Valor almacenado en el nodo.
     */
    private double data;

    /**
     * Referencia al siguiente nodo de la lista.
     */
    private Node next;

    /**
     * Constructor del nodo.
     * 
     * @param data Valor numérico a almacenar en el nodo.
     * @param next Nodo siguiente en la lista. Puede ser null si es el último nodo.
     */
    public Node(double data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Retorna el valor almacenado en el nodo.
     * 
     * @return valor double del nodo.
     */
    public double getData() {
        return data;
    }

    /**
     * Modifica el valor almacenado en el nodo.
     * 
     * @param data nuevo valor double para el nodo.
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * Retorna el siguiente nodo de la lista.
     * 
     * @return referencia al siguiente nodo, o null si no hay siguiente.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo de la lista.
     * 
     * @param next nodo siguiente a establecer.
     */
    public void setNext(Node next) {
        this.next = next;
    }
}
