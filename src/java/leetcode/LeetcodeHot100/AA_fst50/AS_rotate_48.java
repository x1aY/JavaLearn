package leetcode.LeetcodeHot100.AA_fst50;

public class AS_rotate_48 {

    public static void main(String[] args) {
        AS_rotate_48 solution = new AS_rotate_48();
        int[][] matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        solution.rotate(matrix);
        leetcode.LeetcodeHot100.LcHotCommon.MyCommons.print2Dim(matrix);
    }
    
    // https://leetcode.cn/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        IDX fst = new IDX(), sec = new IDX(), trd = new IDX(), four = new IDX();
        int center = (n + 1) / 2;
        for (int i = 0; i < center; i++) {
            int maxy = n - i - 1;
            fst.set(i, i);
            while (fst.y < maxy) {
                int fromi = fst.y - i;
                sec.set(fst.x + fromi, maxy);
                trd.set(maxy, maxy - fromi);
                four.set(maxy - fromi, fst.x);
                changeFour(matrix, fst, sec, trd, four);
                fst.incY();
            }
        }
        return;
    }

    public void changeFour(int[][] matrix, IDX fst, IDX sec, IDX trd, IDX four) {
        int temp = matrix[fst.x][fst.y];
        matrix[fst.x][fst.y] = matrix[four.x][four.y];
        matrix[four.x][four.y] = matrix[trd.x][trd.y];
        matrix[trd.x][trd.y] = matrix[sec.x][sec.y];
        matrix[sec.x][sec.y] = temp;
        return;
    }

    class IDX {
        public int x, y;

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void incY() {
            this.y++;
        }

    }

}