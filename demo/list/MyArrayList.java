package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyArrayList
 */
public class MyArrayList<T> implements Iterable<T>, Iterator<T> {
    Object[] eleDate;
    int size;
    int capacity;
    int incrCapacity = 4;
    int index = 0;

    public MyArrayList() {
        capacity = 4;
        eleDate = new Object[capacity];
        size = 0;
    }

    public void add(int m, T date) {
        if (m == 1) {
            if (this.size == this.capacity) {
                // pass
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    eleDate[i + 1] = eleDate[i];
                }
                eleDate[0] = date;
                size++;
            }
        }
    }

    public void add(T date) {
        if (this.size == this.capacity) {
            // pass
        } else {
            eleDate[size] = date;
            this.size++;
        }
    }

    public T delete(int index) {
        if (index < 0 || index > this.size) {
            throw new Error("Invail index");
        } else {
            index = index - 1;
            T date = (T) eleDate[index];
            if (index >= 0 && index < this.size) {
                if (index != this.size) {
                    for (int i = index; i < this.size - 1; i++) {
                        eleDate[i] = eleDate[i + 1];
                    }
                }
            }
            this.size--;
            return date;
        }
    }

    @Override
    public boolean hasNext() {
        return index < this.size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return (T) eleDate[index++];
        }
        throw new NoSuchElementException("only " + eleDate.length + " elements");
    }

    @Override
    public Iterator<T> iterator() {
        index = 0;
        return this;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> al = new MyArrayList<>();
        al.add(11);
        al.add(22);
        al.add(33);
        al.add(1, 55);
        al.forEach((e) -> {
            System.out.println(e);
        });
        System.out.println("----------");
        al.delete(1);
        al.forEach((e) -> {
            System.out.println(e);
        });
    }
}
