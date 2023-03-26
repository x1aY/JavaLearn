package leetcode.Labuladong.B_BinaryTree.A_creed;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_maxDepth_104 {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth=0, currLen;
        while (!queue.isEmpty()) {
            depth++;
            currLen = queue.size();
            for (int i = 0; i < currLen; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left!=null)
                    queue.add(currNode.left);
                if(currNode.right!=null)
                    queue.add(currNode.right);
            }

        }
        return depth;
    }

    public static void main(String[] args) {
        int[] valLayer = { 3, 9, 20, TreeNode.LEEF, TreeNode.LEEF, 15, 7 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        System.out.println(maxDepth(root));
    }
}
