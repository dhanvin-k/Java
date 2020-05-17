package com.company.Heaps;

public class Heapify {
    public static void heapify(int[] array) {
        var indexOfLastParent = array.length/2 - 1;
        for (int i = indexOfLastParent; i>=0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        System.out.println("hello");
        int largerChildIndex = index;
        if (!isValidParent(array, index))
            largerChildIndex = getLargerChildIndex(array, index);

        if (largerChildIndex == index)
            return;

        swap(array, index, largerChildIndex);
        heapify(array, largerChildIndex);
    }

    private static void swap(int[] array, int parentIndex, int childIndex) {
        var temp = array[parentIndex];
        array[parentIndex] = array[childIndex];
        array[childIndex] = temp;
    }

    private static int getLargerChildIndex(int[] array, int index) {
        if (!hasLeftChild(array, index))
            return index;

        if (!hasRightChild(array, index))
            return leftChildIndex(index);

        return (array[leftChildIndex(index)] > array[rightChildIndex(index)])
                                                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private static boolean isValidParent(int[] array, int index) {
        if (!hasLeftChild(array, index))
            return true;

        var isValid = array[index] >= array[leftChildIndex(index)];
        if (hasRightChild(array, index))
            isValid &= array[index] >= array[rightChildIndex(index)];
        return isValid;
    }

    private static boolean hasRightChild(int[] array, int index) { return rightChildIndex(index) < array.length; }

    private static boolean hasLeftChild(int[] array, int index) { return leftChildIndex(index) < array.length; }

    private static int leftChildIndex(int index) { return 2*index+1; }

    private static int rightChildIndex(int index) { return 2*index+2; }
}
