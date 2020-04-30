package com.company.HashTables;

import java.util.Arrays;
import java.util.IllformedLocaleException;

public class HashMap {
    public class keyValue {
        private int key;
        private String value;

        public keyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private keyValue[] entries;
    private int count;

    public HashMap(int capacity) {
        this.entries = new keyValue[capacity];
        this.count = 0;
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        if (isFull())
            throw new IllegalStateException();

        var index = getIndex(key);
        entries[index] = new keyValue(key, value);
        count++;
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public void remove(int key) {
        var index = getIndex(key);
        if (index == -1 || entries[index] == null)
            return;

        entries[index] = null;
        count--;
    }

    private keyValue getEntry(int key) {
        var index = getIndex(key);
        return index==-1 ? null : entries[index];
    }

    private int getIndex(int key) {
        for (int i = hash(key); i < hash(key) + getSize(); i++) {
            var index = i;
            if (index >= getSize())
                index = i % getSize();
            if (entries[index] == null || entries[index].key == key)
                return index;
        }
        return -1;
    }

    private boolean isFull() { return count == getSize(); }

    private int hash(int key) { return key % entries.length; }

    private int getSize() { return entries.length; }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}