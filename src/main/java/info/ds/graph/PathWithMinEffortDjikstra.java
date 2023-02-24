package info.ds.graph;

import java.util.PriorityQueue;

public class PathWithMinEffortDjikstra {


    public static class Tuple {

        int row;
        int col;
        int distance;

        public Tuple(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    int MinimumEffort(int heights[][]) {

        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);
        int[][] distance = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;//since source is 0,0
        q.offer(new Tuple(0, 0, 0));

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        //TC-> E log(V)
        //Djikstra
        while (!q.isEmpty()) {

            Tuple cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;

            //This is the time where we have found the destination .
            // if there are any more destinations in the queue those are always greater than this because we are always picking up the minimum.
            //Eg if dest has a dist 2 , in future suppose there is a path with abs diff of 1 , max of abs diff will be 2, thus we cannot get any max distance less than 2.
            if(curRow == heights.length-1 && curCol == heights[0].length) return cur.distance;

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + deltaRow[i];
                int newCol = curCol + deltaCol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < heights.length && newCol < heights[0].length) {
                    int newDistance = Math.abs(heights[curRow][curCol] - heights[newRow][newCol]);
                    newDistance = Math.max(cur.distance, newDistance);
                    //Question says , maximum of absolute differences.
                    //Example path is 1->2->8->3->5 :  abs differences are 1 ,6 , 5, 2 -> Max is 6.
                    //Out of the max differences , take the minimum.
                    //Suppose there are two paths
                    // 1->2->8->3->5 :  abs differences are 1 ,6 , 5, 2 -> Max is 6.
                    //1->3->5>3->5 : adb diff are 2,2,2,2 -> max is 2
                    //min of 6,2 is 2 , which is the answer.
                    if (distance[newRow][newCol] > newDistance) {
                        distance[newRow][newCol] = newDistance;
                        q.offer(new Tuple(newRow, newCol, newDistance));
                    }

                }

            }

        }

        return distance[heights.length - 1][heights[0].length - 1];

    }

}
