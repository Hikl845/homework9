package org.example;

public class MyStack {
private static class Node{
    Object value;
    Node next;

    Node(Object value){
        this.value = value;
    }
}

private Node top = null;
private int size = 0;

public void push(Object value){
    Node newNode = new Node(value);
    newNode.next = (Node) value;
    top = newNode;
    size++;
}

public void clear(){
    top = null;
    size = 0;
}

public int size(){
    return size;
}

public Object peek(){
    if(top == null) return null;
    return top.value;
}

    public Object pop() {
        if (top == null) return null;
        Object result = top.value;
        top = top.next;
        size--;
        return result;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            pop();
            return;
        }

        Node current = top;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }
}
