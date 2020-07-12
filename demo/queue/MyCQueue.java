package queue;

public class MyCQueue<T> {
    Object[] eleDate;
    int capacity;
    int front;
    int rear;

    MyCQueue() {
        this.capacity = 4;
        this.eleDate = new Object[this.capacity + 1];
        this.front = this.rear = 0;
    }

    Boolean isFull() {    
        if ((this.rear + 1) % (this.capacity + 1) == this.front) {
            return true;
        } else {
            return false;
        }
    }

    Boolean isEmpty() {
        return this.front == this.rear;
    }
 
    Boolean enQueue(T date) {
        if (isFull()) {
            return false;
        } else {
            this.eleDate[this.rear] = date;
            this.rear = (this.rear + 1) % (this.capacity + 1);
            return true;
        }
    }
    
    T deQueue() {
        T date = null;
        if (!isEmpty()) {
            date = (T) this.eleDate[this.front];
            this.front = (this.front + 1) % (this.capacity + 1);
        }
        return date;
    }

    public static void main(String[] args) {
        MyCQueue<Integer> q = new MyCQueue<>();
        q.enQueue(11);
        q.enQueue(22);
        q.enQueue(33);
        q.enQueue(44);
        q.enQueue(55);

       System.out.println(q.deQueue());
       System.out.println(q.deQueue());
       System.out.println(q.deQueue());
       System.out.println(q.deQueue());
       System.out.println(q.deQueue());

    }
}
