package com.company.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        queue[rear] = item;
        rear = (rear + 1) % getSize();
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % getSize();
        count--;
        return item;
    }

    public int peek() { return queue[front]; }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == getSize(); }
    private int getSize() { return queue.length; }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}