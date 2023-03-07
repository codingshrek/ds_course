package info.ds.graph;

/**
 * SC -> O(n2) stack space + O(n2) (visited array)
 * TC -> O(n2) nested loops
 */
public class NumberOfIslands {

    public void traverseNodes(int row, int col, boolean[][] visited, int[][] islands) {

        visited[row][col] = true;

        //instead of writing 8 lines for every 8 neighbours , we have this shortcut as all the 8 neighbours will lie between -1 to +1 for row and column
        for (int deltaRow = -1; deltaRow <= +1; deltaRow++) {
            for (int deltaCol = -1; deltaCol <= +1; deltaCol++) {
                int newRow = row + deltaRow;
                int newCol = col + deltaCol;
                if (newRow >= 0 && newRow < islands.length && newCol >= 0 && newCol < islands[0].length) {
                    if (visited[newRow][newCol] != true && islands[newRow][newCol] != 0)
                        traverseNodes(newRow, newCol, visited, islands);
                }
            }
        }


    }

    public int numberOfIslands(int[][] islands) {

        boolean visited[][] = new boolean[islands.length][islands[0].length];

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int counter = 0;

        for (int i = 0; i < islands.length; i++) {
            for (int j = 0; j < islands[0].length; j++) {
                if (islands[i][j] == 1 && !visited[i][j]) {
                    traverseNodes(i, j, visited, islands);
                    counter++;
                }

            }
        }

        return counter;
    }

    public static void main(String[] args) {

        int islands[][] = {
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        };

        NumberOfIslands is = new NumberOfIslands();
        System.out.println(is.numberOfIslands(islands));
    }

}
