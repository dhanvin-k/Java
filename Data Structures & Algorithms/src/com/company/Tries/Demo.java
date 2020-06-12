package com.company.Tries;

public class Demo {
    public static void show() {
        var trie = new Tries();

        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");

        System.out.println(trie.autoComplete("car"));


        System.out.println("Done");
    }
}
