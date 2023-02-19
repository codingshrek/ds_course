package info.ds.graph;

import java.util.*;

/**
 * Kahn's Algorithm
 * Idea : is to push nodes in q only when their in degree is 0.
 * Check for adjacent nodes , reduce the indegree.
 */
public class TopologicalSortBFS {

    public static int bfs(int[] sorted,int[] indegree, Queue<Integer> q, ArrayList<ArrayList<Integer>> adj) {
        int c=0;
        while (!q.isEmpty()) {
            int node = q.poll();
            c++;
            List<Integer> adjacentNodes = adj.get(node);
            for (int n : adjacentNodes) {
                indegree[n] = indegree[n] - 1;
                if (indegree[n] == 0) q.offer(n);
            }
        }
      return c;
    }

    static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];
        //n+E
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> nodes = adj.get(i);
            for (int n : nodes) {
                indegree[n] = indegree[n] + 1;
            }
        }

        // n
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) q.offer(i);
        }
        int[] sorted = new int[V];
        int c = bfs(sorted,indegree, q, adj);
        return c==V?false:true;
    }




}
