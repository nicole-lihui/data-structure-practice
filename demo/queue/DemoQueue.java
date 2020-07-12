package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * DemoQueue
 */
public class DemoQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(22);

        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
