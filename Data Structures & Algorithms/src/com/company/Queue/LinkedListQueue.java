package com.company.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListQueue {
    private class Node {
        int value;
        Node next;

        public Node(int value) { this.value = value; }
    }

    private Node first;
    private Node last;
    private int count = 0;

    public void enqueue(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int value;
        if (first == last) {
            value = first.value;
            first = last = null;
        }
        else {
            value = first.value;
            first = first.next;
        }
        count --;

        return value;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return first.value;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return count; }

    @Override
    public String toString() {
        ArrayList<Integer> contents = new ArrayList<Integer>();

        Node current = first;
        while (current != null) {
            contents.add(current.value);
            current = current.next;
        }

        return contents.toString();
    }
}
