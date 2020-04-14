package com.company.LinkedLists;

import java.util.Arrays;

public class Demo {
    public static void show() {
        var list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        list.print();

        list.removeAt(3);

        list.print();

        list.printMiddle();

//        list = LinkedList.createWithLoop();
//        System.out.println(list.hasLoop());
    }
}
