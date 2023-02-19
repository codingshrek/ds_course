package info.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Idea is similar to Prerequisite tasks , just we need to return the order.
 * Note : in the question edges are reversed
 *
 */
public class CourseSchedule {

    public static List<Integer> bfs(Queue<Integer> q, int[] indegree, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> sorted = new LinkedList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            sorted.add(node);
            List<Integer> adjacentNodesList = adj.get(node);
            for (int adjacentNode : adjacentNodesList) {
                indegree[adjacentNode] = indegree[adjacentNode] - 1;
                if (indegree[adjacentNode] == 0) q.offer(adjacentNode);
            }
        }
        return sorted;
    }

    static int[] findOrder(int N, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[N];
        int arr[] = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        for (int i = 0; i < adj.size(); i++) {
            List<Integer> adjacent = adj.get(i);
            for (int node : adjacent) {
                indegree[node] = indegree[node] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        List<Integer> sorted = bfs(q, indegree, adj);

        if (sorted.size() == N) {
            int c = 0;
            for (int order : sorted) {
                arr[c++] = order;
            }
            return arr;
        }

        return new int[0];
    }

}
