package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySequentialList implements Iterable<Integer>, Iterator<Integer> {
    private int[] eleData;
    private int size;
    private int capacity;
    private int incrCapacity;

    private int index;

    MySequentialList() {
        size = 0;
        capacity = 4;
        incrCapacity = 4;
        eleData = new int[capacity];
    }

    private void capacityData() {
        int len = capacity + incrCapacity;
        int[] tmp = new int[len];
        for (int i = 0; i < eleData.length; i++) {
            tmp[i] = eleData[i];
        }
        eleData = tmp;
        capacity = len;
    }

    private Boolean isCapacity() {
        if (size + 1 > capacity) {
            return true;
        }

        return false;
    }

    public int length() {
        return size + 1;
    }

    public void add(int data) {
        if (isCapacity())
            capacityData();

        eleData[size++] = data;
    }

    public void add(int index, int data) {
        if (index > size || index < 0)
            return;
        
        if (isCapacity())
            capacityData();
        
        for (int i = size; i >= index; i--) {
            eleData[i + 1] = eleData[i];
        }
        eleData[index] = data;
    }

    public void delete() {
        --size;
    }

    public Boolean delete(int index) {
        if (index > size || index < 0)
            return false;

        for (int i = index; i < size; i++)
            eleData[i] = eleData[i + 1];
        --size;
        return true;
    }

    @Override
    public boolean hasNext() {
        return index <= size;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return eleData[index++];
        }
        throw new NoSuchElementException("only " + size + " elements");
    }

    @Override
    public Iterator<Integer> iterator() {
        index = 0;
        return this;
    }

    
    public static void main(String[] args) {
        MySequentialList sl = new MySequentialList();
        sl.add(11);
        sl.add(22);
        sl.add(33);
        sl.add(44);
        sl.add(2, 55);
        sl.forEach(e -> System.out.println(e));
        System.out.println("size----: " + sl.length());


        sl.delete();
        sl.forEach(e -> System.out.println(e));
        System.out.println("size----: " + sl.length());


        sl.delete(2);
        sl.forEach(e -> System.out.println(e));
        System.out.println("size----: " + sl.length());
    }
}
