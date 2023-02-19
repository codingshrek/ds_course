package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    public static class PairDistance {

        int row;
        int col;
        int distance; //distance from the starting node.

        public PairDistance(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }


    }

    private void bfs(int[][] grid, int[][] visited, int[][] distance) {

        Queue<PairDistance> q = new LinkedList<>();

        //We start with finding 1 in the grid , when 1 is found we start traversing in all 4 direction increasing distance with unit value.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    PairDistance p = new PairDistance(i, j, 0);
                    visited[i][j] = 1;
                    distance[i][j] = 0;
                    q.offer(p);
                }
            }
        }

        while (!q.isEmpty()) {

            PairDistance pair = q.poll();
            //Start traversing in all 4 directions
            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newRow = deltaRow[i] + pair.row;
                int newCol = deltaCol[i] + pair.col;

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                    if (grid[newRow][newCol] == 0 && visited[newRow][newCol] != 1) {
                        visited[newRow][newCol] = 1;
                        distance[newRow][newCol] = pair.distance + 1;
                        q.offer(new PairDistance(newRow, newCol, pair.distance + 1));
                    }
                }
            }

        }
    }

    public int[][] nearest(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];

        bfs(grid, visited, distance);
        return distance;

    }

    public static void main(String[] args) {
        DistanceOfNearestCellHaving1 d = new DistanceOfNearestCellHaving1();
        int[][] grid = {{1, 0, 1}, {1, 1, 0}, {1, 0, 0}};

        int[][] distance = d.nearest(grid);
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }

}
