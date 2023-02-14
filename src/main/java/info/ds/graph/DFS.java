package info.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {

    public void traversal(int start, List<List<Integer>> adj, boolean visited[]) {
        visited[start] = true;

        //Here to implement logic
        System.out.println(start);
        List<Integer> adjacents = adj.get(start);
        for (int i : adjacents) {
            if (!visited[i]) {
                traversal(i, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(null);
        adj.add(Arrays.asList(2, 3));
        adj.add(Arrays.asList(1, 4));
        adj.add(Arrays.asList(2, 1, 4));
        adj.add(Arrays.asList(2, 3));

        DFS dfs = new DFS();
        boolean visited[] = new boolean[adj.size() + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        dfs.traversal(1, adj, visited);
    }
}
