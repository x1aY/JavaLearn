package leetcode.Labuladong.F_DfsBfs.C_island;

public class C_countSubIslands_1905 {

    int row, col;
    boolean[][] used;
    int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid1.length;
        col = grid1[0].length;
        used = new boolean[row][col];
        int subCount = 0;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (grid2[i][j] == 1 && !used[i][j]) {
                    if (isSubIsland(grid1, grid2, i, j)){
                        System.out.println(i+","+j);
                        subCount++;}
                }
        return subCount;
    }

    public boolean isSubIsland(int[][] grid1, int[][] grid2, int rowi, int coli) {
        if (rowi < 0 || rowi >= row || coli < 0 || coli >= col 
            || used[rowi][coli])
            return true;
        used[rowi][coli] = true;
        if(grid2[rowi][coli] == 0) return true;
        boolean flag = true;
        if (grid2[rowi][coli] == 1 && grid1[rowi][coli] == 0)
            flag= false;
        for (int[] move:moves)
            if(!isSubIsland(grid1, grid2, rowi + move[0], coli + move[1]))
                flag =false;        
        return flag;
    }

    public static void main(String[] args) {
        C_countSubIslands_1905 solution = new C_countSubIslands_1905();
        int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 } },
                grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
                        { 0, 1, 0, 1, 0 } };
        System.out.println(solution.countSubIslands(grid1, grid2));
    }
}
