package eci.edu.arsw.linkedList;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements Iterable<Double> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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
