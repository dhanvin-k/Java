package com.company.Stacks;

import java.util.Stack;

public class StringReverser {
    public static String reverser(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (char ch:input.toCharArray())
            stack.push(ch);

        StringBuffer output = new StringBuffer();
        while (!stack.isEmpty())
            output.append(stack.pop());
        return output.toString();
    }
}
