package com.company.BinaryTrees;

public class Demo {
    public static void show() {
        var tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.isPerfect());
        System.out.println("Done");
    }
}
