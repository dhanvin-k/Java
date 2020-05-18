package com.company.Heaps;

import java.util.Arrays;

public class Demo {
    public static void show() {
        var heap = new MinHeap(2);
        heap.insert(7, "A");
        heap.insert(4, "B");
        heap.insert(3, "C");
        heap.insert(9, "D");
        heap.insert(6, "E");
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);
    }
}
