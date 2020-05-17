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
        if (isFull())
            throw new IllegalStateException();

        heap[count++] = value;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = heap[0];
        heap[0] = heap[--count];
        heap[count] = 0;

        bubbleDown();

        return root;
    }

    private void bubbleUp() {
        var index = getIndex();
        while (index > 0 && heap[index] > parent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= count && !isValidParent(index)) {
            var largerChildIndex = getLargerChildIndex(index);
            swap(largerChildIndex, index);
            index = largerChildIndex;
        }
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return getLeftChildIndex(index);

        return leftChild(index) > rightChild(index) ? getLeftChildIndex(index) : getRightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = heap[index] >= leftChild(index);
        if (hasRightChild(index))
            isValid &= heap[index] >= rightChild(index);

        return isValid;
    }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index)<=count; }

    private boolean hasRightChild(int index) { return getRightChildIndex(index)<=count; }

    private int leftChild(int index) { return heap[getLeftChildIndex(index)]; }

    private int rightChild(int index) { return heap[getRightChildIndex(index)]; }

    private int getLeftChildIndex(int index) { return 2*index + 1; }

    private int getRightChildIndex(int index) { return 2*index + 2; }

    private void swap(int index, int parentIndex) {
        var temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

    private int parent(int index) { return heap[getParentIndex(index)]; }

    private int getParentIndex(int index) { return (index-1)/2; }

    private int getIndex() { return count - 1; }

    public boolean isFull() { return count == heap.length; }

    public boolean isEmpty() { return count == 0; }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        return heap[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}