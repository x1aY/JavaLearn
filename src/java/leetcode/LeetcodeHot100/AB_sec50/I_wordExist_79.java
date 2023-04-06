package leetcode.LeetcodeHot100.AB_sec50;


public class I_wordExist_79 {

    public static void main(String[] args) {
        I_wordExist_79 ans = new I_wordExist_79();
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        ans.exist(board, word);
    }

    int[][] moves = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    int rows, cols;

    public boolean exist(char[][] board, String w) {
        rows = board.length;
        cols = board[0].length;
        char[] word = w.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word[0] && backtrack(board, word, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] word, boolean[][] visited, int row, int col, int wordIdx) {
        if (wordIdx >= word.length)
            return true;
        if (!vaildIdx(row, col) || visited[row][col] || board[row][col] != word[wordIdx])
            return false;
        visited[row][col] = true;
        for (int[] move : moves) {
            if (backtrack(board, word, visited, row + move[0], col + move[1], wordIdx + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }

    public boolean vaildIdx(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}
