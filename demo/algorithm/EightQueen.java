package algorithm;

/**
 * EightQueen
 */
public class EightQueen {
    private int n = 8;
    private int[] queens;
    private int count;

    EightQueen() {
        n = 8;
        queens = new int[n];
    }

    public Boolean canPlace(int k, int i) {
        for (int j = 0; j < k; j++) {
            if (queens[j] == i || queens[j] - i == j - k || queens[j] - i == k - j) {
                return false;
            }
        }
        return true;
    }

    public void place(int k) {
        if (k == n) {
            count++;
            System.out.print(count + " : [");
            for (int i : queens) {
                System.out.print(i + ", ");
            }
            System.out.println(" ]");
        } else {
            for (int i = 0; i < n; i++) {
                if (canPlace(k, i)) {
                    queens[k] = i;
                    place(k + 1);
                }
            }
        }
    }

    public void find() {
        place(0);
    }

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.find();
    }
}
