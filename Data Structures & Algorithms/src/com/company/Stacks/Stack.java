package com.company.Stacks;

import com.company.Array.Array;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    private int count = 0;
    private int[] minStack;
    private int minCount = 0;

    public Stack(int size) {
        this.stack = new int[size];
        this.minStack = new int[size];
    }

    public void push(int item) {
        if (isFull())
            throw new StackOverflowError();

        if (isEmpty() || isSmaller(item)) minStack[minCount++] = item;

        stack[count++] = item;
    }

    public int pop() {
        if (isEmpty()) throw  new IllegalStateException();

        if (isTopInStackMin()) minCount--;

        return stack[--count];
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return stack[count-1];
    }

    public int getMinInStack() {
        if (isEmpty()) throw new IllegalStateException();

        return minStack[minCount - 1];
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == stack.length; }

    private boolean isTopInStackMin() { return stack[count - 1] == minStack[minCount - 1]; }
    private boolean isSmaller(int item) { return item < minStack[minCount - 1]; }

    private void resizeIfRequired() {
        if (stack.length == count) {
            int[] newStack = new int[count * 2];

            for (int i = 0; i < count; i++)
                newStack[i] = stack[i];

            stack = newStack;
        }
    }

    @Override
    public String toString() {
        var contents = Arrays.copyOfRange(stack, 0, count);

        return Arrays.toString(contents);
    }
}
