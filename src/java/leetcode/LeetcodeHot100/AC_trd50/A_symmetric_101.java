package leetcode.LeetcodeHot100.AC_trd50;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.LeetcodeHot100.LcHotCommon.TreeNode;

public class A_symmetric_101 {

    public static void main(String[] args) {
        A_symmetric_101 ans = new A_symmetric_101();
        int n = TreeNode.LEEF;
        TreeNode root = TreeNode.GenTree(new int[] { 1, 2, 2, n, 3, n, 3 });
        System.out.println(ans.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
        return false;
    }

    // 迭代
    // ArrayDeque 不能入null！
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
    
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null || node1.val != node2.val) {
                    return false;
                }
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
    
            return true;
        }
    }

}
