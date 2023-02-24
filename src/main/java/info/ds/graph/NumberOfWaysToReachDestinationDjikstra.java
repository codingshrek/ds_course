package info.ds.graph;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Imp
public class NumberOfWaysToReachDestinationDjikstra {


    public static class Pair {

        int node;
        int distance;


        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;

        }

    }
    //TC -> E log(V) same as djikstra
    static int countPaths(int n, List<List<Integer>> roads) {

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y)->x.distance - y.distance);
        List<List<Pair>> adj = new ArrayList<>();
        int[] distance = new int[n];
        int[] ways = new int[n];
        for(int i = 0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
            ways[i] = 0; //at start no node has been reached thus having value zero.
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.size();i++){
            List<Integer> rd = roads.get(i);
            adj.get(rd.get(0)).add(new Pair(rd.get(1),rd.get(2)));
            adj.get(rd.get(1)).add(new Pair(rd.get(0),rd.get(2)));

        }


        distance[0]=0;
        ways[0]=1; //There is 1 way to reach source.

        q.offer(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(!q.isEmpty()){

            Pair cur = q.poll();
            int wt = cur.distance;
            int node = cur.node;

            List<Pair> adjacentNodes = adj.get(node);
            for(Pair tp : adjacentNodes){
                int eWt = tp.distance;
                int adjNode = tp.node;

                //This is the first time we are reaching at this node with a shorted distance.
                //We will update the distance and take its no. of ways .
                //if node 5 is reachable from 2 and no. of ways to reach 2 with the shortest distance = 4 then node 5 should also be reachable in 4 ways with shorted distance.
                if(wt+eWt< distance[adjNode]){
                    distance[adjNode] = (wt+eWt)%mod;
                    q.offer(new Pair(adjNode,(wt+eWt)%mod));
                    ways[adjNode] = ways[node];
                }
                else if(wt+eWt==distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod; // if distance is same then ways will be added.
                                                                        // suppose 5 has been reached with a distance 3 2times and from this node it is again reaching 5 with distance 3 , then number of ways of this node will be added.
                }

            }


        }


        return ways[n - 1] % mod;
    }

}
