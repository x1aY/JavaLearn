package leetcode.Labuladong.F_DfsBfs.A_DfsBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_solveNQueens_51 {

    public static String space = ".", queen = "Q";

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[][] used = new int[n][n];
        backtrack(lists, used, 0, n, new ArrayList<String>());
        return lists;
    }

    public static void backtrack(List<List<String>> lists, int[][] used, int currDepth, int n, List<String> listi) {
        if (currDepth == n) {
            lists.add(new ArrayList<>(listi));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[currDepth][i] == 0) {
                listi.add(GenLine(i, n));
                setUsed(1, used, i, currDepth, n);
                backtrack(lists, used, currDepth + 1, n, listi);
                setUsed(-1, used, i, currDepth, n);
                listi.remove(listi.size() - 1);
            }
        }
        return;
    }

    public static String GenLine(int i, int n) {
        return String.join("",
                Collections.nCopies(i, space)) + queen
                + String.join("",
                        Collections.nCopies(n - i - 1, space));
    }

    public static void setUsed(int val, int[][] used, int currQueen, int currDepth, int n) {
        int col = currQueen, lIncline = currQueen - 1, rIncline = currQueen + 1;
        for (int i = currDepth + 1; i < n; i++) {
            used[i][col] += val;
            if (lIncline > -1) {
                used[i][lIncline] += val;
                lIncline--;
            }
            if (rIncline < n) {
                used[i][rIncline] += val;
                rIncline++;
            }
        }
    }

    /* 更快的做法 */
    List<List<String>> res = new ArrayList<>();// 保存最后结果

    public List<List<String>> bSolveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(chessboard, n, 0);
        return res;
    }

    public void backTrack(char[][] chessboard, int n, int x) {
        if (x == n) {// 到达最后一行，将结果放入，准备回溯
            ArrayList<String> temp = new ArrayList<>();
            for (char[] c : chessboard) {
                temp.add(String.copyValueOf(c));
            }
            res.add(temp);
            return;
        }

        for (int y = 0; y < n; y++) {
            // 判断当前位置是否冲突
            if (isConflict(chessboard, x, y, n)) {
                chessboard[x][y] = 'Q';// 不冲突的话，给当前位置放入一个皇后
                backTrack(chessboard, n, x + 1);// 放入皇后之后，进入到下一行放置
                chessboard[x][y] = '.'; // 退出回溯之后放置.表示
            }
        }
    }

    // 验证当前位置是否能放皇后
    public boolean isConflict(char[][] chessboard, int x, int y, int n) {
        // 同一列有没有冲突
        for (int i = 0; i < x; i++) {
            if (chessboard[i][y] == 'Q') {
                return false;
            }
        }
        // 判断45°有没有冲突
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 判断135°有没有冲突
        for (int i = x - 1, j = y + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 同一行不需要判断，因为每一行只放一个皇后，不会冲突
        return true;
    }

    /* 判断能否放皇后的更好的做法 */
    public List<List<String>> bbsolveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        // 不fill也可以
        Arrays.fill(queens, -1);

        /* *
         * 三个set，每个set内不会重复，避免重复的删除后导致的错误
         * 竖行
         * 左上到右下：同一条斜线上，每个位置的行下标与列下标之差相等
         * 右上到左下：同一条斜线上，每个位置的行下标与列下标之和相等
         */
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns,
            Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) continue;
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) continue;
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) continue;
            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
            // 这句不写也行
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }

    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<String>> lists = solveNQueens(n);
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
