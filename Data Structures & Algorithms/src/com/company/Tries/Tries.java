package com.company.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        public boolean isEndOfWord() {return isEndOfWord; }

        public void removeWord() { isEndOfWord = false; }

        public Node[] getChildren() { return children.values().toArray(new Node[0]); }

        public int numberOfChildren() { return children.size(); }

        public boolean hasChildren() { return !children.isEmpty(); }

        public void removeChar(char ch) { children.remove(ch); }

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

    public List<String> autoComplete(String prefix) {
        List<String> words = new ArrayList<>();

        autoComplete(findLastNodeOf(prefix), prefix, words);

        return words;
    }

    private void autoComplete(Node root, String prefix, List<String> words) {
        if (root == null)
            return;

        if (root.isEndOfWord())
            words.add(prefix);

        for (var child:root.getChildren())
            autoComplete(child, prefix+child.value, words);
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null)
            return null;

        var current = root;
        for (var ch:prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
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

    public void remove(String word) {
        if (word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.removeWord();
            return;
        }

        var ch = word.toCharArray()[index];
        var child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, ++index);

        if (!child.isEndOfWord() && !child.hasChildren()) {
            root.removeChar(ch);
            return;
        }
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
