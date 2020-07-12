package algorithm;

import java.util.PriorityQueue;
import java.util.Vector;

/**
 * HaffmanTree
 */
public class HuffmanTree implements Comparable<HuffmanTree>{

    protected class Node {
        int date;
        Node left;
        Node right;

        Node() {
            left = right = null;
        }

        Node(int date) {
            left = right = null;
            this.date = date;
        }
    }

    protected Node root;

    HuffmanTree() {
        root = null;
    }

    HuffmanTree(int weight) {
        root = new Node(weight);
    }
//----NO FORK ---BUG
    HuffmanTree(Vector<HuffmanTree> nodes) {
        PriorityQueue<HuffmanTree> q = new PriorityQueue<>();
        q.addAll(nodes);
        HuffmanTree tmp = new HuffmanTree();
        //the queue have a bug ,and then get a error result
        for (int i = 1; i < nodes.size(); i++) {
            tmp.root = new Node();
            tmp.root.left = q.peek().root;
            q.poll();
            tmp.root.right = q.peek().root;
            q.poll();
            System.out.println(tmp.root.left.date + " ----- " + tmp.root.right.date);
            tmp.root.date = tmp.root.left.date + tmp.root.right.date;
            System.out.println(tmp.root.date);
            q.add(tmp);
        }
        root = q.peek().root;
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return this.root.date - o.root.date;
    }

    void print() {
        rPrint(root, 0);
    }

    void rPrint(Node r, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        if (r == null) {
            System.out.println("[/]");
        } else {
            System.out.println(r.date);
            rPrint(r.left, depth+1);
            rPrint(r.right, depth+1);
        }
    }
    
    public static void main(String[] args) {
        int nv;
        int[] weights = {10, 15, 12, 3, 4, 13, 1};
        nv = 7;
        Vector<HuffmanTree> nodes = new Vector<>();
        for (int i = 0; i < nv; i++) {
            nodes.add(new HuffmanTree(weights[i]));
        }
        HuffmanTree ht = new HuffmanTree(nodes);
        ht.print();
    }
}
