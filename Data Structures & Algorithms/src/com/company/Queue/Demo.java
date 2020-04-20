package com.company.Queue;

import java.util.ArrayDeque;

public class Demo {
    public static void show() {
        var queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
