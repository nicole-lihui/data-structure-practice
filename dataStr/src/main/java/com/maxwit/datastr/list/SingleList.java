package com.maxwit.datastr.list;

public class SingleList<T> {

    private class Node<T> {
        public Node<T> next = null;
        public T data;

        public Node (T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    private Node<T> header = null;
    public int length;

    public SingleList() {
        this.length = 0;
        this.header = new Node<T>(null);
    }

    public SingleList(T data) {
        this.length = 0;
        this.header = new Node<T>(data);
    }

    public void add(T data) {
        Node<T> node = new Node(data);
        if (this.header.data == null) {
            this.header = node;
            return;
        }

        Node<T> tmp = header;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        this.length += 1;
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
