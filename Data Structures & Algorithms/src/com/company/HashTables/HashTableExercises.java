package com.company.HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {
    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int max = -1;
        int maxKey = Integer.MIN_VALUE;
        for (var number:numbers) {
            var count = hashMap.getOrDefault(number,0);//hashMap.containsKey(number) ? hashMap.get(number) : 0;
            hashMap.put(number, count + 1);
            if (count>max) {
                max = count;
                maxKey = number;
            }
        }
        return maxKey;
    }

    public static String mostFrequentWord(String sentence) {
        Map<String, Integer> hashMap = new HashMap<>();
        var output = new String();
        var buffer = new StringBuffer();
        int max = -1;
        for (var ch : sentence.toCharArray()) {
            if (ch == ' ' || ch == '.') {
                var word = buffer.toString();
                int count = hashMap.getOrDefault(word,0);
                hashMap.put(word.toLowerCase(), count + 1);
                buffer.delete(0, buffer.length());
                if (count>max) {
                    max = count;
                    output = word;
                }
            }
            else
                buffer.append(ch);
        }
        return output;
    }

    public static int countPairWithDiff(int[] numbers, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (var number:numbers) {
            set.add(number);
            if (set.contains(number-k))
                count++;
            if (set.contains(number+k))
                count++;
        }
        return count;
    }
}