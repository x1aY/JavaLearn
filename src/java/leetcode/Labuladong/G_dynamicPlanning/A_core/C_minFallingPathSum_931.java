package leetcode.Labuladong.G_dynamicPlanning.A_core;

import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class C_minFallingPathSum_931 {
    // 左上 中上 右上
    int[] upperMoves = { -1, 0, 1 };

    int row, col;

    BiPredicate<Integer, Integer> isInMatrix = (rowi, coli) -> rowi >= 0 && rowi < row && coli >= 0 && coli < col;

    ToIntFunction<int[]> ArrayMin = list -> {
        int  min = list[0];
        for (int i: list) if (min>i) min = i;
        return min;
    };

    //lastmin必须在当前轮结束后再更新
    public int minFallingPathSum(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        int[] lastMin = new int[col];
        for (int i = 0; i < row; i++) {
            int[] currRow = matrix[i];
            for (int j = 0; j < col; j++) {
                int currMin = currRow[j]+lastMin[j];
                for (int move : upperMoves)
                    if (j + move >= 0 && j + move < col) {
                        currMin = Math.min(currRow[j]+ lastMin[j + move], currMin);
                    }
                currRow[j] = currMin;
            }
            lastMin = currRow;
        }
        return ArrayMin.applyAsInt(lastMin);
    }


    /* *
     * 官解
     */
    class Solution1 {
        public int minFallingPathSum(int[][] A) {
            int N = A.length;
            for (int r = N-2; r >= 0; --r) {
                for (int c = 0; c < N; ++c) {
                    // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                    int best = A[r+1][c];
                    if (c > 0)
                        best = Math.min(best, A[r+1][c-1]);
                    if (c+1 < N)
                        best = Math.min(best, A[r+1][c+1]);
                    A[r][c] += best;
                }
            }
    
            int ans = Integer.MAX_VALUE;
            for (int x: A[0])
                ans = Math.min(ans, x);
            return ans;
        }
    }

    /* *
     * 不修改原数组，动态修改lastmin，把上一个修改的用 last 变量存起来
     */
    class Solution2 {
        public int minFallingPathSum(int[][] matrix) {
            int row = matrix.length,col = matrix[0].length;
            int[] f = new int[col+2];
            f[0] = f[col+1] = Integer.MAX_VALUE;
            for(int j = 1; j <= col; j++) f[j] = matrix[0][j-1];
            for(int i = 1; i < row;i++){
                int temp = 0,last = Integer.MAX_VALUE;
                for(int j = 1; j <= col; j++){
                    temp = f[j];
                    f[j] = Math.min(Math.min(last,f[j]),f[j+1])+matrix[i][j-1];
                    last = temp;
                }
            }
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= col; j++) min = Math.min(min,f[j]);
            return min;
        }
    }

    public static void main(String[] args) {
        C_minFallingPathSum_931 solution = new C_minFallingPathSum_931();
        int[][] matrix = { { -19,57 }, { -40,-5 } };
        System.out.println(solution.minFallingPathSum(matrix));
    }
}
