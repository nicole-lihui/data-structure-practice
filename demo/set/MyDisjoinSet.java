package set;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * MyDisjoinSet
 */
public class MyDisjoinSet<T> {
    Integer[] parent;
    Object[] date;
    int capacity;
    int size;
    Map<Object, Integer> m;

    MyDisjoinSet(int max) {
        this.capacity = 10;
        this.size = 0;
        this.parent = new Integer[max + 1];
        this.date = new Object[max + 1];
        this.m = new HashMap<>();
    }

    Boolean insert(T x) {
        if (this.size == this.capacity) {
            return false;
        }
        size++;
        this.date[size] = x;
        parent[size] = -1;
        m.put(x, size);

        return true;
    }

    void print() {
        for (int i = 1; i <= size; i++)
            System.out.print(i + "\t");
        System.out.println();
        for (int i = 1; i <= size; i++)
            System.out.print(this.parent[i] + "\t");
        System.out.println();
        for (int i = 1; i <= size; i++)
            System.out.print(this.date[i] + "\t");
        System.out.println();
    }

    Integer find(T x) {
        Integer i, rt;
        i = rt = m.get(x);
        if (rt != null) {
            while (this.parent[rt] > 0) {
                rt = this.parent[rt];
            }
            Integer tmp;
            for (; i != rt; i = tmp) {
                tmp = this.parent[i];
                this.parent[i] = rt;
            }
        }
        return rt;
    }

    void unionSet(T x, T y) {
        Integer rx, ry;
        rx = find(x);
        ry = find(y);
        if (rx == null || ry == null)
            return;
        if (rx == ry)
            return;
        if (this.parent[rx] < this.parent[ry]) {
            this.parent[rx] += this.parent[ry];
            this.parent[ry] = rx;
        } else {
            this.parent[ry] += this.parent[rx];
            this.parent[rx] = ry;
        }
    }

    public static void main(String[] args) {
        MyDisjoinSet<Integer> s = new MyDisjoinSet<>(10);
        s.insert(11);
        s.insert(22);
        s.insert(66);
        s.insert(-5);
        s.insert(123);
        s.unionSet(11, 66);
        s.unionSet(11, 22);
        s.unionSet(123, -5);
        // s.unionSet(66, -5);

        System.out.println(s.find(-5));
        s.print();
    }

}
