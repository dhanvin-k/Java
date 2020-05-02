package com.company.BinaryTree;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node="+ value;
        }
    }

    private Node root;
    private Node current;
    private int count = 0;

    public void insert (int value) {
        var node = new Node(value);
        
        if (root == null) {
            root = current = node;
            count = 1;
            return;
        }

        var current = root;
        while (true) {
            if (value<current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

        current = node;
        count++;
    }
}
