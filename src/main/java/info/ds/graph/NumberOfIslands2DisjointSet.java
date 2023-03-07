package info.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2DisjointSet {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        int cells = rows * cols;
        int matrix[][] = new int[rows][cols]; //SC -> m*n
        int islands = 0;
        //Assigning every cell a node
        DisjointSet ds = new DisjointSet(cells);

        List<Integer> ans = new ArrayList<>();

        //TC -> K*4a*4 because we are checking neighbouring 4 nodes/cells , K= number of operations
        for (int i = 0; i < operators.length; i++) {

            int row = operators[i][0];
            int col = operators[i][1];

            //Repeating entry. If same operations come again. Do noting
            if (matrix[row][col] == 1) {
                ans.add(islands);
                continue;
            }

            int curNode = getCellNumber(row, col, cols);
            matrix[row][col] = 1;
            islands++;

            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int j = 0; j < 4; j++) {
                int adjRow = deltaRow[j] + row;
                int adjCol = deltaCol[j] + col;

                if (adjRow >= 0 && adjCol >= 0 && adjRow < rows && adjCol < cols) {
                    int adjNode = getCellNumber(adjRow, adjCol, cols);
                    if (matrix[adjRow][adjCol] == 1) {
                        if (ds.findUParent(curNode) != ds.findUParent(adjNode)) {
                            ds.unionBySize(curNode, adjNode);
                            islands--;
                        }

                    }

                }
            }
            ans.add(islands);
        }
        return ans;
    }

    private int getCellNumber(int curRow, int curCol, int cols) {
        return (curRow * cols) + curCol + 1;
    }
}
