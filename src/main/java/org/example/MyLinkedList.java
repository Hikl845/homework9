package org.example;

public class MyLinkedList {

    public static class Node{
    Object value;
    Node next;
    Node prev;
    Node(Object value){
        this.value = value;
    }
}
private Node head;
private Node tail;
private int size = 0;
public void add(Object value){
    Node newNode = new Node(value);
    if(head == null){
        head = tail = newNode;
    }
    else{
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }
    size++;
}
    private void checkIndex(int index) {
        if (index < 0 || index >= setSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + setSize);
        }
    }
public String get(int index){
checkIndex(index);
return getNode(index).value.toString();
}
public void remove(int index){
    checkIndex(index);
    Node toRemove = getNode(index);

    if (toRemove.prev != null) {
        toRemove.prev.next = toRemove.next;
    } else {
        head = toRemove.next;
    }

    if (toRemove.next != null) {
        toRemove.next.prev = toRemove.prev;
    } else {
        tail = toRemove.prev;
    }

    size--;
}
    public int size(){
        return size;
    }
    public void clear(){
    head = null;
    tail = null;
    size = 0;
    }
    private Node getNode(int index) {
        Node current;
        if (index < setSize / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = setSize - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
