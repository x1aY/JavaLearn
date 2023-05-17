package leetcode.LeetcodeHot100.AD_fourth50;

public class L_maxSquare_221 {

    public static void main(String[] args) {
        L_maxSquare_221 solution = new L_maxSquare_221();
        char[][] mtx = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalSquare(mtx));
    }

    // https://leetcode.cn/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
    // https://leetcode.cn/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
    public int maximalSquare(char[][] mtx) {
        char tgt = '1';
        int area = 0;
        int row = mtx.length, col = mtx[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }
        return area;
    }

}
