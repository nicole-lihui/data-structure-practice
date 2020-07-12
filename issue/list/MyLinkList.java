package list;

import java.util.function.Consumer;


public class MyLinkList<T>{
    private Node node;
    private int size;

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

    MyLinkList() {
        node = new Node();
        size = 0;
    }

    MyLinkList(T data) {
        node = new Node(data);
        size = 0;
    }

    public Boolean add(T data) {
        if (node.data == null) {
            node.data = data;
        } else {
            Node tmp = new Node(data);
            tmp.next = node;
            node = tmp;
        }

        ++size;
        return true;
    }

    public T delete() {
        if (node.data == null) {
            return null;
        } else {
            T data = node.data;
            if (node.next != null) {
                node = node.next;
            } else {
                node.data = null;
            }
            --size;

            return data;
        }
    }

    private Node findK(int k) {
        Node p = node;
        int i = 0;
        while (p.next != null && i < k) {
            p = p.next;
            i++;
        }

        return p;
    }

    public T delete(int k) {
        T data = null;
        if (k >= size || k < 0)
            return null;
            
        if (k == 0 && node.data != null) {
            data = node.data;
            if (node.next != null) {
                node = node.next;
            } else {
                node.data = null;
            }
            size--;
        } else {
            Node kNode = findK(k - 1);
            if (kNode != null && kNode.next != null) {
                data = kNode.next.data;
                kNode.next = kNode.next.next;
                size--;
            }
        }
        
        return data;
    }

    public void traversal(Consumer<T> visit) {
        Node pNode = node;
        for (; pNode != null; pNode = pNode.next) {
            visit.accept(pNode.data);
        }
    }

    public static void main(String[] args) {
        MyLinkList<Integer> mylinst = new MyLinkList<>();
        mylinst.add(11);
        mylinst.add(22);
        mylinst.add(33);
        mylinst.add(44);
        mylinst.traversal(e -> System.out.println(e + " "));
        System.out.println("--------------");

        mylinst.delete();
        mylinst.traversal(e -> System.out.println(e + " "));
        System.out.println("--------------");

        mylinst.delete(0);
        mylinst.traversal(e -> System.out.println(e + " "));
        System.out.println("--------------");
    }

}
