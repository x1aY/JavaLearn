package leetcode.LeetcodeHot100.AB_sec50;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.LeetcodeHot100.LcHotCommon.TreeNode;

public class M_validBST_98 {

    public static void main(String[] args) {
        M_validBST_98 ans = new M_validBST_98();
        int l = TreeNode.LEEF;
        TreeNode root = TreeNode.GenBTree(new int[] { 5, 4, 6, l, l, 3, 7 });
        System.out.println(ans.isValidBST(root));
    }

    class StackNode {
        TreeNode node;
        boolean toVisit;

        public StackNode(TreeNode node, boolean toVisit) {
            this.node = node;
            this.toVisit = toVisit;
        }

    }

    public boolean isValidBST(TreeNode root) {
        Deque<StackNode> stack = new ArrayDeque<>();
        stack.push(new StackNode(root, false));
        long leftMax = Long.MIN_VALUE;
        while (!stack.isEmpty()) {
            StackNode curr = stack.pop();
            if (curr.toVisit) {
                if (curr.node.val <= leftMax)
                    return false;
                leftMax = curr.node.val;

            } else {
                if (curr.node.right != null)
                    stack.push(new StackNode(curr.node.right, false));

                stack.push(new StackNode(curr.node, true));

                if (curr.node.left != null)
                    stack.push(new StackNode(curr.node.left, false));
            }
        }
        return true;
    }

}
