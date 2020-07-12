package set;

import java.util.Set;
import java.util.TreeSet;

/**
 * DemoSet
 */
public class DemoSet {

    public static void main(String[] args) {
        //TreeSet, HashSet
        Set<Integer> s = new TreeSet<>();
        s.add(11);
        s.add(222);
        s.add(3333);

        Set<Integer> s2 = new TreeSet<>();
        s2.add(11);
        s2.add(-100);
        s.addAll(s2);
        System.out.println(s);

    }
}
