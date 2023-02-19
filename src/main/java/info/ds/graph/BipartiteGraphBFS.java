package info.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * We can use only two colors
 * A graph whose adjacent nodes are of diff color. if any two nodes that cannot have two diff colors , it is not Bipartite grapgh.
 * Note :  A graph having cycle of even no. of nodes is bipartite , and odd no. of nodes is not bipartite.
 *         A linear graph is bipartite.
 */
public class BipartiteGraphBFS {

    //1= green , 2 = yellow
    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] colors){

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colors[start]=1;

        while(!q.isEmpty()){
            int cur = q.poll();
            int color = colors[cur];
            List<Integer> adjNodes = adj.get(cur);
            int oppColor = color==1? 2 : 1;
            for(int n : adjNodes){
                if(colors[n]==0){
                    q.offer(n);
                    colors[n]=oppColor;
                }
                else if(colors[n]==color){
                    return false;
                }
            }


        }
        return true;
    }
    public boolean isBipartite(int V,ArrayList<ArrayList<Integer>> adj){
        int[] colors = new int[adj.size()];
        //n+2E
        for(int i=0;i<adj.size();i++){
            if(colors[i]==0){
                if(!bfs(i,adj,colors)) return false;
            }

        }
        return true;

    }
}
