package com.company.Heaps;

import java.util.Arrays;

public class Demo {
    public static void show() {
        var queue = new MinPriorityQueue(2);
        queue.add(7, "A");
        queue.add(4, "B");
        queue.add(3, "C");
        queue.add(9, "D");
        queue.add(6, "E");
        System.out.println(queue);
    }
}
