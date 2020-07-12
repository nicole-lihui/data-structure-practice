package heap_priortyqueue;

import java.util.PriorityQueue;

/**
 * DemoPriortyQueue
 */
public class DemoPriortyQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(111);
        q.add(222);
        q.add(333);
        q.add(11);
        q.add(22);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        // PriorityQueue<Integer> q1 = new PriorityQueue<>(10, new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         // TODO Auto-generated method stub
        //         return o2 - o1;
        //     }

        // });
        PriorityQueue<Integer> q1 = new PriorityQueue<>(10, (a, b) -> {
            return b - a;
        });

        q1.add(111);
        q1.add(222);
        q1.add(333);
        q1.add(11);
        q1.add(22);
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());

    }
}
