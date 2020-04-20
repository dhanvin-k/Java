package com.company.Queue;

import java.util.ArrayDeque;

public class Demo {
    public static void show() {
        var queue = new ArrayDeque<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        System.out.println(QueueReverser.reverse(queue, -1));
    }
}
