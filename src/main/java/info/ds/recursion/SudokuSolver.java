package info.ds.recursion;

public class SudokuSolver {

    private boolean isPossible(int row, int col, char number, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
            if (board[i][row] == number) {
                return false;
            }
            //check for quadrant
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == number)
                return false;

        }

        return true;
    }

    public boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char n = 1; n <= 9; n++) {
                        if (isPossible(row, col, n, board)) {
                            board[row][col] = n;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {

        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };


        SudokuSolver s = new SudokuSolver();
        s.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

}
