package com.company.Tries;

public class Demo {
    public static void show() {
        var trie = new Tries();

        trie.insert("care");
        trie.traversal("preorder");
        System.out.println("Done");
    }
}
