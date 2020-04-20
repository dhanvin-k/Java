package com.company.Queue;

public class Demo {
    public static void show() {
        var queue = new StackWithTwoQueues();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        queue.pop();
        var top = queue.pop();
        System.out.println(queue);
        System.out.println(queue.isEmpty());
    }
}
