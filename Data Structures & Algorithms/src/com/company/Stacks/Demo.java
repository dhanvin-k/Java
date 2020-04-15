package com.company.Stacks;

import java.util.Stack;

public class Demo {
    public static void show() {
        System.out.println(StringReverser.reverser("abcd"));

        System.out.println("(1+1): " + BalancedStringChecker.isBalanced("(1+1)"));
        System.out.println("(1+1)): " + BalancedStringChecker.isBalanced("(1+1))"));
        System.out.println("([{<1> + <1>}]): " + BalancedStringChecker.isBalanced("([{<1> + <1>}])"));
        System.out.println("(1+1)]): " + BalancedStringChecker.isBalanced("(1+1)])"));
        System.out.println("((([1+1): " + BalancedStringChecker.isBalanced("((([1+1)"));
        System.out.println("(1+1) [1+1]: " + BalancedStringChecker.isBalanced("(1+1) [1+1]"));
    }
}
