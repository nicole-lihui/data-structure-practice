package tree;

/**
 * MyAVLT
 */
public class MyAVLT<T extends Integer> extends MyBST<T> {
    BinNode root;

    protected int height(BinNode r) {
        if (r == null)
            return -1;
        return r.h;
    }

    MyAVLT() {
        this.root = null;
    }

    protected BinNode lLrotate(BinNode r) {
        BinNode child;
        child = r.left;
        r.left = child.right;
        child.right = r;
        r.h = max(height(r.left), height(r.right)) + 1;
        child.h = max(height(child.left), height(child.right)) + 1;
        return child;
    }

    protected BinNode rRrotate(BinNode r) {
        BinNode child;
        child = r.right;
        r.right = child.left;
        child.left = r;
        r.h = max(height(r.left), height(r.right)) + 1;
        child.h = max(height(child.left), height(child.right)) + 1;
        return child;
    }

    protected BinNode lRrotate(BinNode r) {
        r.left = rRrotate(r.left);
        return lLrotate(r);
    }

    protected BinNode rLrotate(BinNode r) {
        r.right = lLrotate(r.right);
        return rRrotate(r);
    }

    protected BinNode rInsert(T x, BinNode r) throws Exception {
        if (r == null) {
            r = new BinNode(x);
            if (r == null)
                throw new Exception("-1");
        } else if (x < r.date) {
            r.left = rInsert(x, r.left);
            if (height(r.left) - height(r.right) == 2) {
                if (x < r.left.date) {
                    r = lLrotate(r);
                } else {
                    r = lRrotate(r);
                }
            }
        } else if (x > r.date) {
            r.right = rInsert(x, r.right);
            if (height(r.right) - height(r.left) == 2) {
                if (x > r.right.date) {
                    r = rRrotate(r);
                } else {
                    r = rLrotate(r);
                }
            }
        } else {
            throw new Exception("-2");
        }

        r.h = max(height(r.left), height(r.right)) + 1;
        return r;
    }

    Boolean insert(T p, int lOrR, T x) {
        return false;
    }

    int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        MyAVLT<Integer> t = new MyAVLT<>();
        // t.insert(30);
        // t.insert(20);
        // t.print();
        // System.out.println("---------");
        // t.insert(10);
        // t.print();

        t.insert(50);
        t.insert(30);
        t.insert(60);
        t.insert(20);
        t.insert(35);
        t.print();
        System.out.println("---------");
        t.insert(33);
        t.print();
    }
}
