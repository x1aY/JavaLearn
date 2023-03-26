package leetcode.Labuladong.B_BinaryTree.B_thought;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_flatten_114 {
    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            TreeNode leftLast = findLast(root.left);
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    public static TreeNode findLast(TreeNode root) {
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<TreeNode> storeList = new ArrayDeque<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            storeList.push(root);
            if (root.right != null) {
                nodeStack.push(root.right);
            }
            if (root.left != null) {
                nodeStack.push(root.left);
            }
        }
        return storeList.getLast();
    }

    public static void main(String[] args) {
        // int[] valLayer = { 1, TreeNode.LEEF, 2, TreeNode.LEEF, TreeNode.LEEF, 3,TreeNode.LEEF };
        int[] valLayer = { 1, 2, 5, 3, 4, TreeNode.LEEF, 6 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        root = findLast(root);
        System.out.println(root.val);
    }

}
