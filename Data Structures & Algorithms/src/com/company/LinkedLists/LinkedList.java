package com.company.LinkedLists;

import javax.swing.plaf.IconUIResource;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public int indexOf(int value) {
        var current = first;

        for (int index = 0; current != null; index++) {
            if (current.value == value)
                return index;
            current = current.next;
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var temp = first.next;
        first = null;
        first = temp;
        temp = null;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }

        var current = first;
        while(current.next != last)
            current = current.next;

        last = null;
        current.next = null;
        last = current;
    }

    public void print() {
        System.out.print("[");
        var next = first;
        while(next != null) {
            System.out.print(next.value + ", ");
            next = next.next;
        }
        System.out.println("]");
    }
}
