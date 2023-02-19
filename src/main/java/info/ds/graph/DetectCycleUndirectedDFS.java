package info.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SC- > O(n) recursion stack + O(n) visited
 * TC -> O(n) for loop on every node + O(n+2E) i.e. summation of all the degrees
 */
public class DetectCycleUndirectedDFS {

    public boolean dfs(int start, int parent, ArrayList<ArrayList<Integer>> adj, int visited[]) {

        visited[start] = 1;
        List<Integer> adjacentNodes = adj.get(start);
        for (Integer np : adjacentNodes) {
            if (np != parent) {
                if (visited[np] == 1) {
                    return true;
                } else {
                    if (dfs(np, start, adj, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] != 1) {
                boolean detect = dfs(i, -1, adj, visited);
                if (detect == true) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirectedDFS detectCycleDFS = new DetectCycleUndirectedDFS();
        //having cycle
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(1, 6)));
        adj.add(new ArrayList<>(Arrays.asList(1, 5, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.add(new ArrayList<>(Arrays.asList(2, 7)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6)));


        System.out.println(detectCycleDFS.isCycle(adj));

        //Not having cycle
        adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(6)));
        adj.add(new ArrayList<>(Arrays.asList(5, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.add(new ArrayList<>(Arrays.asList(2, 7)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6)));

        System.out.println(detectCycleDFS.isCycle(adj));

    }

}
