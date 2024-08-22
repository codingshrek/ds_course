package info.ds.binary_search;

public class SearchIn2DMatrixRowColSorted {

    public static boolean searchElement(int [][]matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int row =0;
        int col = m-1;
        while(row<n && col >=0){

            if(target==matrix[row][col]) return true;
            if(target>=matrix[row][0] && target<=matrix[row][col]) col --;
            else if(target>=matrix[row][col] && target<=matrix[n-1][col]) row++;
            else col--;

        }
        return false;
    }
}
