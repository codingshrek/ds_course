package info.ds.graph;


import java.util.ArrayList;
import java.util.List;

/**
 * The visited logic of undirected graph will not work here .
 * The idea is if we visit the node twice in the same path , then there is a cycle.
 * We will maintian two arrays 1> visisted and 2> visitedPath.
 * VisitePath will have the path marked and while backtracking the path will be ommited.
 */
public class DetectCycleInDirectedGraphDFS {

    private boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visisted, int[] path) {

        List<Integer> adjNodes = adj.get(start);
        for (int n : adjNodes) {
            if (visisted[n] == 0) {
                path[n] = 1;
                visisted[n] = 1;
                if (dfs(n, adj, visisted, path)) return true;
                path[n] = 0; //Backtrack to remove path.
            } else if (visisted[n] == 1 && path[n] == 1) return true;
        }
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] visited = new int[V];
        int[] path = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, path)) return true;
            }
        }
        return false;
    }

}
