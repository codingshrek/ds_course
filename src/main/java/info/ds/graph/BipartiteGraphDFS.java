package info.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraphDFS {

    private boolean dfs(int start, int color, ArrayList<ArrayList<Integer>> adj, int[] colors) {

        int oppColor = color == 1 ? 2 : 1;
        colors[start] = color;
        List<Integer> adjNodes = adj.get(start);

        for (int n : adjNodes) {
            if (colors[n] == 0) {
                if (!dfs(n, oppColor, adj, colors)) return false;
            } else if (colors[n] == color) return false;
        }

        return true;
    }


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] colors = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1, adj, colors)) return false;
            }
        }
        return true;
    }
}
