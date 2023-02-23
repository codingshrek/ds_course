package info.ds.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Standard Algos will also work , but its time complexity will be high.
 * Since topo sort has order such that if there is an edge from u->v the u appears before v in the ordering.
 * Therefore we calculated the distance sequenctially in topo sort.
 */
public class ShortestPathInDAG {
    public static class Pair {

        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    //Topo sort using dfs
    private void topoSort(int start, int[] visited, List<List<Pair>> adj, Stack<Integer> stack) {
        visited[start] = 1;

        List<Pair> adjacentNodes = adj.get(start);
        for (Pair p : adjacentNodes) {
            if (visited[p.node] != 1) topoSort(p.node, visited, adj, stack);
        }

        stack.push(start);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));

        }

        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();

        //Topo sor for every component

        for (int i = 0; i < N; i++) {
            if (visited[i] != 1) topoSort(i, visited, adj, stack);
        }

        //We need to find the distance.
        int[] distance = new int[N];

        for (int i = 0; i < N; i++) {
            distance[i] = -1; // We need to return -1 for unreachable edges.
        }

        int source = 0;
        distance[source] = 0; //Since question has stated , start will always be 0;
        //Making sure 0 is on top of stack. Anything before 0 does not make sense because there are no egdes from zero to elements before it.
        while (stack.peek() != source) {
            stack.pop();
        }

        while (!stack.isEmpty()) {

            int node = stack.pop();
            int distanceFromSource = distance[node]; // this is the shortest from source to this node distance.
            List<Pair> adjacentNodes = adj.get(node);
            for (Pair p : adjacentNodes) {
                int newDistance = distanceFromSource + p.weight;
                if (distance[p.node] != -1) {
                    if (distance[p.node] > newDistance) {
                        distance[p.node] = newDistance;
                    }
                } else {
                    distance[p.node] = newDistance;
                }
            }
        }


        return distance;
    }
}
