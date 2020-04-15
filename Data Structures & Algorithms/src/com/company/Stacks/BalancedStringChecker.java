package com.company.Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedStringChecker {

    private static final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private static final List<Character> rightBracket = Arrays.asList(')', '}', ']', '>');

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch:input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();
                if (!bracketMatch(top, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private static boolean isRightBracket(char ch) {
        return rightBracket.contains(ch);
    }

    private static boolean bracketMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBracket.indexOf(right);
    }
}
