package info.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Greedy Algo.
 * We are always getting the minimal guy in every iteration and if any node with same node with greatest wt comes up is ignored.
 *
 */
public class PrimsAlgoMinSpanningTree {
    public static class Tuple{

        int node;
        int wt;
        int parent;

        public Tuple(int node,int wt,int parent){
            this.node = node;
            this.parent=parent;
            this.wt=wt;
        }

    }
    public static class Pair{

        int node1;
        int node2;

        public Pair(int node1,int node2){
            this.node1=node1;
            this.node2=node2;
        }

    }
    static int spanningTree(int V, int E, int edges[][]){

        List<List<Tuple>> adj = new ArrayList<>();
        //SC -> O(E)
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((x,y)-> x.wt-y.wt);

        int[] visited = new int[V];
        List<Pair> mstEdges = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Tuple(v,wt,-1));
            adj.get(v).add(new Tuple(u,wt,-1));
        }


        q.offer(new Tuple(0,0,-1));
        int sum = 0; //minimum mst wt
        //TC-> E for all the edges
        while(!q.isEmpty()){
            //Log(E)
            Tuple cur = q.poll();
            if(visited[cur.node]!=1){
                visited[cur.node] =1; //Important mark is visited only when node is taken out of q.
                if(cur.parent!=-1 && cur.wt!=0){
                    sum = sum+cur.wt;
                    mstEdges.add(new Pair(cur.parent,cur.node));
                }
                List<Tuple> adjacentNodes  = adj.get(cur.node);
                //E log(E)
                for(Tuple adjNode : adjacentNodes){
                    if(visited[adjNode.node]!=1){
                        q.offer(new Tuple(adjNode.node,adjNode.wt,cur.node));
                    }
                }
            }
        }
        //TC -> E log(E) + E log(E)
        return sum;
    }
}
