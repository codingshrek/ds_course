package info.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * For every string i int the dictionary we compare i+1 string to find the diff. 'abc' and 'bbc' , diff is at index 0 , therefore there is an directed edge from a->b ;
 * we have converted every character in integer eg: for b we have 'b' - 'a'.
 * Apply topo sort and we will get the order of chars.
 * Note : if the question states that what if we cannot find any order i.e the graph is cyclic. We will have to consider two situations here
 * 1 : if s1 and s2 in the dictionary are 'abcd' and 'abc' then this is wrong because abcd should have been > abc.
 * 2 : cyclic dependency eg. if abc , bcd , aca , it mean a->b and then b->a ie , there is a cycle.
 *
 * TC- O(N*l) + O(K+E) +O(K) , where l = average length of words , K = no. nodes , E = edges .
 * SC -> O(K) for queue + O(K) indegree array + O(E) , edges.
 *
 */
public class AlienDictionary {

    //TC - > K+E
    public String bfs(List<List<Integer>> adj, int[]  indegree){
        Queue<Integer> q = new LinkedList<>();
        String result = "";
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node  = q. poll();
            char c = (char)(node + 'a');
            result = result+c;
            List<Integer> adjNodes = adj.get(node);
            for(int n : adjNodes ){
                indegree[n]--;
                if(indegree[n]==0) q.offer(n);
            }
        }

        return result;

    }
    public String findOrder(String [] dict, int N, int K){
        String result = "";
        int[] indegree = new int[K];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        //TC -> N*l where l is average length of word
        for(int i=0;i<N-1;i++){
            String s1= dict[i];
            String s2= dict[i+1];
            int size = Math.min(s1.length(),s2.length());
            for(int j=0;j<size;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        //TC-> K
        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        return bfs(adj,indegree);
    }


}
