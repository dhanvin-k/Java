package com.company.HashTables;

public class Demo {
    public static void show() {
        var hashTable = new HashTable(5);
        hashTable.put(1, "Dhanvin");
        hashTable.put(6, "Devdhar");
        hashTable.put(267, "Daivat");
        hashTable.put(23, "Mohit");
        hashTable.put(5, "Rohan");
        System.out.println(hashTable);
    }
}
