package com.company.Queue;

import java.util.Arrays;

public class PriortyQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public PriortyQueue(int capacity) {
        this.queue = new int[capacity];
        this.count = 0;
        this.front = 0;
    }

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        var index = shiftItemsToInsert(item);

        queue[index] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item < queue[i])
                queue[i + 1] = queue[i];
            else
                break;
        }
        return i+1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return queue[--count];
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() {
        return count == queue.length;
    }


    @Override
    public String toString() {
        var content = Arrays.copyOfRange(queue, front, count);

        return Arrays.toString(content);
    }
}
