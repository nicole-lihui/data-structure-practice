package stack;

/**
 * MyArrayStack
 */
public class MyArrayStack<T> {
    Object[] eleDate;
    int top;
    int capacity;

    MyArrayStack() {
        this.capacity = 4;
        this.top = 0;
        this.eleDate = new Object[this.capacity];
    }

    Boolean isFull() {
        return this.capacity == this.top;
    }

    Boolean isEmpty() {
        return this.top == 0;
    }

    Boolean push(T date) {
        if (isFull()) {
            return false;
        } else {
            this.eleDate[top++] = date;
            return true;
        }
    }

    T pop() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) this.eleDate[--this.top];
        }
    }

    T top() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) this.eleDate[this.top - 1];
        }
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> myASatck = new MyArrayStack<>();
        myASatck.push(11);
        myASatck.push(22);
        myASatck.push(33);

        System.out.println(myASatck.top());
        System.out.println(myASatck.pop());
        System.out.println(myASatck.pop());
        System.out.println(myASatck.pop());
    }
}
