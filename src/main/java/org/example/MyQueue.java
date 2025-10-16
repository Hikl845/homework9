package org.example;

public class MyQueue <T>{

    private static class Node <T>{
    T value;
    Node<T> next;
    Node(T value){
        this.value = value;
    }
}

private Node<T> head;
private Node<T> tail;
private int setSize = 0;
public void add(T value){
    Node<T> newNode = new Node<>(value);
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
public T peek(){
    if(head ==null){
        return null;
    }
    return head.value;
}
    public T poll() {
        if (head == null) return null;
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        setSize--;
        return result;
    }
}
