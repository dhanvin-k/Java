package com.company.Heaps;

import java.util.Arrays;

public class Demo {
    public static void show() {
        var numbers = new int[] {5, 3, 8, 4, 1, 2};
        Heapify.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
