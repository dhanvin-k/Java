package com.company.Heaps;

public class MinPriorityQueue {
    private MinHeap heap;
    private int rear;

    public MinPriorityQueue(int size) {
        heap = new MinHeap(size);
        rear = 0;
    }

    public void add(int priority, String value) { heap.insert(priority, value); }

    public String remove() { return heap.remove(); }

    public boolean isEmpty() { return heap.isEmpty(); }

    @Override
    public String toString() {
        return heap.toString();
    }
}
