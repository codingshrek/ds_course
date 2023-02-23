package info.ds.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DjikstraPQ {


    public static class Pair {

        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    //TC-> E log(V) where e is the edges and V is the no.of vertices.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        int[] distance = new int[V]; //to store distance
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE; //initialized all values with +inf
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<ArrayList<Integer>> adjNodes = adj.get(i);
            for (ArrayList<Integer> l : adjNodes) {
                adjList.get(i).add(new Pair(l.get(0), l.get(1)));
                adjList.get(l.get(0)).add(new Pair(i, l.get(1)));
            }
        }


        //The idea of using priority q is to process the smallest path first in the queue therefore in future if any path with greater distance will not be consideted.
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance); //passing a comparator defination

        q.offer(new Pair(S, 0));
        distance[S] = 0;

        while (!q.isEmpty()) {

            Pair cur = q.poll();
            ArrayList<Pair> adjacentNodes = adjList.get(cur.node);

            for (Pair adjacentNode : adjacentNodes) {
                int newDistance = cur.distance + adjacentNode.distance;
                if (newDistance < distance[adjacentNode.node]) {
                    distance[adjacentNode.node] = newDistance;
                    q.offer(new Pair(adjacentNode.node, newDistance));
                }

            }


        }
        return distance;
    }

}
