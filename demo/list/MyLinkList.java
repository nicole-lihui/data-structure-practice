package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyLinkList
 */
public class MyLinkList<T> implements Iterable<T>, Iterator<T> {
    class Node {
        T date;
        Node next;

        Node(T date) {
            this.date = date;
            this.next = null;
        }
    }

    Node head;
    Node index;

    MyLinkList() {
        this.head = null;
        this.index = head;
    }

    Node createNode(T date) {
        return new Node(date);
    }
    
    // void add(int m, T date) {
    //     Node t = createNode(date);
    //     if (m == 1) {
    //         if (this.head == null) {
    //             this.head = t;
    //         } else {
    //             Node p = head;
    //             head = t;
    //             t.next = p;
    //         }
    //     }
    // }

    void add(T date) {
        if (this.head == null) {
            this.head = createNode(date);
        } else {
            Node t = createNode(date);
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = t;
        }
    }

    Node findKth(int k) {
        Node p = this.head;
        int count = 0;
        while (p.next != null && count < k - 2) {
            p = p.next;
            count++;
        }
        if (count < k - 2) {
            p = null;
        }

        return p;
    }

    void remove(int k) {
        Node kNode = null;
        if (k > 0) {
            kNode = findKth(k);
        }
       if (kNode != null) {
            if (k == 1) {
                head = head.next;
            } else {
                Node p = null;
                if (kNode.next != null) {
                    p = kNode.next;
                    if (p.next != null) {
                        kNode.next = p.next;
                    } else {
                        kNode.next = null;
                    }
                } 
            }
       }
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if (index != null && (index.next != null || index.date != null)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        // TODO Auto-generated method stub
        if (hasNext()) {
            T date = index.date;
            index = index.next;
            return date;
        } else if (index.date != null && index.next == null) {
            return index.date;
        }
        throw new NoSuchElementException("No Such ElementException");
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        index = head;
        return this;
    }

    public static void main(String[] args) {
        MyLinkList<Integer> mylinst = new MyLinkList<>();
        mylinst.add(11);
        mylinst.add(22);
        mylinst.add(33);
        mylinst.add(44);
        // mylinst.add(1, 55);
        mylinst.forEach((e) -> {
            System.out.println(e);
        });
        System.out.println("--------------");

        mylinst.remove(4);
        mylinst.forEach((e) -> {
            System.out.println(e);
        });
    }
}
