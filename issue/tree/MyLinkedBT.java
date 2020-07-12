package tree;

import java.util.Stack;

public class MyLinkedBT<T> {
    
    private class Node {
        T data;
        Node left;
        Node right;

        Node(T value) {
            data = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    // MyLinkedBT() {
    //     root = new Node();
    // }

    MyLinkedBT(T data) {
        root = new Node(data);
    }

    private Node rFindNode(Node r, T data) {
        if (r == null)
            return null;
        if (r.data.equals(data))
            return r;

        Node found = rFindNode(r.left, data);
        return found != null ? found : rFindNode(r.right, data);
    }

    private Node findNode(T data) {
        Node node = rFindNode(root, data);
        return node;
    }

    public Boolean insert(T parentData, int lOrR, T data) {
        Node pNode = findNode(parentData);
        if (pNode == null)
            return false;
        if (lOrR == 0) {
            if (pNode.left != null)
                return false;
            pNode.left = new Node(data);
        } else {
            if (pNode.right != null)
                return false;
            pNode.right = new Node(data);
        }

        return true;
    }

    private void rPreTraversal(Node r) {
        if (r == null)
            return;
        System.out.print(r.data + " ");
        rPreTraversal(r.left);
        rPreTraversal(r.right);
    } 

    public void preTraversal() {
        rPreTraversal(root);
        System.out.println();
    }

    private void rInTraversal(Node r) {
        if (r == null)
            return;
        rInTraversal(r.left);
        System.out.print(r.data + " ");
        rInTraversal(r.right);
    }

    public void inTraversal() {
        rInTraversal(root);
        System.out.println();
    }

    private void rLastTraversal(Node r) {
        if (r == null)
            return;
        rLastTraversal(r.left);
        rLastTraversal(r.right);
        System.out.print(r.data + " ");
    }

    public void lastTraversal() {
        rLastTraversal(root);
        System.out.println();
    }

    private void rPreTraversalNR(Node r) {
        Stack<Node> st = new Stack<>();
        if (r == null)
            return;
        while (r != null) {
            System.out.print(r.data + " ");
            st.push(r);
            r = r.left;
            while (r == null && !st.empty()) {
                r = st.pop();
                r = r.right;                
            }
        }
    }

    public void preTraversalNR() {
        rPreTraversalNR(root);
        System.out.println();
    }

    private void rInTraversalNR(Node r) {
        Stack<Node> st = new Stack<>();
        if (r == null)
            return;
        while (r != null) {
            st.push(r);
            r = r.left;
            while (r == null && !st.empty()) {
                r = st.pop();
                System.out.print(r.data + " ");
                r = r.right;
            }
        }
    }

    private void rLastTraversalNR(Node r) {
        Stack<Node> st = new Stack<>();
        st.push(r);
        Node pre = r;
        Node cur;
        while (!st.empty()) {
            cur = st.peek();
            if (cur.left != null && pre != cur.left && pre != cur.right) {
                st.push(cur.left);
            } else if (cur.right != null && pre != cur.right) {
                st.push(cur.right);
            } else {
                System.out.print(cur.data + " ");
                st.pop();
                pre = cur;
            }
        }
    }

    public void lastTraversalNR() {
        rLastTraversalNR(root);
        System.out.println();
    }

    public void inTraversalNR() {
        rInTraversalNR(root);
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedBT<Integer> bt = new MyLinkedBT<>(11);
        bt.insert(11, 0, 22);
        bt.insert(11, 1, 33);
        bt.insert(22, 0, 44);

        bt.preTraversal();
        bt.preTraversalNR();

        bt.inTraversal();
        bt.inTraversalNR();

        bt.lastTraversal();
        bt.lastTraversalNR();
    }

}
