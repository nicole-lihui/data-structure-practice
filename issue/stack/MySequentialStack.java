package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySequentialStack<T> implements Iterable<T>, Iterator<T>{
    Object[] eleData;
    int top;
    int capacity;
    int incCapacity;
    int index;


    MySequentialStack() {
        capacity = incCapacity = 4;
        eleData = new Object[capacity];
        top = 0;
    }

    private Boolean isFull() {
        return capacity == top;
    }

    private Boolean isEmpty() {
        return top == 0;
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

    public int length() {
        return top;
    }

    public void push(T data) {
        if (isFull()) {
            capacityData();
        }

        eleData[top++] = data;
    }

    public T pop() {
        if (isEmpty())
            return null;
        return (T) eleData[--top];
    }

    public T top() {
        if (isEmpty())
            return null;
        return (T) eleData[top - 1];
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return (T) eleData[index--];
        }
        throw new NoSuchElementException("only " + top + " elements");
    }

    @Override
    public Iterator<T> iterator() {
        index = top - 1;
        return this;
    }

    public static void main(String[] args) {
        MySequentialStack<Integer> myASatck = new MySequentialStack<>();
        myASatck.push(11);
        myASatck.push(22);
        myASatck.push(33);
        myASatck.push(33);
        myASatck.push(33);

        myASatck.forEach(e -> System.out.println(e));
        System.out.println("--------------");

        System.out.println(myASatck.top());
        System.out.println("Length: " + myASatck.length());
        System.out.println(myASatck.pop());
        System.out.println(myASatck.pop());
        System.out.println(myASatck.pop());
    }
}
