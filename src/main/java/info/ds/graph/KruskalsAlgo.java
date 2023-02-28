package info.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helps us to find min spanning tree. Prims algo can also be used but this algo works in constant time.
 */
public class KruskalsAlgo {

    public static class Edge implements Comparable<Edge>{
        int to;
        int from;
        int wt;

        public Edge(int from,int to,int wt){
            this.from=from;
            this.to=to;
            this.wt=wt;
        }

        public int compareTo(Edge compareEdge) {
            return this.wt - compareEdge.wt;
        }

    }
    static int spanningTree(int V, int E, int edges[][]){

        List<Edge> adj = new ArrayList<>();
        DisjointSet ds = new DisjointSet(V);
        for(int i=0;i<E;i++){
            adj.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
        }
        //Step 1 : sort the edges.
        Collections.sort(adj);

        int mstWt=0;

        //TC-> E*4a
        for(Edge e : adj){
            int u = e.from;
            int v = e.to;
            int wt = e.wt;
            //Step 2 , if there is already a relation b/w u->v in disjoint set , we will not consider it.
            //suppose there is a edge b\w 1->2 , and a new edge comes up 3->2 , we will add it to ds . Now if an edge 3->1 comes up , we are not considering it.
            if(ds.findUParent(e.from)!=ds.findUParent(e.to)){
                ds.unionBySize(u,v);
                mstWt+=wt;
            }
        }

        return mstWt;
    }

}
