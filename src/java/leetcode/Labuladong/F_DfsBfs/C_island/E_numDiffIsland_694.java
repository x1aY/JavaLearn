package leetcode.Labuladong.F_DfsBfs.C_island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class E_numDiffIsland_694 {

    int row, col;
    int landChar = 1, waterChar = 0;
    // 左下右上
    int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    char[] movesChar = { 'L', 'D', 'R', 'U' };

    public int numDiffIsland(int[][] grid) {
        Set<String> isLandSet = new HashSet<>();
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != waterChar) {
                    List<Character> steps = new ArrayList<>();
                    dfs(grid, i, j, steps);
                    System.out.println(steps.toString());
                    isLandSet.add(steps.toString());
                }
            }
        }
        return isLandSet.size();
    }
 
    public void dfs(int[][] grid, int rowi, int coli, List<Character> steps) {
        if (outBounds(rowi, coli) || grid[rowi][coli] == waterChar) {
            if (!steps.isEmpty())
                steps.remove(steps.size() - 1);
            return;
        }
        grid[rowi][coli] = waterChar;
        for (int i = 0; i < 4; i++) {
            steps.add(movesChar[i]);
            dfs(grid, rowi + moves[i][0], coli + moves[i][1], steps);
        }
    }

    public boolean outBounds(int rowi, int coli) {
        return rowi < 0 || rowi >= row || coli < 0 || coli >= col;
    }

    public static void main(String[] args) {
        E_numDiffIsland_694 solution = new E_numDiffIsland_694();
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
        System.out.println(solution.numDiffIsland(grid));
    }
}
