package info.ds.graph;

import java.util.*;

/**
 * SC-> O(n) for q + O(n) for List + O(n*m) for visited.
 *
 */
public class FindDistinctIsland {

    public static class Pair {

        int row;
        int col;
        //sROw and sCol holds the shape ie. cordinate - base-cordinate.
        int sRow;
        int sCol;

        public Pair(int row, int col, int sRow, int sCol) {
            this.row = row;
            this.col = col;
            this.sRow = sRow;
            this.sCol = sCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sRow, sCol);
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return (this.sRow == p.sRow) && (this.sCol == p.sCol);
        }
    }


    private List<Pair> bfs(int row, int col, int[][] grid, int[][] visisted) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col, row, col));
        int baseRow = row;
        int baseCol = col;
        List<Pair> islandCoordinates = new LinkedList<>();
        visisted[row][col] = 1;

        while (!q.isEmpty()) {


            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + deltaRow[i];
                int newCol = cur.col + deltaCol[i];
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length) {
                    if (grid[newRow][newCol] == 1 && visisted[newRow][newCol] != 1) {
                        Pair p = new Pair(newRow, newCol, newRow - baseRow, newCol - baseCol);
                        q.offer(p);
                        visisted[newRow][newCol] = 1;
                        islandCoordinates.add(p);
                    }
                }
            }
        }
        return islandCoordinates;

    }

    private int findIslands(int[][] grid) {

        Set<List<Pair>> set = new HashSet<>();
        int visited[][] = new int[grid.length][grid[0].length];
        //n x m
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) { //n x m x 4
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    set.add(bfs(i, j, grid, visited));
                }
            }
        }
        //total n x m * log(nxm) for set + n x m *4
        return set.size();

    }

    int countDistinctIslands(int[][] grid) {
        return findIslands(grid);
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        FindDistinctIsland i = new FindDistinctIsland();
        System.out.println(i.countDistinctIslands(grid));
    }
}
