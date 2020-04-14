package com.company.LinkedLists;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
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
    private int length;

    private boolean isEmpty() {
        return first == null;
    }

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }

        length++;
    }

    public void addFirst(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }

        length++;
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

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        length--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        length--;
    }

    public void removeAt(int index) {
        if (index < 0 || index > length-1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        else if (index == length - 1) {
            removeLast();
            return;
        }

        var current = first;
        for (int i = 0; i < length; i++) {
            if (i == index - 1) {
                var temp = current.next.next;
                current.next = null;
                current.next = temp;
                length--;
                return;
            }
            current = current.next;
        }
    }

    public Node getPrevious(Node node) {
        var current = first;
        while(current.next != node) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return length;
    }

    public int[] toArray() {
        int[] array = new int[length];

        int index = 0;
        Node current = first;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) return;

        var prev = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = prev;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var left = first;
        var right = first;
        for (int i = 0; i < k - 1; i++) {
            right = right.next;
            if (right == null)
                throw new IllegalArgumentException();
        }

        while (right != last) {
            left = left.next;
            right = right.next;
        }

        return left.value;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    public boolean hasLoop() {
        var a = first;
        var b = first;
        while (b != null && b.next != null) {
            b = b.next.next;
            a = a.next;
            if (b.next == a)
                return true;
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public void print() {
        System.out.println(Arrays.toString(toArray()));
    }
}
