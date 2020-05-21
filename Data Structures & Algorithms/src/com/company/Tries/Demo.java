package com.company.Tries;

public class Demo {
    public static void show() {
        var trie = new Tries();

        trie.insert("cat");
        trie.insert("can");
        System.out.println(trie.contains("canada"));

        System.out.println("Done");
    }
}
