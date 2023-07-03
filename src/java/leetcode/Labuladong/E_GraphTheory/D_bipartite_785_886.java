package leetcode.Labuladong.E_GraphTheory;

public class D_bipartite_785_886 {

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    static int fstColor = 1, secColor = 2;

    // https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-03a72/er-fen-tu--73400/
    public static boolean isBipartite(int[][] graph) {
        return true;
    }

    public static void backtrack(int curr, int[][] graph, int[] colors, boolean[] visited) {
        return;
    }

}
