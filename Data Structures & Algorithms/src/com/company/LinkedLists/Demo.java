package com.company.LinkedLists;

public class Demo {
    public static void show() {
        var list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.addFirst(5);

        list.removeFirst();

        list.removeLast();

        list.print();

        System.out.println(list.indexOf(20));

        System.out.println(list.contains(30));
    }
}
