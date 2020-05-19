package com.company.Heaps;

import java.util.Arrays;

public class MinHeap {
    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{"+key+"='"+value+"'}";
        }
    }

    private Node[] heap;
    private int count;

    public MinHeap(int height) {
        heap = new Node[(int) Math.pow(2, height+1)-1];
        count = 0;
    }

    public void insert(int key, String value) {
        if (isFull())
            throw new IllegalStateException();

        heap[count++] = new Node(key, value);

        bubbleUp();
    }

    private void bubbleUp() {
        var index = getIndex();
        while (!isEmpty() && heap[index].key < heap[getParentIndex(index)].key) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public String remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = heap[0];
        heap[0] = heap[--count];
        heap[count] = null;

        bubbleDown();

        return root.value;
    }

    private void bubbleDown() {
        var index = 0;
        while (index<=count && !isValidParent(index)) {
            var smallerChildIndex = getSmallerChildIndex(index);
            swap(smallerChildIndex, index);
            index = smallerChildIndex;
        }
    }

    public boolean isMinHeap() { return isMinHeap(0); }

    private boolean isMinHeap(int index) {
        if (index > heap.length/2-1)
            return true;

        return isValidParent(index) && isMinHeap(leftChildIndex(index)) && isMinHeap(rightChildIndex(index));
    }

    private int getSmallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) < rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = heap[index].key <= leftChild(index);
        if (hasRightChild(index))
            isValid &= heap[index].key <= rightChild(index);

        return isValid;
    }

    private int leftChild(int index) { return heap[leftChildIndex(index)].key; }

    private int rightChild(int index) { return heap[rightChildIndex(index)].key; }

    private boolean hasLeftChild(int index) { return leftChildIndex(index) < count; }

    private boolean hasRightChild(int index) { return rightChildIndex(index) < count; }

    private int leftChildIndex(int index) { return 2*index+1; }

    private int rightChildIndex(int index) { return 2*index+2; }

    private int getParentIndex(int index) { return (index-1)/2; }

    private int getIndex() { return count - 1; }

    private void swap(int child, int parent) {
        var temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    public boolean isEmpty() { return count == 0; }

    public boolean isFull() { return count == heap.length; }

    public Node min() {
        if (isEmpty())
            throw new IllegalStateException();

        return heap[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
