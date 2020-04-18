package com.company.Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversingQueue {
    public static Queue<Integer> reversed(Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        Queue<Integer> output = new ArrayDeque<>();
        while (!stack.isEmpty())
            output.add(stack.pop());

        return output;
    }

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        return queue;
    }
}
