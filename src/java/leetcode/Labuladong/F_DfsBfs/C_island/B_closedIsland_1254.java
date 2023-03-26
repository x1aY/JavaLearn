package leetcode.Labuladong.F_DfsBfs.C_island;


public class B_closedIsland_1254{

    int row,col;
    boolean[][] used;

    public int closedIsland(int[][] grid) {
        row = grid.length;col = grid[0].length;
        used = new boolean[row][col];
        


        return 0;
    }

    public static void main(String[] args) {
        B_closedIsland_1254 solution = new B_closedIsland_1254();
        int[][]  grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(solution.closedIsland(grid));
    }
}