package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHeadLinkList<T> implements Iterable<T>, Iterator<T> {

    private Node head;
    private int size;
    private Node pNode;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            data = null;
            next = null;
        }
    }

    MyHeadLinkList() {
        head = new Node();
        size = 0;
    }

    MyHeadLinkList(T data) {
        head = new Node();
        head.next = new Node(data);
        size = 1;
    }

    public Boolean insert(T data) {
        if (head.next == null) {
            head.next = new Node(data);
        } else {
            Node tmp = new Node(data);
            tmp.next = head.next;
            head.next = tmp;
        }

        size++;

        return false;
    }

    public Boolean insert(int index, T data) {
        if (index < 0)
            return false;

        Node pNode = head;
        int i = 0;
        for (; i <= index && pNode.next != null; i++) {
            if (i == index) {
                Node next = pNode.next;
                pNode.next = new Node(data);
                pNode.next.next = next;

                size++;
                return true;
            }
            pNode = pNode.next;
        }

        if (index == i) {
            pNode.next = new Node(data);
            size++;
            return true;
        }

        return false;
    }

    public T delete() {
        if (size <= 0)
            return null;

        T data = head.next.data;
        if (head.next.next == null)
            head.next = null;
        else
            head.next = head.next.next;

        size--;

        return data;
    }

    private Node findK(int k) {
        Node pNode = head;
        int i = 0;
        while (pNode.next != null && i <= k) {
            pNode = pNode.next;
            i++;
        }

        return pNode;
    }

    public T delete(int k) {
        if (size > 0 && k < 0 || k >= size)
            return null;

        T data = null;
        Node kNode = null;
        if (k == 0) {
            kNode = head;
        } else {
            kNode = findK(k - 1);
        }

        if (kNode != null && kNode.next != null) {
            data = kNode.next.data;
            kNode.next = kNode.next.next;
            size--;
        }

        return data;
    }

    @Override
    public Iterator<T> iterator() {
        pNode = head.next;
        return this;
    }

    @Override
    public boolean hasNext() {
        return pNode != null && (pNode.next != null || pNode.data != null);
    }

    @Override
    public T next() {
        if (hasNext()) {
            T data = pNode.data;
            pNode = pNode.next;
            return data;
        } else if (pNode.data != null && pNode.next == null) {
            return pNode.data;
        }
        throw new NoSuchElementException("No Such ElementException");
    }

    public static void main(String[] args) {
        MyHeadLinkList<Integer> mylinst = new MyHeadLinkList<>();
        mylinst.insert(11);
        mylinst.insert(22);
        mylinst.insert(33);
        mylinst.insert(44);
        mylinst.insert(4, 55);
        mylinst.forEach(e -> System.out.println(e));
        System.out.println("--------------");

        mylinst.delete();
        mylinst.forEach(e -> System.out.println(e));
        System.out.println("--------------");

        mylinst.delete(0);
        mylinst.forEach(e -> System.out.println(e));
        System.out.println("--------------");
    }
}
