package com.company.HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class charFinder {
    public static char findFirstNonRepeatedChar(String input) {
        Map<Character, Integer> map = new HashMap<>();

        var stringArray = input.toCharArray();
        for (char ch : stringArray) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : stringArray)
            if (map.get(ch) == 1)
                return ch;

        return Character.MAX_VALUE;
    }

    public static char findFirstRepeatedChar(String input) {
        Set<Character> set = new HashSet<Character>();

        var stringArray = input.toCharArray();
        for (char ch : stringArray){
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
