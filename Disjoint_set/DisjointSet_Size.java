package Disjoint_set;

import java.util.*;

public class DisjointSet_Size {
    List<Integer> parent = new LinkedList<>();
    List<Integer> size = new LinkedList<>();

    public DisjointSet_Size(int n) {
        for (int i = 0; i <= n; ++i) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node))
            return node;

        int ulti_P = findUltimateParent(parent.get(node));
        parent.set(node, ulti_P);
        return ulti_P;
    }

    public void unionBySize(int u, int v) {

        int ulti_u = findUltimateParent(u);
        int ulti_v = findUltimateParent(v);

        if (ulti_u == ulti_v)
            return;

        if (size.get(ulti_u) < size.get(ulti_v)) {
            parent.set(ulti_u, ulti_v);
            size.set(ulti_v, size.get(ulti_v) + size.get(ulti_u));
        } else {
            /**
             * because we are working with size so here don't need to explicitly handle the
             * case where both size are equal because ultimately we are adding instead of
             * increasing the rank just like we are doing it with union by rank.
             */

            parent.set(ulti_v, ulti_u);
            size.set(ulti_u, size.get(ulti_v) + size.get(ulti_u));
        }
    }

}

class Main {
    public static void main(String[] args) {

        DisjointSet_Size ds = new DisjointSet_Size(7);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

}
