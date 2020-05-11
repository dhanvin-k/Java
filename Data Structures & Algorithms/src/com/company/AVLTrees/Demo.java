package com.company.AVLTrees;

public class Demo {
    public static void show() {
        var tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(15);

        System.out.println(tree.isBalance());
        System.out.println("done");
    }
}
