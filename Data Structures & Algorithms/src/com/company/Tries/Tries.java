package com.company.Tries;

import java.util.Arrays;
import java.util.HashMap;

public class Tries {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) { return children.containsKey(ch); }

        public void addChild(char ch) { children.put(ch, new Node(ch)); }

        public Node getChild(char ch) { return children.get(ch); }

        public void endWord() { isEndOfWord = true; }

        public Node[] getChildren() { return children.values().toArray(new Node[0]); }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root;

    public Tries() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;

        for (var ch: word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }

        current.endWord();
    }

    public boolean contains(String word) {
        return word != null && contains(root, word, 0);
    }

    private boolean contains(Node root, String word, int index) {
        if (index == word.length())
            return root.isEndOfWord;

        var ch = word.toCharArray()[index];
        return root.hasChild(ch) && contains(root.getChild(ch), word, ++index);
    }

    public void traversal(String type) {
        if (type.toLowerCase() == "preorder")
            traversalPreOrder(root);
        else
            traversalPostOrder(root);
    }

    private void traversalPreOrder(Node root) {
        System.out.println(root.value);

        for (var child : root.getChildren())
            traversalPreOrder(child);
    }

    private void traversalPostOrder(Node root) {
        for (var child : root.getChildren())
            traversalPostOrder(child);

        System.out.println(root.value);
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
