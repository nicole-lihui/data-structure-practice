package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Graph {
    protected Integer nv;
    protected Boolean directed;
    protected Vector<String> vertices;
    protected Map<String, Integer> iov;

    Graph() {
        directed = false;
        nv = 0;
    }

    Graph(Boolean dir) {
        directed = dir;
        nv = 0;
    }

    Graph(Vector<String> v, boolean dir) {
        directed = dir;
        nv = v.size();
        vertices = v;
        iov = new HashMap<>();
        for (int i = 0; i < nv; i++) {
            iov.put(v.get(i), i);
        }
    }

    Graph(Integer n, Boolean dir) {
        directed = dir;
        nv = n;
        vertices.setSize(n);
        for (int i = 0; i < n; i++) {
            vertices.add(Integer.toString(i));
            iov.put(Integer.toString(i), i);
        }
    }

    public void test() {
        for (Object string : vertices) {
            System.out.print(string + ", ");
        }
        System.out.println();
        iov.forEach((k, v) -> System.out.print(k + " -> " + v));
    }
}

class MGraph extends Graph {
    protected ArrayList[] adjM;

    MGraph() {
        super();
        setAdjM();
    }

    MGraph(Boolean dir) {
        super(dir);
        setAdjM();
    }
    MGraph(Vector<String> v, boolean dir) {
        super(v, dir);
        setAdjM();
    }

    MGraph(Integer n, Boolean dir) {
        super(n, dir);
        setAdjM();
    }

    protected void setAdjM() {
        adjM = new ArrayList[nv];
        for (int i = 0; i < nv; i++) {
            adjM[i] = new ArrayList<Integer>(nv);
            for (int j = 0; j < nv; j++) {
                adjM[i].set(j, null);
            }
        }
    }
}

/**
 * Graph
 */
public class GraphDemo {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Arrays.asList("AA", "BB", "CC", "DD", "EE"));
        Graph g = new Graph(v, false);
        // g.test();
        g = new Graph();

    }
}
