package info.ds.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * If any node leads to terminal node(that has no out going edges), It is a safe node.
 * Note : If any node leads to cycle , it is not safe.
 * If any node lies in the path of cycle, it is also not safe
 * Every other nodes are safe.
 * Intuition : Detect for cycles , the nodes which do not lead to cycles are safe node.
 */
public class FindEventualSafeStatesDFS {

    private boolean dfs(int start, List<List<Integer>> adj, int[] visited, int[] cycle) {

        visited[start] = 2;
        cycle[start] = 1;
        List<Integer> adjNodes = adj.get(start);
        for (int n : adjNodes) {
            if (visited[n] == 0) {
                visited[n] = 2; // 2 denotes it is in the path.
                cycle[n] = 1;
                if (dfs(n, adj, visited, cycle)) return true;
            } else if (visited[n] == 2)
                return true; //visited[n] =2 denotes , it is in the same path and cycle[n]=1 denotes n lies in a cycle else it would have backtracked to make it 0;
        }
        //Backtrack ie , cycle not found in this path , thus marking it as visited 1 and cycle 0.
        visited[start] = 1;
        cycle[start] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<Integer> safeNodes = new LinkedList<>();
        int visited[] = new int[V];
        int cycle[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, visited, cycle)) safeNodes.add(i);
            }
            //If node has been visited and no cycle was found in that node. it is a safe node.
            else if (visited[i] == 1 && cycle[i] == 0) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

}
