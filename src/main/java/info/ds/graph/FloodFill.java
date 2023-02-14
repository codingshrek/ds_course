package info.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public void floodFill(int sr, int sc, int newColor, int[][] flood) {

        int initialColor = flood[sr][sc];
        Queue<Pair> q = new LinkedList<>();
        Pair start = new Pair(sr, sc);
        q.offer(start);
        flood[sr][sc] = newColor;

        while (!q.isEmpty()) {

            Pair curNode = q.poll();
            int row = curNode.row;
            int col = curNode.col;
            //left
            if (col >= 1 && flood[row][col - 1] == initialColor) {
                Pair n = new Pair(row, col - 1);
                flood[row][col - 1] = newColor;
                q.offer(n);
            }
            //right
            if (col < flood[0].length - 1 && flood[row][col + 1] == initialColor) {
                Pair n = new Pair(row, col + 1);
                flood[row][col + 1] = newColor;
                q.offer(n);
            }
            //up
            if (row >= 1 && flood[row - 1][col] == initialColor) {
                Pair n = new Pair(row - 1, col);
                flood[row - 1][col] = newColor;
                q.offer(n);

            }
            //down
            if (row < flood.length - 1 && flood[row + 1][col] == initialColor) {
                Pair n = new Pair(row + 1, col);
                flood[row + 1][col] = newColor;
                q.offer(n);
            }
        }

    }

    public static void main(String[] args) {

        int flood[][] = {
                {1, 1, 1},
                {2, 2, 0},
                {2, 2, 2}
        };

        int sr = 2;
        int sc = 1;

        int newColor = 3;

        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(sr, sc, newColor, flood);

        for (int i = 0; i < flood.length; i++) {
            for (int j = 0; j < flood[0].length; j++) {
                System.out.print(flood[i][j]+" ");
            }
            System.out.println();
        }

    }

}

