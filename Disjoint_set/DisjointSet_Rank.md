```java
package Disjoint_set;
import java.util.*;

public class Disjoint_set {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    // Constructor
    public Disjoint_set(int n) {
        // we are using <=n its because sometime it maybe 0 indexed
        // and sometime 1 indexed and this <=n will handle both the cases.

        for (int i = 0; i <= n; ++i) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUltimateParent(int node) {

        // base case
        if (node == parent.get(node)) {
            return node;
        }

        int ulti_P = findUltimateParent(parent.get(node));
        parent.set(node, ulti_P); // this is path compression
        // check striver's video for better explanation and for implementation
        // go to timestamps 27:54 of video

        return ulti_P; // or parent.get(node) same thing
    }

    public void unionByRank(int u, int v) {

        int ulti_u = findUltimateParent(u);
        int ulti_v = findUltimateParent(v);

        // this case means they both already part of the same component
        // or better we can say they both have union already.
        if (ulti_u == ulti_v) {
            return;
        }

        if (rank.get(ulti_u) < rank.get(ulti_v)) {
            parent.set(ulti_u, ulti_v);
        } else if (rank.get(ulti_v) < rank.get(ulti_u)) {
            parent.set(ulti_v, ulti_u);
        } else {

            // The important point to note here is that if this case where
            // the rank of both the nodes is same we can attach anyone to anyone
            // but the important thing to remember here is

            // if we are attaching v with u basically we are making v as child of
            // u then we have to make changes in the parent array as well as we need
            // to increase the rank of u by 1, because the height of the tree
            // has increased by 1.

            // and vice versa
            // if we make u as child of v then we need to change the
            // parent array and increase the rank of v by 1.

            parent.set(ulti_v, ulti_u);
            int rank_U = rank.get(ulti_u);

            rank.set(ulti_u, rank_U + 1);
        }

    }
}

class Main {
    public static void main(String[] args) {

        Disjoint_set ds = new Disjoint_set(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);

        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

```