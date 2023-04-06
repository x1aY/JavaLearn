package leetcode.LeetcodeHot100.AB_sec50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import leetcode.LeetcodeHot100.LcHotCommon.TreeNode;

public class L_InorderTravel_94 {

    public static void main(String[] args) {
        L_InorderTravel_94 ans = new L_InorderTravel_94();
        int n = TreeNode.LEEF;
        TreeNode root = TreeNode.GenBTree(new int[] { 1, n, 2, n, n, 3, n });
        ans.inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> travel = new ArrayList<>();
        Deque<StackNode> stack = new ArrayDeque<>();
        stack.push(new StackNode(root, false));
        while (!stack.isEmpty()) {
            StackNode curr = stack.pop();
            if (curr.toVisit)
                travel.add(curr.node.val);
            else {
                if (curr.node.right != null)
                    stack.push(new StackNode(curr.node.right, false));

                stack.push(new StackNode(curr.node, true));
                
                if (curr.node.left != null)
                    stack.push(new StackNode(curr.node.left, false));
            }
        }
        return travel;
    }

    class StackNode {
        TreeNode node;
        boolean toVisit;

        public StackNode(TreeNode node, boolean toVisit) {
            this.node = node;
            this.toVisit = toVisit;
        }
    }
}
