package org.example;

import java.util.HashMap;

public class MyHashMap {
private static class Node{
    Object key;
    Object value;
    Node next;
    Node(Object key, Object value){
        this.value = value;
        this.key = key;
    }
}
    private final static int INITIAL_CAPACITY = 16;
    private Node[] buckets;
    private int size;

    public MyHashMap(){
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);
        Node current = buckets[index];

        // Перевіряємо, чи вже існує ключ
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // оновлюємо значення
                return;
            }
            current = current.next;
        }

        // Додаємо нову ноду на початок списку
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public Object get(Object key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // ключ не знайдено
    }

    public boolean remove(Object key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // ключ не знайдено
    }

    public void clear(){
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }
    public int size(){
        return size;
    }
}
