package info.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SC -> O(n) stack space + O(n) (visited array)
 * TC -> O(n) outer-loop + O(v+2E) - dfs call
 */
public class NumberOfProvinces {


    private void traversal(int start, List<List<Integer>> adj, boolean visited[]) {

        visited[start] = true;
        //Here to implement logic
        List<Integer> adjacents = adj.get(start);
        for (int i : adjacents) {
            if (!visited[i]) {

                traversal(i, adj, visited);
            }
        }
    }

    public int numberOfProvinces(List<List<Integer>> adj) {


        int counter = 0;

        boolean visited[] = new boolean[adj.size() + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                traversal(i, adj, visited);
                counter++;
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(null);
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1, 3));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList(4));
        adj.add(new ArrayList<>());

        DFS dfs = new DFS();
        boolean visited[] = new boolean[adj.size() + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        NumberOfProvinces provinces = new NumberOfProvinces();
        System.out.println(provinces.numberOfProvinces(adj));
    }

}
