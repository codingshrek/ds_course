package info.ds.graph;

import java.util.*;

/**
 * Initially the terminal nodes are those who have outdegree 0
 * but after reversal the terminal nodes becomes those which have indegree 0
 * so we can apply Kahn's algo to find all the nodes connected to it  which have linear dependency on the terminal node or is on the path which leads to terminal node
 * so if the nodes is a part of a cycle or points to a cycle , that path cannot lead to terminal node as each node in that  path will have cyclic dependency
 */
public class FindEventualSafeStatesBFS {

    private void bfs(int[] indegree, List<List<Integer>> reverseAdjacent, List<Integer> safeNodes, Queue<Integer> q) {

        while (!q.isEmpty()) {

            int node = q.poll();
            safeNodes.add(node);
            List<Integer> adjacentNodes = reverseAdjacent.get(node);
            for (int n : adjacentNodes) {
                indegree[n] = indegree[n] - 1;
                if (indegree[n] == 0) q.offer(n);
            }

        }


    }


    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> reverseAdjacents = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            reverseAdjacents.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            List<Integer> adjacentNodes = adj.get(i);
            for (int n : adjacentNodes) {
                reverseAdjacents.get(n).add(i);
                indegree[i]++;
            }
        }


        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }

        }

        bfs(indegree, reverseAdjacents, safeNodes, q);
        Collections.sort(safeNodes);
        return safeNodes;

    }

}
