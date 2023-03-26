package leetcode.LeetcodeHot100.matrix;

public class B_searchMatrix_240 {
    public static void main(String[] args) {
        B_searchMatrix_240 solution = new B_searchMatrix_240();
        int[][] matrix = new int[][] {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }
        };
        int target = 22;
        solution.searchMatrix(matrix, target);
    }


    // https://leetcode.cn/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/ 解法2
    // https://leetcode.cn/problems/search-a-2d-matrix-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-y1ns/
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    public class IDX {
        int row, col;

        public IDX(int x, int y) {
            row = x;
            col = y;
        }

        public void set(int x, int y) {
            row = x;
            col = y;
        }

        public void copy(IDX idx) {
            row = idx.row;
            col = idx.col;
        }

        public boolean equals(IDX idx) {
            return row == idx.row && col == idx.col;
        }

    }

}
