package queue;

public class ChineseTrangle {
    
    public static void main(String[] args) {
        int n = 8;

        MyLinkedQueue<Integer> q = new MyLinkedQueue<>();
        
        q.enQueue(0);
        q.enQueue(1);

        int i = 0;
        while (i <= 8) {
            int x = q.deQueue();
            int y = q.front();

            if (x == 0) {
                i++;
                q.enQueue(0);
            }

            q.enQueue(x + y);
            if (x == 0) {
                System.out.println();
                for (int j = 0; j < 2 * (n - i); j++) {
                    System.out.print(" ");
                }
            } else {
                System.out.print(x + "   "); 
            }
        }

        // 0 1  ->0 
        // 1 0 1 ->1       

        // 0 1 1 ->0   
        // 1 1 0 1->1   
        // 1 0 1 2 ->1

        // 0 1 2 1 -> 0
        // 1 2 1 0 1 -> 1
        // 2 1 0 1 3 -> 2
        // 1 0 1 3 3 -> 1

        // 0 1 3 3 1 -> 0
        // 1 3 3 1 0 1 -> 1
        // 3 3 1 0 1 4 -> 3
        // 3 1 0 1 4 6 -> 3
        // 1 0 1 4 6 4 -> 1

    }
}
