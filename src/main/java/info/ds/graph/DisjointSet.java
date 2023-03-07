package info.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * It is another DS which has two operations . findParent() , which finds the ultimate parent and unionBySize()/unionByRank.
 * UnionBySize of Rank creates relationship between sets. BySize is more intuitive because in rank , rank gets distorted after path compression.
 */
public class DisjointSet {


    private List<Integer> size;
    private List<Integer> rank;
    private List<Integer> parent;

    public DisjointSet(int n) {
        size = new ArrayList<>();
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        //n is the number of vertices;
        for (int i = 0; i < n + 1; i++) {
            rank.add(0); //initial rank of every node is 0.
            size.add(1); //initially every node is single thus size having 1.
            parent.add(i); //initially every node is parent of himself.
        }
    }

    //To find ultimate parent.
    public int findUParent(int node) {
        //When parent is himself , he is the ultimate parent.
        //eg : 4->2->6->1 , ultimate parent of 1 is one 4. Since 4 has no parent , he himself is parent.
        if (parent.get(node).equals(node)) {
            return node;
        }

        Integer u = findUParent(parent.get(node));
        parent.set(node, u); // Path compression. With above example when we find parent of 1 , nodes 2,6,1 will be set to 4.
        return u;

    }

    //TC-> 4*alpha which is almost constant . Its derivation is very large thus not required.
    public void unionByRank(int u, int v) {
        int uParentU = findUParent(u);
        int uParentV = findUParent(v);
        //when ultimate parents are same,nothing to be done.
        if (uParentU == uParentV) return;
        //Always join lower rank to higher rank
        if (rank.get(uParentU) > rank.get(uParentV)) {
            parent.set(uParentV, uParentU);
        }
        //This is the case where
        else if (rank.get(uParentV) > rank.get(uParentU)) {
            parent.set(uParentU, uParentV);
        }
        //This is the case where ranks are same but ultimate parents are diff. That is two disjoints sets.
        //We can do either of the two operations  u->v or v->u.
        else {
            parent.set(uParentV, uParentU);
            int rankU = rank.get(uParentU);
            rank.set(uParentU, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int uParentU = findUParent(u);
        int uParentV = findUParent(v);
        if (uParentU == uParentV) return;
        //Similar concept as above.
        if (size.get(uParentU) < size.get(uParentV)) {
            parent.set(uParentU, uParentV);
            size.set(uParentV, size.get(uParentV) + size.get(uParentU));
        } else {
            parent.set(uParentV, uParentU);
            size.set(uParentU, size.get(uParentU) + size.get(uParentV));
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

    public int getSize(int node) {
        int uParent = findUParent(node);
        return this.size.get(uParent);
    }

}
