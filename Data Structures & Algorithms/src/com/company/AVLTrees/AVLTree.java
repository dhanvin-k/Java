package com.company.AVLTrees;

public class AVLTree {
    private class Node {
        private int value;
        private int height;
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

        setHeight(root);

        return balanceTree(root);
    }

    private Node balanceTree(Node root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.rightChild) < 0)
                root.leftChild = leftRotation(root.leftChild);
            return rightRotation(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rightRotation(root.rightChild);
            return leftRotation(root);
        }
        return root;
    }

    private Node leftRotation(Node root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rightRotation(Node root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node root) {
        if (root == null)
            return true;

        return !(isLeftHeavy(root) || isRightHeavy(root)) && isBalance(root.leftChild) && isBalance(root.rightChild);
    }

    private boolean isLeftHeavy(Node root) { return balanceFactor(root) > 1; }

    private boolean isRightHeavy(Node root) { return balanceFactor(root) < -1; }

    private int balanceFactor(Node root) { return (root == null) ? 0 : height(root.leftChild) - height(root.rightChild); }

    private void setHeight(Node root) { root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild)); }

    private int height(Node root) { return (root == null) ? -1 : root.height; }

    private boolean isLeaf(AVLTree.Node root) { return root.leftChild == null && root.rightChild == null; }
}
