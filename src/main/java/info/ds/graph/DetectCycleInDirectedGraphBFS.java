package info.ds.graph;

import java.util.*;

/**
 * Idea : we will use Kahn's algorithm to generate topo sort, if topoSort.size() < V , then there is a cycle
 */
public class DetectCycleInDirectedGraphBFS {


    public int bfsTopoSort(int[] indegree, Queue<Integer> q, List<List<Integer>> adj) {
        int counter = q.size()-1;
        while (!q.isEmpty()) {
            int node = q.poll();
            counter++; // Keeping count of nodes in topo sort;
            List<Integer> adjacentNodes = adj.get(node);
            for (int n : adjacentNodes) {
                indegree[n] = indegree[n] - 1;
                if (indegree[n] == 0) q.offer(n);
            }
        }
        System.out.println("Counter --"+counter);

        return counter;
    }

    public boolean isCycle(List<List<Integer>> adj) {
        int[] indegree = new int[adj.size()];
        //n+E
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            List<Integer> nodes = adj.get(i);
            for (int n : nodes) {
                indegree[n] = indegree[n] + 1;
            }
        }

        // n
        for (int i = 0; i < indegree.length; i++) {
            System.out.println(String.format("Indegree of %d is %d", i, indegree[i]));
            if (indegree[i] == 0) q.offer(i);
        }
        //n+E
        return bfsTopoSort(indegree, q, adj) == adj.size() -1 ? false : true;

    }

    public static void main(String[] args) {

        DetectCycleInDirectedGraphBFS kahnsAlgo = new DetectCycleInDirectedGraphBFS();
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(0));
        adj.add(Arrays.asList(2));
        System.out.println(kahnsAlgo.isCycle(adj));

    }

}
