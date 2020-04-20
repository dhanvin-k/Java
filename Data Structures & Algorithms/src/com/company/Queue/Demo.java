package com.company.Queue;

public class Demo {
    public static void show() {
        var queue = new PriortyQueue(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(4);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}
