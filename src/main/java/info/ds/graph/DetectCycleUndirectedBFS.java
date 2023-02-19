package info.ds.graph;

import java.util.*;

/**
 * Sc -> O(n) queue + O(n) adj + O(n) visited
 * TC -> O(n+2E) for traversing all nodes and its adjacent nodes. + O(n) for loop
 */
public class DetectCycleUndirectedBFS {


    public static class NodeWithParent {

        int node;
        int parent;

        public NodeWithParent(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean detectCycleInAGraph(int start, ArrayList<ArrayList<Integer>> adj, int[] visited) {

        visited[start] = 1; // This is the start with no parent. Parent means while traversing from where we have reached this node.
        Queue<NodeWithParent> q = new LinkedList<>();

        q.offer(new NodeWithParent(start, -1));

        while (!q.isEmpty()) {

            NodeWithParent cur = q.poll();
            List<Integer> adjacents = adj.get(cur.node);
            for (int np : adjacents) {

                if (cur.parent != np) {
                    if (visited[np] == 1) {
                        return true; //this is the colliding point . from start we went on to diff paths but are meeting here means there is a cycle.
                    } else {
                        visited[np] = 1;
                        q.offer(new NodeWithParent(np, cur.node));
                    }
                }

            }

        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    //This loop is to check if any component has a cycle , then it is cyclic.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] != 1) {
                boolean detect = detectCycleInAGraph(i, adj, visited);
                if (detect == true) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirectedBFS detectCycleBFS = new DetectCycleUndirectedBFS();
        //having cycle
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(1, 6)));
        adj.add(new ArrayList<>(Arrays.asList(1, 5, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.add(new ArrayList<>(Arrays.asList(2, 7)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6)));


        System.out.println(detectCycleBFS.isCycle(adj));

        //Not having cycle
        adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(6)));
        adj.add(new ArrayList<>(Arrays.asList(5, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.add(new ArrayList<>(Arrays.asList(2, 7)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6)));

        System.out.println(detectCycleBFS.isCycle(adj));

    }

}
