package com.company.Heaps;

public class Demo {
    public static void show() {
        var heap = new Heaps(2);

        heap.insert(100);
        heap.insert(90);
        heap.insert(80);
        heap.insert(40);
        heap.insert(120);
        heap.insert(60);
        heap.insert(70);

        System.out.println(heap);
    }
}
