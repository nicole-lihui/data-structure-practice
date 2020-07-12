package tree;

/**
 * MyBST
 */
public class MyBST<T extends Integer> extends MyLinkBT<T> {

    MyBST() {
        this.root = null;
    }

    protected BinNode rFindMax(BinNode r) {
        if (r.right == null)
            return r;
        return rFindMax(r.right);
    }

    BinNode findMax() {
        // return rFindMax(this.root);
        BinNode t = this.root;
        while (t != null && t.right != null) {
            t = t.right;
        }
        return t;
    }

    BinNode findMin() {
        BinNode t = this.root;
        while (t != null && t.left != null) {
            t = t.left;
        }
        return t;
    }

    BinNode findX(T x) {
        BinNode t = this.root;
        while (t != null && x != t.date) {
            if (x < t.date)
                t = t.left;
            else
                t = t.right;
        }
        return t;
    }

    protected BinNode rInsert(T x, BinNode r) throws Exception {
        if (r == null) {
            r = new BinNode(x);
            if (r == null)
                throw new Exception("-1");
        } else if (x < r.date) {
            r.left = rInsert(x, r.left);
        } else if (x > r.date) {
            r.right = rInsert(x, r.right);
        } else {
            throw new Exception("-2");
        }
        return r;
    }

    Boolean insert(T x) {
        try {
            this.root = rInsert(x, this.root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected BinNode rRemove(T x, BinNode r) throws Exception {
        BinNode t;
        if (r == null) {
            throw new Exception("-1");
        } else if (x < r.date) {
            r.left = rRemove(x, r.left);
        } else if (x > r.date) {
            r.right = rRemove(x, r.right);
        } else {
            if (r.left != null && r.right != null) {
                t = rFindMax(r.left);
                r.date = t.date;
                r.left = rRemove(t.date, r.left);
            } else {
                t = r;
                r = r.left != null ? r.left : r.right;
            }
        }

        return r;
    }

    Boolean remove(T x) {
        try {
            this.root = rRemove(x, this.root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyBST<Integer> bt = new MyBST<>();
        bt.insert(10);
        bt.insert(5);
        bt.insert(20);
        bt.insert(8);
        bt.insert(15);
        bt.insert(2);
        bt.insert(6);

        bt.print();
        System.out.println("-------------");

        bt.remove(10);
        bt.print();
        System.out.println(bt.findMax().date);
        System.out.println(bt.findMin().date);
    }
}
