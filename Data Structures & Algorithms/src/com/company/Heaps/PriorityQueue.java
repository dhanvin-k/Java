package com.company.Heaps;

public class PriorityQueue {
    private Heaps heap;

    public PriorityQueue(int size) {
        heap = new Heaps(size);
    }

    private void enqueue(int item) { heap.insert(item); }

    private int dequeue() { return heap.remove(); }

    private boolean isEmpty() { return heap.isEmpty(); }

    private boolean isFull() { return heap.isFull(); }
}
