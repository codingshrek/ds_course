package info.ds.graph;

import java.util.*;

public class DjikstraShortestPath {

    public static class Pair{

        int node;
        int distance;

        public Pair(int node,int distance){
            this.node = node;
            this.distance= distance;
        }

    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        Map<Integer,Pair> parents = new HashMap<>(); //SC-> N
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y)->x.distance - y.distance); //passing comaprator
        //SC-> N
        List<List<Pair>> adj = new ArrayList<>(); //SC-> V+2E


        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        //TC-> M
        //since it is undirected graph , create ajd for a->b and b->
        for(int i=0;i<m;i++){
            int edge[] = edges[i];
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }


        int end = n;

        //initialize Queue and map
        q.offer(new Pair(1,0)); // 1->1 will always take 0 distance
        parents.put(1,new Pair(1,0)); //Parent of 1 is always 1, since it is starting point.

        //TC-> E log(N)
        while(!q.isEmpty()){
            Pair cur = q.poll();
            List<Pair> adjacentNodes = adj.get(cur.node);
            for(Pair adjacentNode : adjacentNodes){
                int newDistance = cur.distance + adjacentNode.distance;
                if(parents.get(adjacentNode.node)!=null){

                    if(parents.get(adjacentNode.node).distance>newDistance){
                        parents.put(adjacentNode.node,new Pair(cur.node,newDistance));
                        q.offer(new Pair(adjacentNode.node,newDistance));
                    }
                }
                else{
                    parents.put(adjacentNode.node,new Pair(cur.node,newDistance));
                    q.offer(new Pair(adjacentNode.node,newDistance));
                }
            }

        }

        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int tempParent = end;
        //Tc-> N
        while(true){
            if(parents.get(tempParent)==null) {
                result.add(-1);
                return result;
            }
            else{
                stack.push(tempParent);
                tempParent=parents.get(tempParent).node;
                if(tempParent==1) break;
            }
        }

        stack.push(1);

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1,2,2},
                {2,5,5},
                {2,3,4},
                {1,4,1},
                {4,3,3},
                {3,5,1}
        };
        int n = 5;
        int m= 6;
        System.out.println(DjikstraShortestPath.shortestPath(n,m,edges).toString());;
    }
}
