package info.ds.graph;


/**
 * Finds shortest path from single source ,  similar to Djikstra'
 * Works with -ve edge wts.
 * Helps to detect -ve cycle.
 * Only works with DG. If UG is given convert it to DG with bidirectional edges.
 * edges can be given in any order
 */

import java.util.ArrayList;

/**
 * Thought process : relax edges n-1 times where is the number of nodes. N-1 , because if the ordering is in reversed order for a graph like
 * 0->1->2->3->4 and edges are given from 4 to 0 , in the first iteration 1 will be discoverd , in second 2 and so on.
 * If we run the iteration n times and the relaxation of any egde is done that means we are running in a loop.
 */
public class BellmanFordAlgorithm {

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];


        for (int i = 0; i < V; i++) distance[i] = (int) 1e8;
        distance[S] = 0; //Since it is source;
        //V-1 iterations
        //V*E this is in quadratic time , where as djikstra is E log(V).
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                ArrayList<Integer> edge = edges.get(j);
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (distance[u] != 1e8 && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }

        }

        //Vth iteration to check if it has -ve cycle
        for (int j = 0; j < edges.size(); j++) {
            ArrayList<Integer> edge = edges.get(j);
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (distance[u] != 1e8 && distance[u] + wt < distance[v]) {
                //if this conditions is true that means there is a cycle
                return new int[]{-1};
            }
        }

        return distance;

    }

}
