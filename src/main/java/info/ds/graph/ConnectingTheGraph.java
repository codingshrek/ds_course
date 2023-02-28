package info.ds.graph;

import java.util.Map;
import java.util.TreeMap;

/**
 * The Question States we are given n number of components and v vertices . Find min no. of steps to connect all the graphs.
 * Idea : to connect n components we need n-1 edges. If somehow we can find extra edges and no.of components we can calculate the answer.
 * Extra edge : if there is an edge from 0->1 , 1->2 then an edge 0->2 will be an extra edge.
 */
public class ConnectingTheGraph {

    public int Solve(int n, int[][] edge) {

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        int numberOfComponents = 0;
        //E * 4a
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            if (ds.findUParent(u) != ds.findUParent(v)) {
                ds.unionBySize(u, v);
            } else {
                ds.unionBySize(u, v);
                extraEdges++; //Finding extra edges
            }
        }

        //TC-> n
        for (int i = 0; i < n; i++) {
            if (ds.findUParent(i) == i) numberOfComponents++;
        }
        int requiredEdges = numberOfComponents - 1;
        TreeMap<String,Integer> map = new TreeMap<>();

        return extraEdges >= requiredEdges ? requiredEdges : -1;
    }

}
