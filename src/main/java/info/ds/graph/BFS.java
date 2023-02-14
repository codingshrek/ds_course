package info.ds.graph;

import java.util.*;

public class BFS {

    public void traverse(int start, boolean[] visited, List<List<Integer>> adj) {


        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer curNode = q.poll();

            System.out.println(curNode);
            List<Integer> adjacentNodes = adj.get(curNode);
            for (Integer i : adjacentNodes) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();


        List<List<Integer>> adj = new ArrayList<>();
        adj.add(null);
        adj.add(Arrays.asList(2, 3));
        adj.add(Arrays.asList(1, 4));
        adj.add(Arrays.asList(2, 1, 4));
        adj.add(Arrays.asList(2, 3));

        boolean visited[] = new boolean[adj.size() + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        bfs.traverse(4, visited, adj);
    }

}
