package queue;

/**
 * MyLinkQueue
 */
public class MyLinkQueue<T> {

    class Node {
        T date;
        Node next;

        Node(T x) {
            date = x;
            next = null;
        }
    }

    Node front;
    Node rear;

    MyLinkQueue() {
        front = rear = null;
    }

    Boolean isEmpty() {
        return front == null;
    }

    void enQueue(T date) {
        Node t = new Node(date);
        if (isEmpty()) {
            front = rear = t;
        } else {
            rear.next = t;
            rear = t;
        }
    }

    T deQueue() {
        T date = null;
        if (!isEmpty()) {
            date = front.date;
            front = front.next;
            if (front == null)
                rear = null;
        }
        return date;
    }

    public static void main(String[] args) {
        MyLinkQueue<Integer> q = new MyLinkQueue<>();
        q.enQueue(11);
        q.enQueue(22);
        q.enQueue(33);
        q.enQueue(44);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());

    }
}
