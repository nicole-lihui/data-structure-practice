package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Stu implements Comparable<Stu>{
    public String name;
    public int score;
    public Stu(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "[ " + name + ", " + score + " ]";
    }

	@Override
	public int compareTo(Stu o) {
		// TODO Auto-generated method stub
		return this.score - o.score;
	}
}

/**
 * DemoSort
 */
public class DemoSort {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(11, 222, 3, 44, 555, -666, 100, 0, 999, 123, 1));
        System.out.println(a);
        // Collections.sort(a);
        Collections.sort(a, (x, y) -> y - x);
        System.out.println(a);
        a.sort((x, y) -> x - y);
        System.out.println(a);

        ArrayList<Stu> sa = new ArrayList<>();
        sa.add(new Stu("Li", 90));
        sa.add(new Stu("AA", 80));
        sa.add(new Stu("BB", 60));
        sa.add(new Stu("KKH", 97));
        System.out.println(sa);

        Collections.sort(sa, (x, y) -> x.name.compareTo(y.name));
        System.out.println(sa);
        Collections.sort(sa);
        System.out.println(sa);
    }
}
