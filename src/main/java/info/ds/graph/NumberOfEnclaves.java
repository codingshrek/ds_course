package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {


    public static class Pair {

        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    private void initializeQueue(Queue<Pair> q, int[][] grid, int visited[][]) {

        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < c; i++) {
            //first Row
            if (grid[0][i] == 1 && visited[0][i] != 1) {
                q.offer(new Pair(0, i));
                visited[0][i] = 1;
            }
            //last row
            if (grid[r - 1][i] == 1 && visited[r - 1][i] != 1) {
                q.offer(new Pair(r - 1, i));
                visited[r - 1][i] = 1;
            }
        }

        //Traverse first and last column
        for (int j = 0; j < r; j++) {
            //First column
            if (grid[j][0] == 1 && visited[j][0] != 1) {
                q.offer(new Pair(j, 0));
                visited[j][0] = 1;
            }
            if (grid[j][c - 1] == 1 && visited[j][c - 1] != 1) {
                q.offer(new Pair(j, c - 1));
                visited[j][c - 1] = 1;

            }


        }

    }

    private void bfs(int[][] grid, int[][] visited) {


        Queue<Pair> q = new LinkedList<>();

        initializeQueue(q, grid, visited);

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newRow = deltaRow[i] + cur.row;
                int newCol = deltaCol[i] + cur.col;

                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                    if (grid[newRow][newCol] == 1 && visited[newRow][newCol] != 1) {
                        q.offer(new Pair(newRow, newCol));
                        visited[newRow][newCol] = 1;
                    }

                }
            }

        }
    }


    //If any node i.e. connected to the boundary is not a part of the answer . We will iterate over boundary nodes , if 1(land) is found we make a bfs/dfs call to all the connected nodes. These nodes will not in the anwer.
    int numberOfEnclaves(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        int counter = 0;
        bfs(grid, visited);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        NumberOfEnclaves enclaves = new NumberOfEnclaves();
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(enclaves.numberOfEnclaves(grid));

    }

}
