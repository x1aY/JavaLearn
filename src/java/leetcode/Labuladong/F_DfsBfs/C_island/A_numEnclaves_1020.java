package leetcode.Labuladong.F_DfsBfs.C_island;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Objects;

public class A_numEnclaves_1020 {
    public static int myNumEnclaves(int[][] grid) {
        return 0;
    }

    /**
    private static class Coord {

        public static List<Coord> moves = new ArrayList<>(Arrays.asList(new Coord(0, 1),new Coord(1, 0),new Coord(0, -1),new Coord(-1, 0)));

        public boolean isOut(int row, int col, Coord curr) {
            return curr.x < 0 || curr.x >= row || curr.y < 0 || curr.y >= col;
        }

        public boolean isCurrCoord(int x, int y) {
            return this.x == x && this.y == y;
        }

        public void moveCoord(Coord coord) {
            this.x += coord.x;
            this.y += coord.y;
        }

        public int x;
        public int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x=" + String.valueOf(this.x) + ", y=" + String.valueOf(this.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Coord coord = (Coord) obj;
            return this.x == coord.x && this.y == coord.y;
        }
    }
    */

    /* *
     * 官方题解
     */
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int row, col;
    private static boolean[][] visited;

    public static int numEnclaves(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        // 左右边界
        for (int i = 0; i < row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col - 1);
        }
        // 上下边界
        for (int j = 1; j < col - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, row - 1, j);
        }
        int enclaves = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public static void dfs(int[][] grid, int rowi, int coli) {
        if (rowi < 0 || rowi >= row || coli < 0 || coli >= col || grid[rowi][coli] == 0 || visited[rowi][coli]) {
            return;
        }
        visited[rowi][coli] = true;
        for (int[] dir : dirs) {
            dfs(grid, rowi + dir[0], coli + dir[1]);
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 },
                { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(numEnclaves(grid));

    }
}
