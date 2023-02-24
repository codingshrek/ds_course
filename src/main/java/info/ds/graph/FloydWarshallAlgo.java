package info.ds.graph;

/**
 * Multi source shortest path algo
 * Helps to find shortest path from every node to every node.
 * Thought process : Go Via every node to every node to find the shortest path.
 * This results a 2D matrix.
 * How to detect -ve cycle : if cost of any node from itself <0 then there is a cycle.
 */
public class FloydWarshallAlgo {

    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = (int) 1e9;
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //going from i-j via k
                    matrix[i][j] = Math.min(matrix[i][j],
                            matrix[i][k] + matrix[k][j]);
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1e9) matrix[i][j] = -1;
            }
        }


    }



}
