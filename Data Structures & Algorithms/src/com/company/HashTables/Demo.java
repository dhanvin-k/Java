package com.company.HashTables;

import java.util.Arrays;

public class Demo {
    public static void show() {
//        System.out.println(HashTableExercises.mostFrequent(new int[] {1, 2, 2, 3, 3, 3, 4}));
//        System.out.println(HashTableExercises.countPairWithDiff(new int[] {1, 7, 5, 9, 2, 12, 3}, 2));
//        System.out.println(Arrays.toString(HashTableExercises.twoSum(new int[] {2, 7, 11, 15}, 9)));

        var map = new HashMap(5);
        map.put(1, "a");
        map.put(3, "b");
        map.put(4, "c");
        map.put(8, "d");
        map.put(13, "e");
        map.remove(8);
        System.out.println(map);
        System.out.println(map.get(13));
    }
}
