package info.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class MaximumConnectedGroup {

    private boolean isValid(int row, int col, int n) {
        if (row >= 0 && col >= 0 && row < n && col < n) return true;
        return false;
    }

    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        //Connecting all nodes to components
        //TC-> n*n * 4a
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {
                    int deltaRow[] = {-1, 0, 1, 0};
                    int deltaCol[] = {0, 1, 0, -1};

                    for (int i = 0; i < 4; i++) {
                        int adjRow = row + deltaRow[i];
                        int adjCol = col + deltaCol[i];

                        if (isValid(adjRow, adjCol, n)) {
                            if (grid[adjRow][adjCol] == 1) {
                                int curNode = row * n + col;
                                int adjNode = adjRow * n + adjCol;
                                ds.unionBySize(curNode, adjNode);
                            }

                        }
                    }
                }
            }
        }

        int totalSize = 0;
        //Trying to put 1 at every 0 in grid and calculating size of neighbouring components.
        //TC-> n*n*4
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 0) {
                    int deltaRow[] = {-1, 0, 1, 0};
                    int deltaCol[] = {0, 1, 0, -1};
                    Set<Integer> components = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int adjRow = row + deltaRow[i];
                        int adjCol = col + deltaCol[i];

                        if (isValid(adjRow, adjCol, n)) {
                            if (grid[adjRow][adjCol] == 1) {
                                int adjNode = adjRow * n + adjCol;
                                int uParent = ds.findUParent(adjNode);
                                components.add(uParent);
                            }

                        }
                    }
                    int tempSize = 0;
                    for (int component : components) {
                        tempSize += ds.getSize(component);
                    }
                    totalSize = Math.max(totalSize, tempSize + 1);
                }
            }

        }

        for (int i = 0; i < n * n; i++) {
            totalSize = Math.max(totalSize, ds.getSize(i));
        }

        return totalSize;
    }

}
