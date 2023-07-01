package leetcode.Labuladong.E_GraphTheory;

import java.util.ArrayList;
import java.util.List;

public class A_allPathsSourceTarget_797 {

    static List<List<Integer>> ans;
    static int nodeLen;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        nodeLen = graph.length;
        backtrack(graph, new boolean[nodeLen], new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(int[][] graph, boolean[] visited, List<Integer> path, int currNode) {
        if (currNode + 1 == nodeLen) {
            path.add(currNode);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        if (visited[currNode]) { return;}
        visited[currNode] = true;
        path.add(currNode);
        for (int nextNode : graph[currNode]) {
            backtrack(graph, visited, path, nextNode);
        }
        visited[currNode] = false;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
