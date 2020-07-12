package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedQueue<T> implements Iterable<T>, Iterator<T>{

    private class Node {
        T data;
        Node next;

        Node() {
            data = null;
            next = null;
        }

        Node(T d) {
            data = d;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;
    private Node pNode;

    MyLinkedQueue() {
        front = rear = new Node();
        size = 0;
    }

    public int length() {
        return size;
    }

    public Boolean isEmpty() {
        return front == rear;
    }
    
    public void enQueue(T data) {
        rear.data = data;
        size++;
        rear.next = new Node();
        rear = rear.next;
    }

    public T front() {
        return front.data;
    }

    public T deQueue() {
        T data = null;

        if (!isEmpty()) {
            data = front.data;
            front = front.next;
            size--;
        }

        return data;
    }


    @Override
    public boolean hasNext() {
        return !pNode.equals(rear);
    }

    @Override
    public T next() {
        if (hasNext() && pNode.data != null) {
            T data = pNode.data;
            pNode = pNode.next;
            return data;
        }
        throw new NoSuchElementException("Not Such Element!");
    }

    @Override
    public Iterator<T> iterator() {
        pNode = front;
        return this;
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> q = new MyLinkedQueue<>();
        for (int i = 1; i < 7; i++) {
            q.enQueue(i * 11);
        }

        q.forEach(e -> System.out.println(e));

        for (int i = 0; i < 5; i++) {
            System.out.println(q.length());
            System.out.println(q.deQueue());
        }
    }


}
