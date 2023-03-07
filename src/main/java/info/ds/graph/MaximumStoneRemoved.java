package info.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class MaximumStoneRemoved {


    //stones array contains position of stones.
    int maxRemove(int[][] stones, int n) {

        int maxRow=0;
        int maxCol=0;
        //finding maxrow and maxcol ie gridsize
        for(int i =0;i<stones.length;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }

        //Idea is to take each row and column as a node rather than taking stone as a node.
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        Set<Integer> stoneSet = new HashSet<>();
        for(int i =0;i<stones.length;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneSet.add(nodeRow);
            stoneSet.add(nodeCol);
        }

        //Ans = total stones - no. components .
        //if comp. size is 4 we can only remove 3 stones. therefore size(c1)-1 + size(c2)-1  and so on -> n - no. of comps.
        int components =0;
        for(int node : stoneSet){
            if(ds.findUParent(node)==node) components++;
        }

        return n-components;

    }

}
