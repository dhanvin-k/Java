package com.company.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<Integer>();
    private Queue<Integer> queue2 = new ArrayDeque<Integer>();
    private int top;

    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1)
            queue2.add(queue1.remove());

        swapQueues();

        return queue2.remove();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public boolean isEmpty() { return queue1.size() == 0; }
    public int size() { return queue1.size(); }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
