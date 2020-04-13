package com.company.Array;

public class Demo {
    public static void show() {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(1);
        System.out.println(numbers.indexOf(20));
        numbers.print();
    }
}
