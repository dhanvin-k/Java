package com.company.Stacks;

import java.util.Arrays;

public class TwoStack {
    private int[] array;
    private int top1;
    private int top2;

    public TwoStack(int capacity) {
        this.array = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public void push1(int item) {
        if (isFull1())
            throw new StackOverflowError();

        array[++top1] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return array[top1--];
    }

    public boolean isEmpty1() { return top1 == -1; }
    public boolean isFull1() { return top1 + 1 == top2; }
    public int getStack1Size() { return top1+1; }

    public void push2(int item) {
        if (isFull2())
            throw new StackOverflowError();

        array[--top2] = item;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return array[top2++];
    }

    public boolean isEmpty2() { return top2 == array.length; }
    public boolean isFull2() { return top2 - 1 == top1; }
    public int getStack2Size() { return 10 - top2; }

    public void print() {
        var stack1 = Arrays.copyOfRange(array, 0, top1+1);
        var stack2 = Arrays.copyOfRange(array, top2, array.length);

        System.out.println( "\narray:     " + Arrays.toString(array) );
        System.out.println( "stack1:    " + Arrays.toString(stack1) );
        System.out.println( "stack2:    " + Arrays.toString(stack2) );

    }
}
