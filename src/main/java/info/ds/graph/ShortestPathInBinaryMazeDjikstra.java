package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMazeDjikstra {


    public class Tuple {

        int row;
        int col;
        int distance;

        public Tuple(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        //Since the distance between nodes is 1 , We do not need priority queue as the queue will have the nodes in the sorted order.
        //Suppose we are r1,w1,d1 we can go 4 directions with unit distances therefore q will have nodes in order of distance.
        Queue<Tuple> q = new LinkedList<>();

        int[][] distance = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[source[0]][source[1]] = 0;
        q.offer(new Tuple(source[0], source[1], 0));

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};


        //Djikstra Algorigthm
        //Since we are not using PQ , the TC-> V+E (log(E) is dropped because we dont need sorting in PQ.)
        while (!q.isEmpty()) {

            Tuple cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curDistance = cur.distance;

            if (curRow == destination[0] && curCol == destination[1]) return curDistance;

            for (int i = 0; i < 4; i++) {

                int newRow = curRow + deltaRow[i];
                int newCol = curCol + deltaCol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                    if (grid[newRow][newCol] != 0 && distance[newRow][newCol] > curDistance + 1) {
                        distance[newRow][newCol] = curDistance + 1;
                        q.offer(new Tuple(newRow, newCol, curDistance + 1));
                    }
                }


            }


        }

        return -1;
    }
}
