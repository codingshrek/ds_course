package info.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithKStopsDjikstra {

    public static class Tuple {

        int node;
        int cost;
        int stop;

        public Tuple(int node, int cost, int stop){
            this.node = node;
            this.cost = cost;
            this.stop = stop;
        }

    }

    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {

        List<List<Tuple>> adj = new ArrayList<>();
        int[] cost = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            cost[i]=Integer.MAX_VALUE;
        }

        for(int i=0;i<flights.length;i++){
            int[]  flight = flights[i];
            adj.get(flight[0]).add(new Tuple(flight[1],flight[2],0));
        }

        //Idea is to store the node in respect to stops not with respect to cost.
        //Because we might reach an intermediate node with less cost but have exhausted the no. of stops and cannot go further.
        //Other path with more cost can proceed if it has not exhausted the no. of stops.

        Queue<Tuple> q = new LinkedList<>();
        cost[src]=0;
        q.offer(new Tuple(src,0,0));


        //TC-> V+E , since we are storing in respect to stops which is increasing by 1 every time , q will already b sorted.
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            if(cur.stop>k) continue; //suppose if k=2  and cur.stop has got 3 , we will not go further because further node is at stop 4 .
            List<Tuple> adjNodes = adj.get(cur.node);
            for(Tuple city : adjNodes){
                int cityCost = city.cost;
                int stops = cur.stop;

                //We can go till K+1 as destination is not considered in our stops.
                //Anything with stops more K+1 are not considered.
                if(cur.cost+cityCost<cost[city.node] && stops<=k){
                    cost[city.node]=cityCost+cur.cost;
                    q.offer(new Tuple(city.node,cityCost+cur.cost,stops+1));
                }

            }



        }
        //In this case we are returning the answer after the full algo has run because we were storing values in q wrt to stops .
        //Suppose dest is 2 and we have 2 values in q 2,2,10 and 2,3,7 (node,stops,cost). The next value picked up from heap will be. 2,2,10.
        //Idea is we can get cheapest flights with more number of stops.
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];

    }

}
