package info.ds.graph;

import java.util.ArrayList;

public class NumberOfProvincesDisjointSet {

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {


        DisjointSet ds = new DisjointSet(V);

        //TC-> n*n
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.size();j++){
                if(adj.get(i).get(j)==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int provinces = 0;
        //TC->n
        //Idea is to find all the ultimate parents.
        for(int i=0;i<V;i++){
            if(ds.findUParent(i)==i) provinces++;
        }

        return provinces;
    }
}


