package tree;

import java.util.Stack;

/**
 * MyLinkBT
 */
public class MyLinkBT<T> {
    class BinNode {
        T date;
        BinNode left;
        BinNode right;
        int h;

        BinNode(T x) {
            date = x;
            left = right = null;
            h = 0;
        }
    }

    BinNode root;

    MyLinkBT() {
        root = null;
    }

    MyLinkBT(T date) {
        root = new BinNode(date);
    }

    BinNode rFindNode(T x, BinNode r) {
        if (r == null)
            return null;
        if (r.date == x)
            return r;
        BinNode found = null;
        found = rFindNode(x, r.left);
        return found != null ? found : rFindNode(x, r.right);
    }

    BinNode findNode(T x) {
        return rFindNode(x, root);
    }

    Boolean insert(T p, int lOrR, T x) {
        BinNode found = findNode(p);
        if (found == null)
            return false;
        if (lOrR == 0) {
            if (found.left != null)
                return false;
            found.left = new BinNode(x);
        } else {
            if (found.right != null)
                return false;
            found.right = new BinNode(x);
        }
        return true;
    }

    void rPrePrint(BinNode r) {
        if (r == null)
            return;
        System.out.print(r.date + " ");
        rPrePrint(r.left);
        rPrePrint(r.right);
    }

    void rPrint(BinNode r, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("  ");
        if (r == null) {
            System.out.println("[/]");
        } else {
            System.out.println(r.date + "  ");
            rPrint(r.left, depth + 1);
            rPrint(r.right, depth + 1);
        }
    }

    void rInPrint(BinNode r) {
        if (r == null)
            return;
        rInPrint(r.left);
        System.out.print(r.date + "  ");
        rInPrint(r.right);
    }

    void rLastPrint(BinNode r) {
        if (r == null)
            return;
        rInPrint(r.left);
        rInPrint(r.right);
        System.out.print(r.date + "  ");
    }

    void iPrePrint(BinNode r) {
        Stack<BinNode> st = new Stack<>();
        if (r == null)
            return;
        while (r != null) {
            System.out.print(r.date + "  ");
            st.push(r);
            r = r.left;
            while (r == null && !st.empty()) {
                r = st.pop();
                r = r.right;
            }
        }
    }

    void iInPrePrint(BinNode r) {
        Stack<BinNode> st = new Stack<>();
        if (r == null)
            return;
        while (r != null) {
            st.push(r);
            r = r.left;
            while (r == null && !st.empty()) {
                r = st.pop();
                System.out.print(r.date + "  ");
                r = r.right;
            }
        }
    }

    void iLastPrint(BinNode r) {
        Stack<BinNode> st = new Stack<>();
        if (r == null)
            return;
        st.push(r);
        BinNode pre = r;
        BinNode curr;
        while (!st.isEmpty()) {
            curr = st.peek();
            if (curr.left != null && pre != curr.left && pre != curr.right) {
                st.push(curr.left);
            } else if (curr.right != null && pre != curr.right) {
                st.push(curr.right);
            } else {
                System.out.print(curr.date + "  ");
                pre = curr;
                st.pop();
            }
        }
    }

    void lastPrint() {
        iLastPrint(root);
        System.out.println();

        rLastPrint(root);
        System.out.println();
    }

    void prePrint() {
        // rPrePrint(root);
        iPrePrint(root);
        System.out.println();

    }

    void print() {
        rPrint(root, 0);
    }

    void inPrint() {
        rInPrint(root);
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkBT<Integer> bt = new MyLinkBT<>(11);
        bt.insert(11, 0, 22);
        bt.insert(11, 1, 33);
        bt.insert(22, 0, 44);

        bt.prePrint();
        bt.print();
        bt.inPrint();
        bt.lastPrint();
    }
}
