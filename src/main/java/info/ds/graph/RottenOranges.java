package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int bfs(int row, int col, int[][] oranges) {


        System.out.println(" for row " + row + " col " + col);

        boolean[][] visited = new boolean[oranges.length][oranges[0].length];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }


        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(row, col);
        q.offer(p);
        int c = 0;

        while (!q.isEmpty()) {
            boolean flag = false;
            Pair curPair = q.poll();
            int curRow = curPair.row;
            int curCol = curPair.col;
            int deltaRow[] = {-1, 0, 1, 0};
            int deltaCol[] = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + deltaRow[i];
                int newCol = curCol + deltaCol[i];

                if (newRow >= 0 && newRow < oranges.length && newCol >= 0 && newCol < oranges[0].length) {
                    if (oranges[newRow][newCol] == 1 && visited[newRow][newCol] != true) {
                        Pair newPair = new Pair(newRow, newCol);
                        visited[newRow][newCol] = true;
                        q.offer(newPair);
                        flag = true;
                    }
                }
            }
            if (flag) c++;

        }

        System.out.println("Time is " + c);
        return c;

    }

    public int rottenOranges(int[][] oranges) {

        int counter = Integer.MAX_VALUE;


        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 2) {
                    int time = bfs(i, j, oranges);
                    counter = Math.min(time, counter);
                }
            }
        }

        return counter;

    }

    public static void main(String[] args) {

        int[][] oranges = {
                {0, 1, 2},
                {0, 1, 2},
                {2, 1, 1}
        };

        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.rottenOranges(oranges));

    }


}
