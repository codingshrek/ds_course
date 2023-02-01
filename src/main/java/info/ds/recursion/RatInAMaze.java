package info.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {


    public boolean isTurnPossible(int row, int col, char turn, int[][] maze, boolean[][] visited) {

        switch (turn) {
            case 'D':
                if (row + 1 >= maze.length || visited[row + 1][col] || maze[row + 1][col] == 0) return false;
                break;
            case 'L':
                if (col - 1 < 0 || visited[row][col - 1] || maze[row][col - 1] == 0) return false;
                break;
            case 'R':
                if (col + 1 >= maze[0].length || visited[row][col + 1] || maze[row][col + 1] == 0) return false;
                break;
            case 'U':
                if (row - 1 < 0 || visited[row - 1][col] || maze[row - 1][col] == 0) return false;
                break;
        }
        return true;
    }

    public List<List<Character>> solve(int row, int col, boolean[][] visited, int[][] maze, List<Character> ds, List<List<Character>> res) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            res.add(new ArrayList<>(ds));
            return res;
        }

        visited[row][col] = true;

        //Down
        if (isTurnPossible(row, col, 'D', maze, visited)) {
            ds.add('D');
            solve(row + 1, col, visited, maze, ds, res);
            ds.remove(ds.size() - 1);
            visited[row + 1][col] = false;
        }
        //Left
        if (isTurnPossible(row, col, 'L', maze, visited)) {
            ds.add('L');
            solve(row, col - 1, visited, maze, ds, res);
            ds.remove(ds.size() - 1);
            visited[row][col - 1] = false;
        }
        //Right
        if (isTurnPossible(row, col, 'R', maze, visited)) {
            ds.add('R');
            solve(row, col + 1, visited, maze, ds, res);
            ds.remove(ds.size() - 1);
            visited[row][col + 1] = false;
        }
        //Up
        if (isTurnPossible(row, col, 'U', maze, visited)) {
            ds.add('U');
            solve(row - 1, col, visited, maze, ds, res);
            ds.remove(ds.size() - 1);
            visited[row - 1][col] = false;
        }
        return res;
    }

    public List<List<Character>> ratInAMaze(int maze[][]) {

        boolean visited[][] = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                visited[i][j] = false;
            }
        }

        return solve(0, 0, visited, maze, new ArrayList<>(), new ArrayList<>());
    }

    public static void main(String args[]) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        RatInAMaze m = new RatInAMaze();
        List<List<Character>> res = m.ratInAMaze(maze);
        res.forEach(i -> System.out.println(i.toString()));

    }

}


