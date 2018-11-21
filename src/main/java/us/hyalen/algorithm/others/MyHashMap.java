package us.hyalen.algorithm.others;

import org.springframework.stereotype.Component;

@Component
public class MyHashMap <K, V> {
    private class Entry <K, V> {
        K key;
        V value;
        Entry next;

        public Entry() {}

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private Entry<K, V>[] table = (Entry<K, V>[]) new Entry[SIZE];

    public void put(K key, V value) {
        int hash = key.hashCode() % SIZE;
        Entry entry = table[hash];

        if (entry == null)
            table[hash] =  new Entry(key, value);
        else {
            while (entry.next != null) {
                if (entry.key == key)
                    break;

                entry = entry.next;
            }

            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new Entry(key, value);
        }
    }

    public V get(K key) {
        int hash = key.hashCode() % SIZE;
        Entry entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key))
                return (V) entry.value;

            entry = entry.next;
        }

        return null;
    }

    public boolean containsKey(K key) {
        int hash = key.hashCode() % SIZE;
        Entry entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key))
                return true;

            entry = entry.next;
        }

        return false;
    }
}