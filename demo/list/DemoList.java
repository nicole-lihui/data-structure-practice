package list;

import java.util.ArrayList;

/**
 * ListDemo
 */
public class DemoList {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(11);
        a.add(22);
        a.add(33);
        a.add(1, 6666);
        System.out.println(a);
        int k = a.remove(2);
        System.out.println(k);
        System.out.println(a);
        
    }
}
