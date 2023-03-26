package leetcode.Labuladong.F_DfsBfs.C_island;

public class D_numIslands_200 {

    int row, col;
    boolean[][] used;
    char landChar = '1', waterChar = '0';
    int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        used = new boolean[row][col];
        int numCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == landChar && !used[i][j]) {
                    findIsland(grid, i, j);
                    System.out.println(i+", "+j);
                    numCount++;
                }
            }
        }
        return numCount;
    }

    public void findIsland(char[][] grid, int rowi, int coli) {
        if (rowi < 0 || rowi >= row || coli < 0 || coli >= col ||
         used[rowi][coli] || grid[rowi][coli] == waterChar)
            return;
        used[rowi][coli] = true;
        for (int[] move : moves) {
            findIsland(grid, rowi + move[0], coli + move[1]);
        }
        return;
    }

    public static void main(String[] args) {
        D_numIslands_200 solution = new D_numIslands_200();
        char[][] grid = { { '1','1','0','0','0' }, { '1','1','0','0','0' }, { '0','0','1','0','0' },
                { '0','0','0','1','1' } };
        System.out.println(solution.numIslands(grid));
    }
}
