package eci.edu.arsw.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de una lista enlazada (LinkedList) para almacenar números de tipo double.
 * Proporciona métodos para agregar, eliminar, iterar y obtener el tamaño de la lista.
 * 
 * @author Alejandro Prieto Reyes
 */
public class LinkedList implements Iterable<Double> {

    /**
     * Nodo inicial de la lista.
     */
    private Node head;

    /**
     * Nodo final de la lista.
     */
    private Node tail;

    /**
     * Número de elementos en la lista.
     */
    private int size;

    /**
     * Constructor de la lista enlazada vacía.
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Agrega un nuevo elemento al final de la lista.
     * 
     * @param data Valor numérico a agregar.
     */
    public void add(double data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /**
     * Retorna el número de elementos en la lista.
     * 
     * @return tamaño de la lista.
     */
    public int size() {
        return size;
    }

    /**
     * Indica si la lista está vacía.
     * 
     * @return true si la lista no tiene elementos, false en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Elimina el primer elemento de la lista.
     * 
     * @return el valor eliminado.
     * @throws NoSuchElementException si la lista está vacía.
     */
    public double removeHead() {
        if (isEmpty()) throw new NoSuchElementException("La lista está vacía");
        double data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * Elimina el último elemento de la lista.
     * 
     * @return el valor eliminado.
     * @throws NoSuchElementException si la lista está vacía.
     */
    public double removeTail() {
        if (isEmpty()) throw new NoSuchElementException("La lista está vacía");

        double data = tail.getData();

        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
        return data;
    }

    /**
     * Elimina la primera ocurrencia de un valor específico en la lista.
     * 
     * @param data Valor a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean removeData(double data) {
        if (isEmpty()) return false;

        if (head.getData() == data) {
            removeHead();
            return true;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData() == data) {
                if (current.getNext() == tail) {
                    tail = current;
                }
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Imprime la lista completa en consola en formato [a, b, c].
     */
    public void print() {
        System.out.print("[ ");
        Node current = head;
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" , ");
            }
            current = current.getNext();
        }
        System.out.println(" ]");
    }

    /**
     * Retorna un iterador para recorrer la lista.
     * 
     * @return Iterator de Double.
     */
    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Double next() {
                if (!hasNext()) throw new NoSuchElementException();
                double data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
