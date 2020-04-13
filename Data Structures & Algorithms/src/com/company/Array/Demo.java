package com.company.Array;

public class Demo {
    public static void show() {
        var numbers = new Array(3);

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);

        numbers.removeAt(1);

        numbers.insertAt(50, 3);

        numbers.print();

        System.out.println("\n" + numbers.indexOf(20));

        System.out.println("\n" + numbers.max() + "\n");

        numbers.reverse().print();
    }
}
