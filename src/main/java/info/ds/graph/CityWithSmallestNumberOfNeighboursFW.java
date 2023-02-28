package info.ds.graph;

public class CityWithSmallestNumberOfNeighboursFW {

    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) matrix[i][j] = 0; // same node
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = edges[i][2];
            matrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        //Floyd Warshall Algo
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int city = -1;
        int cityCount = n;

        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) counter++;
            }
            //Finding minimum cities.
            if (counter <= cityCount) {
                cityCount = counter;
                city = i;
            }

        }

        return city;
    }

}
