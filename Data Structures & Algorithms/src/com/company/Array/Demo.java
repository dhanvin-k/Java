package com.company.Array;

public class Demo {
    public static void show() {
        var numbers = new Array(3);

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.print();

        System.out.println("\n");
        numbers.reverse().print();
    }
}
