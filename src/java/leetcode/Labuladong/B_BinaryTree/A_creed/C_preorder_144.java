package leetcode.Labuladong.B_BinaryTree.A_creed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.Labuladong.laCommon.TreeNode;

public class C_preorder_144 {
    
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            TreeNode currNode;
            while (!stack.isEmpty()) {
                currNode = stack.pop();
                preOrder.add(currNode.val);
                if (currNode.right != null)
                    stack.push(currNode.right);
                if (currNode.left != null)
                    stack.push(currNode.left);
            }
        }
        return preOrder;
    }

    public static void main(String[] args) {
        int[] valLayer = {1,TreeNode.LEEF,2,TreeNode.LEEF,TreeNode.LEEF,3,TreeNode.LEEF};
        TreeNode root = TreeNode.GenBTree(valLayer);
        preorderTraversal(root);
        System.out.println(preorderTraversal(root).toString());
    }

}
