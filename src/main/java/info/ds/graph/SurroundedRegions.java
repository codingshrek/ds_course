package info.ds.graph;

/**
 * The idea is to traverse boundry nodes , if any node is O at boundry , all the nodes connecting to that boundry node will not turn X.
 */
public class SurroundedRegions {

    static void dfs(int row, int col, char a[][], int[][] visited) {
        visited[row][col] = 1;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = deltaRow[i] + row;
            int newCol = deltaCol[i] + col;

            if (newRow >= 0 && newCol >= 0 && newRow < a.length && newCol < a[0].length) {
                if (visited[newRow][newCol] != 1 && a[newRow][newCol] == 'O') {
                    dfs(newRow, newCol, a, visited);
                }
            }
        }

    }

    static char[][] fill(int n, int m, char a[][]) {
        int[][] visited = new int[a.length][a[0].length];
        char[][] result = new char[a.length][a[0].length];

        //Traverse first row and last row.
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O' && visited[0][i] != 1) {
                dfs(0, i, a, visited);
            }
            if (a[n-1][i] == 'O' && visited[n-1][i] != 1) {
                dfs(n-1, i, a, visited);
            }
        }
        //Traverse first col and last col.
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O' && visited[i][0] != 1) {
                dfs(i, 0, a, visited);
            }
            if (a[i][m-1] == 'O' && visited[i][m-1] != 1) {
                dfs(i, m-1, a, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 1) {
                    result[i][j] = 'O';
                } else {
                    result[i][j] = 'X';
                }
            }
        }
        return result;
    }
}
