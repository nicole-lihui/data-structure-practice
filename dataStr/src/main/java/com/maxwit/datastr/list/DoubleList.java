package com.maxwit.datastr.list;

public class DoubleList<T> {
    private class Node<T> {
        public Node<T> pre;
        public Node<T> next;
        public T data;

        public Node() {
            this.pre = null;
            this.next = null;
            this.data = null;
        }

        public Node(Node<T> pre, T data, Node<T> next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> header;
    public int length;

    public DoubleList() {
        this.header = new Node<T>(null, null, null);
        this.length = 0;
    }

    public DoubleList(T data) {
        this.header = new Node<T>(null, data, null);
        this.length = 0;
    }

    public void add(T data) {
        Node<T> tmp = this.header;
        if (tmp.data == null){
            tmp.data = data;
            return;
        }

        while (tmp.next != null) {
            tmp = tmp.next;
        }
        Node<T> node = new Node<>(tmp, data, null);
        tmp.next = node;
        this.length ++;
    }

    public void display(){
        Node tmp = header;
        int index = 0;
        while (tmp.next != null) {
            System.out.println(index + " : " + tmp.data);
            tmp = tmp.next;
            index++;
        }
        System.out.println(index + " : " + tmp.data);
    }

}
