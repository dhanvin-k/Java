package com.company.HashTables;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private class keyValue {
        private int key;
        private String value;

        public keyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }

    private LinkedList<keyValue>[] entries;

    public HashTable(int capacity) {
        this.entries = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new keyValue(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<keyValue> getOrCreateBucket(int key) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    private keyValue getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<keyValue> getBucket(int key) { return entries[hash(key)]; }

    private int hash(int key) { return key % entries.length; }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}
