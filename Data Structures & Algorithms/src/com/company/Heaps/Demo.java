package com.company.Heaps;

public class Demo {
    public static void show() {
        var heap = new Heaps(2);

        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        System.out.println(heap);

        System.out.println(heap.remove());
        System.out.println(heap);
    }
}
