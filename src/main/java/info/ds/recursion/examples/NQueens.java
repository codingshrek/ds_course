package info.ds.recursion.examples;

import java.util.List;

public class NQueens {

    private static boolean checkIfQueenCanBePlaced(int chess[][], int i, int j, int n) {

        int t1 = i;
        int t2 = j;
        while (j >= 0) {
            if (chess[i][j] == 1) {
                return false;
            }
            j -= 1;
        }

        i = t1;
        j = t2;

        while (i >= 0 && j >= 0) {
            if (chess[i][j] == 1) {
                return false;
            }
            i -= 1;
            j -= 1;
        }

        i = t1;
        j = t2;

        while (i < n && j >= 0) {
            if (chess[i][j] == 1) {
                return false;
            }
            i += 1;
            j -= 1;
        }

        return true;
    }

    public static void solution(int column, int[][] chess, int n) {
        if (column == n) {
            System.out.println("Solution Found ");
            for (int i = 0; i <= n - 1; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int row = 0; row < n; row++) {
            if (checkIfQueenCanBePlaced(chess, row, column, n)) {
                chess[row][column] = 1;
                solution(column + 1, chess, n);
                chess[row][column] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int chess[][] = new int[n][n];
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                chess[i][j] = 0;
            }
        }
        solution(0, chess, n);
    }

}
