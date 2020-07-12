package heap_priortyqueue;

/**
 * MyHeap
 */
public class MyHeap {

    int date[];
    int capacity;
    int size;
    boolean maxOrMin;

    MyHeap(int max) {
        this.date = new int[max + 1];
        this.capacity = max;
        this.size = 0;
    }

    MyHeap(int[] list, int size, int max, boolean isMax) {
        this.date = new int[max + 1];
        this.capacity = max;
        this.size = size;
        this.maxOrMin = isMax;

        for (int i = 1; i <= size; i++)
            this.date[i] = list[i - 1];
        for (int i = size / 2; i > 0; i--) {
            if (maxOrMin)
                precolateDown(i);
            else 
                precolateDownMax(i);

            // printHeap();
        }
    }

    void printHeap() {
        for (int i = 1; i <= this.size; i++) {
            System.out.print(this.date[i] + " ");
        }
        System.out.println();
    }

    Boolean isFull() {
        return this.capacity == this.size;
    }

    Boolean isEmpty() {
        return this.size == 0;
    }

    void percalateUp(int k) {
        int x = this.date[k];
        int i = k;
        while (i > 1 && x < this.date[i / 2]) {
            this.date[i] = this.date[i / 2];
            i /= 2;
        }
        this.date[i] = x;
    }

    void precolateDown(int k) {
        int x = this.date[k];
        int i, child;
        for (i = k; i * 2 <= size; i = child) {
            child = i * 2;
            if (child != this.size && this.date[child] > this.date[child + 1])
                child++;
            if (this.date[i] > this.date[child])
                this.date[i] = this.date[child];
            else 
                break;
        }
        this.date[i] = x;
    }

    void precolateDownMax(int k) {
        int x = this.date[k];
        int i, child;
        for (i = k; i * 2 <= size; i = child) {
            child = i * 2;
            if (child != this.size && this.date[child] < this.date[child + 1])
                child++;
            if (this.date[i] < this.date[child])
                this.date[i] = this.date[child];
            else 
                break;
        }
        this.date[i] = x;
    }

    Boolean insertHeap(int x) {
        if (isFull())
            return false;
        this.date[++this.size] = x;
        percalateUp(this.size);
        return true;
    }

    Integer removeHeap() {
        if (isEmpty())
            return null;
        int x = this.date[1];
        this.date[1] = this.date[this.size--];
        if (maxOrMin)
            precolateDown(1);
        else 
            precolateDownMax(1);

        return x;
    }

    public static void main(String[] args) {
        // MyHeap h = new MyHeap(10);
        // h.insertHeap(20);
        // h.insertHeap(10);
        // h.insertHeap(5);
        // h.insertHeap(15);
        // h.insertHeap(30);
        // h.insertHeap(18);

        // h.printHeap();
        // Integer x;
        // x = h.removeHeap();
        // h.printHeap();
        /*
            10
        50      60
      5    30 20
            5
        10     20
      50    30 60
        */

        int[] a = { 10, 50, 60, 5, 30, 20};
        MyHeap h = new MyHeap(a, 6, 50, false);
        h.printHeap();

        for (int i = 0; i < a.length; i++) {
            System.out.print(h.removeHeap() + "  ");
        }
    }
}
