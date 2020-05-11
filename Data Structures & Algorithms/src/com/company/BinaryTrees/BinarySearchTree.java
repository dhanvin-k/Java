package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
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

    public void insert (int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
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
    }

    public boolean find (int value) {
        var current = root;
        while (current != null) {
            if (value<current.value)
                current = current.leftChild;
            else if (value>current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public List<Integer> getAncestors(int value) {
        var ancestors = new ArrayList<Integer>();
        getAncestors(root, value, ancestors);

        return ancestors;
    }

    private boolean getAncestors(Node root, int value, List<Integer> ancestors) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        if (getAncestors(root.leftChild, value, ancestors) || getAncestors(root.rightChild, value, ancestors)) {
            ancestors.add(root.value);
            return true;
        }

        return false;
    }

    public boolean sibling(int first, int second) {
        return sibling(root, first, second);
    }

    private boolean sibling(Node root, int first, int second) {
        if (root == null)
            return false;

        var areSibling = false;
        if (root.leftChild != null && root.rightChild != null)
            areSibling = (root.leftChild.value == first && root.rightChild.value == second) ||
                            (root.leftChild.value == second && root.rightChild.value == first);

        return areSibling || sibling(root.leftChild, first, second) ||
                                sibling(root.rightChild, first, second);
    }

    public boolean contains(int value) {
        if (root == null)
            return false;

        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root.value == value)
            return true;

        if (isLeaf(root))
            return false;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public void levelOrderTraversal() {
        for (int i = 0; i<=height(); i++) {
            for (var value : getNodesAtKDistance(i))
                System.out.println(value);
        }
    }

    public ArrayList<Integer> getNodesAtKDistance(int k) {
        var list = new ArrayList<Integer>();
        getNodesAtKDistance(root, k, list);
        return list;
    }

    private void getNodesAtKDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtKDistance(root.leftChild, distance-1, list);
        getNodesAtKDistance(root.rightChild, distance-1, list);
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isSearchTree() {
        return isSearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isSearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (min<root.value && root.value<max)
            return isSearchTree(root.leftChild, min, root.value) &&
                    isSearchTree(root.rightChild, root.value, max);

        return false;
    }

    public boolean equals(BinarySearchTree tree) {
        if (tree == null)
            return false;

        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                                                && equals(first.rightChild, second.rightChild);

        return false;
    }

    public int maximumOfBinarySearchTree() {
        if (root == null)
            throw new IllegalStateException();

        return maximumOfBinarySearchTree(root);
    }

    private int maximumOfBinarySearchTree(Node root) {
        if (root.rightChild == null)
            return root.value;

        return maximumOfBinarySearchTree(root.rightChild);
    }

    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.leftChild == null && root.rightChild == null)
            return root.value;

        var minChild = Math.max(max(root.leftChild), max(root.rightChild));
        return Math.max(minChild, root.value);
    }

    public int minimumOfBinarySearchTree() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current!=null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public int min() {
        if (min(root) == Integer.MAX_VALUE)
            throw new IllegalStateException();

        return min(root);
    }

    private int min(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        if (isLeaf(root))
            return root.value;

        var minChild = Math.min(min(root.leftChild), min(root.rightChild));
        return Math.min(minChild, root.value);
    }

    public boolean isPerfect() { return size() == Math.pow(2, height(root) + 1) - 1; }

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

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node Root) {
        if (root == null)
            return;

        traversePreOrder(root.leftChild);
        System.out.println(root.value);
        traversePreOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node Root) {
        if (root == null)
            return;

        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
        System.out.println(root.value);
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
