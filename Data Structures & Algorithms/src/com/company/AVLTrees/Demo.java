package com.company.AVLTrees;

public class Demo {
    public static void show() {
        var tree = new AVLTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println("done");
    }
}
