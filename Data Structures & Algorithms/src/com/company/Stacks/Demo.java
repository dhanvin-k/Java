package com.company.Stacks;

import java.util.Arrays;

public class Demo {
    public static void show() {
        var stack = new Stack(5);
        stack.push(4);
        stack.push(9);
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.pop();
        System.out.println(stack.getMinInStack());
    }
}
