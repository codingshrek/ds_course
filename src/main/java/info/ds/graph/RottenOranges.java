package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SC -> O(2n*m) == O(nxm)
 * TC -> O(4*n*n) == O(nxm)
 */
public class RottenOranges {
    public int bfs(int[][] oranges, int[][] visited) {

        int freshOranges = 0;
        int min = 0;
        Queue<PairTime> q = new LinkedList<>();
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 2) {
                    q.offer(new PairTime(i, j, 0));
                    visited[i][j] = 2;
                } else if (oranges[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        System.out.println("Fresh Oranges : "+ freshOranges);

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            PairTime curOrange = q.poll();
            min = Math.max(curOrange.time, min);
            for (int i = 0; i < 4; i++) {
                int row = deltaRow[i] + curOrange.row;
                int col = deltaCol[i] + curOrange.col;

                if (row >= 0 && row < oranges.length && col >= 0 && col < oranges[0].length) {
                    if (oranges[row][col] == 1 && visited[row][col] != 2) {
                        q.offer(new PairTime(row, col, curOrange.time + 1));
                        visited[row][col] = 2;
                        freshOranges--; // How many fresh oranges are left after the traversal. If fresh oranges == 0 then we have rotten all the oranges else ,some are left and we need to return -1;
                    }
                }
            }

        }

        System.out.println("Fresh Oranges : "+ freshOranges);
        if(freshOranges!=0) return -1;

        return min;

    }

    public int rottenOranges(int[][] oranges) {
        int[][] visited = new int[oranges.length][oranges[0].length];
        return bfs(oranges, visited);

    }

    public static void main(String[] args) {

        int[][] oranges = {
                {0, 1, 2,0},
                {0, 1, 1,0},
                {2, 1, 0,1}
        };

        RottenOranges rt = new RottenOranges();
        System.out.println(rt.rottenOranges(oranges));


    }


    static class PairTime {

        int row;
        int col;
        int time; //This represents time taken to rot this orange.

        public PairTime(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }


    }
}

