package leetcode.LeetcodeHot100.AC_trd50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.LeetcodeHot100.LcHotCommon.TreeNode;

public class B_levelOrder_102 {

    public static void main(String[] args) {
        B_levelOrder_102 ans = new B_levelOrder_102();
        int n = TreeNode.LEEF;
        TreeNode root = TreeNode.GenTree(new int[] { 3, 9, 20, n, n, 15, 7 });
        ans.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int layersize = queue.size();
            for (int i = 0; i < layersize; i++) {
                TreeNode curr = queue.poll();
                layer.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            ans.add(layer);
        }
        return ans;
    }

}
