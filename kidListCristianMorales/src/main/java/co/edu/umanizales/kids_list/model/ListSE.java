package co.edu.umanizales.kids_list.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;
    private int size;

    // Agregar al final de la lista
    public void add(Kid kid) {
        if (head == null) {
            head = new Node(kid);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        size++;
    }

    // Agregar al inicio de la lista
    public void addToStart(Kid kid) {
        Node newNode = new Node(kid);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    // Agregar en una posición específica
    public void addAtPosition(Kid kid, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (position == 0) {
            addToStart(kid);
        } else {
            Node newNode = new Node(kid);
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }

    // Invertir la lista
    public void invert() {
        if (head != null) {
            Node prev = null;
            Node current = head;
            Node next;
            while (current != null) {
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
            }
            head = prev;
        }
    }

    // Eliminar por ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.getData().getId() == id) {
            removeFirst();
            return;
        }

        Node temp = head;
        while (temp.getNext() != null && temp.getNext().getData().getId() != id) {
            temp = temp.getNext();
        }

        if (temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
            size--;
        }
    }

    // Eliminar en una posición específica
    public void removeAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (position == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            size--;
        }
    }

    // Intercalar por género
    public void interleaveByGender() {
        if (head == null) return;

        ListSE boys = new ListSE();
        ListSE girls = new ListSE();
        Node temp = head;

        while (temp != null) {
            if (temp.getData().getGender() == 'M') {
                boys.add(temp.getData());
            } else if (temp.getData().getGender() == 'F') {
                girls.add(temp.getData());
            }
            temp = temp.getNext();
        }

        Node boysNode = boys.getHead();
        Node girlsNode = girls.getHead();
        ListSE interleavedList = new ListSE();

        while (boysNode != null || girlsNode != null) {
            if (boysNode != null) {
                interleavedList.add(boysNode.getData());
                boysNode = boysNode.getNext();
            }
            if (girlsNode != null) {
                interleavedList.add(girlsNode.getData());
                girlsNode = girlsNode.getNext();
            }
        }

        this.head = interleavedList.getHead();
        this.size = interleavedList.getSize();
    }

    // Intercambiar extremos
    public void swapExtremes() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node first = head;
        Node last = head;
        Node prevLast = null;

        while (last.getNext() != null) {
            prevLast = last;
            last = last.getNext();
        }

        if (first == last) return;

        Kid temp = first.getData();
        first.setData(last.getData());
        last.setData(temp);
    }

    // Metodo auxiliar para eliminar el primer nodo
    private void removeFirst() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }
}
