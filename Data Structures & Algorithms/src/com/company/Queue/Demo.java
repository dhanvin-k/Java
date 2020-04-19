package com.company.Queue;

public class Demo {
    public static void show() {
        var queue = new StackQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(40);

        var front = queue.dequeue();
        System.out.println(front);
    }
}
