package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySequentialQueue<T> implements Iterable<T>, Iterator<T>{

    private Object[] eleData;
    private int capacity;
    private int incCapacity;
    private int front;
    private int rear;
    private int index;

    MySequentialQueue() {
        incCapacity = capacity = 4;
        eleData = new Object[capacity + 1];
        front = rear = 0;
    }

    private Boolean isFull() {
        return (rear + 1) % (capacity + 1) == front;
    }

    private Boolean isEmpty() {
        return front == rear;
    }

    public int length() {
        return (rear % (capacity + 1)) - (front % (capacity + 1));
    }

    private void capacityData() {
        int len = capacity + incCapacity;
        Object[] tmp = new Object[len];
        for (int i = 0; i < eleData.length; i++) {
            tmp[i] = eleData[i];
        }
        eleData = tmp;
        capacity = len;
    }

    public void enQueue(T data) {
        if (!isFull()) {
            eleData[rear] = data;
            rear = (rear + 1) % (capacity + 1);
        } else {
            capacityData();
            eleData[rear] = data;
            rear = (rear + 1) % (capacity + 1);
        }
    }

    public T deQueue() {
        T data = null;
        if (!isEmpty()) {
            data = (T) eleData[front];
            front = (front + 1) % (capacity + 1);
        }

        return data;
    }

    @Override
    public boolean hasNext() {
        
        return index % (capacity + 1) != rear;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T data = (T) eleData[index];
            index = (index + 1) % (capacity + 1);
            return data;
        }
        throw new NoSuchElementException("No Such Elem");
    }

    @Override
    public Iterator<T> iterator() {
        index = front;
        return this;
    }
    
    public static void main(String[] args) {
        MySequentialQueue<Integer> q = new MySequentialQueue<>();
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
