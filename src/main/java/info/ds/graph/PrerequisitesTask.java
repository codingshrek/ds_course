package info.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Idea is if there is any cycle in tasks , then it is not possible.
 * Apply Topo Sort to find cycle in DAG , if cycle is present , it is impossible to do tasks.
 */
public class PrerequisitesTask {

    public List<Integer> bfs(Queue<Integer> q,int[] indegree,List<List<Integer>> adj){
        List<Integer> sorted = new LinkedList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            sorted.add(node);
            List<Integer> adjacentNodesList = adj.get(node);
            for(int adjacentNode : adjacentNodesList){
                indegree[adjacentNode] = indegree[adjacentNode] -1;
                if(indegree[adjacentNode]==0) q.offer(adjacentNode);
            }
        }
        return sorted;
    }

    public boolean isPossible(int N, int[][] prerequisites){

        List<List<Integer>> adj= new ArrayList<>();
        int[] indegree = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0;i<adj.size();i++){
            List<Integer> adjacent = adj.get(i);
            for(int node : adjacent ){
                indegree[node] =indegree[node]+1;
            }
        }

        for(int i = 0;i<N;i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> sorted = bfs(q,indegree,adj);

        if(sorted.size()==N) return true;
        return false;

    }

}
