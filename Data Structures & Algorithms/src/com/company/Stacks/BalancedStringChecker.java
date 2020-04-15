package com.company.Stacks;

import java.util.Stack;

public class BalancedStringChecker {
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch:input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[' || ch == '<')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']' || ch == '>') {

                if (stack.isEmpty())
                    return false;

                char opening = stack.pop();
                if ( !( (opening == '(' && ch == ')') || (opening == '{' && ch == '}') ||
                        (opening == '[' && ch == ']') || (opening == '<' && ch == '>') ) )
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
