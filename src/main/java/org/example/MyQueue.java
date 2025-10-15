package org.example;

public class MyQueue {

    private static class Node{
    Object value;
    Node next;
    Node(Object value){
        this.value = value;
    }
}

private Node head;
private Node tail;
private int setSize = 0;
public void add(Object value){
    Node newNode = new Node(value);
    if(tail == null){
        head=tail=newNode;
    }
    else{
        tail.next = newNode;
        tail = newNode;
    }
    setSize++;
}
public int size(){
    return setSize;
}
public void clear(){
    head = null;
    tail = null;
    setSize = 0;
}
public Object peek(){
    if(head ==null){
        return null;
    }
    return head.value;
}
    public Object poll() {
        if (head == null) return null;
        Object result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        setSize--;
        return result;
    }
}
