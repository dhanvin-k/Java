package com.company.AVLTrees;

import com.company.BinaryTrees.BinarySearchTree;

public class AVLTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = insert(root.rightChild, value);
        else throw new IllegalStateException();

        return root;
    }

    private boolean isLeaf(AVLTree.Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
