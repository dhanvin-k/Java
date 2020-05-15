package com.company.Heaps;

import java.util.Arrays;

public class Heaps {
    private int[] heap;
    private int count;

    public Heaps(int height) {
        this.heap = new int[(int) Math.pow(2, height+1)-1];
        count = 0;
    }

    public void insert(int value) {
        if (count == heap.length)
            throw new IllegalStateException();

        heap[count++] = value;

        var index = getIndex();
        while (index > 0 && heap[index] > getParent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        heap[parentIndex] += heap[index];
        heap[index] = heap[parentIndex] - heap[index];
        heap[parentIndex] -= heap[index];
    }

    private int getParent(int index) { return heap[getParentIndex(index)]; }

    private int getParentIndex(int index) { return (index-1)/2; }

    private int getIndex() { return count - 1; }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
// 7  9