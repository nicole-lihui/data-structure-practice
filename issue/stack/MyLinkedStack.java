package stack;

public class MyLinkedStack<T> {
    
    private Node top;
    private int size;
    
    class Node {
        T data;
        Node next;

        Node() {
            data = null;
            next = null;
        }

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    MyLinkedStack() {
        top = new Node();
        size = 0;
    }

    private Boolean isEmpty() {
        return top.data == null;
    }

    public int length() {
        return size;
    }
    
    public void push(T data) {
        if (isEmpty()) {
            top.data = data;
        } else {
            Node tmp = new Node(data);
            tmp.next = top;
            top = tmp;
        }

        size++;
    }

    public T pop() {
        T data = null;
        if (!isEmpty()) {
           data = top.data;
           top = top.next;
        }

        if (data == null)
            size--;

        return data;
    }

    public T top() {
        T data = null;
        if (!isEmpty()) {
            data = top.data;
        }

        return data;
    }


    public static void main(String[] args) {
        MyLinkedStack<Integer> myLStack = new MyLinkedStack<>();
        myLStack.push(11);
        myLStack.push(22);
        myLStack.push(33);

        System.out.println(myLStack.top());
        System.out.println("Length: " + myLStack.length());
        System.out.println(myLStack.pop());
        System.out.println(myLStack.pop());
        System.out.println(myLStack.pop());
    }
}
