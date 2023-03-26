package leetcode.Labuladong.D_BinSearchTree.A_feature;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_bst2Gst_1038 {
    public static TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode bstRoot = root;
        int preVisited = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();

                System.out.println(String.valueOf(root.val)+", ");
                root.val +=preVisited;
                preVisited = root.val;

                root = root.left;
            }
        }
        return bstRoot;
    }

    public static void main(String[] args) {
        int[] valLayer = {4,1,6,
                        0,2,5,7,
                        TreeNode.LEEF,TreeNode.LEEF,TreeNode.LEEF,
                        3,TreeNode.LEEF,TreeNode.LEEF,TreeNode.LEEF,8};
        TreeNode root = TreeNode.GenBTree(valLayer);
        TreeNode gstRoot = bstToGst(root);
        System.out.println(gstRoot.val);
    }
}
