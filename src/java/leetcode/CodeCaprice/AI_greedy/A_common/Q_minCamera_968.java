package leetcode.CodeCaprice.AI_greedy.A_common;

import java.util.Stack;

import leetcode.CodeCaprice.A_codeCommon.TreeNode;

/**
 * https://programmercarl.com/0968.%E7%9B%91%E6%8E%A7%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
 */
public class Q_minCamera_968 {
    // 先序遍历
    public int minCameraCover(TreeNode root) {
        int minCover = 0;
        TreeNode curr = root, parent = new TreeNode(1);
        if (curr.left == null && curr.right == null)
            return 1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            boolean hasRchild = curr.right != null,
                    hasLchild = curr.left != null;
            if (parent.val == 0) {
                minCover++;
                parent.val = 1;
                curr.val = 1;
                if (hasRchild)
                    curr.right.val = 1;
                if (hasLchild)
                    curr.left.val = 1;
            }
            else if(curr.val==0 && !hasLchild && !hasRchild){
                minCover++;
                curr.val = 1;
            }
            if (hasRchild)
                stack.push(curr.right);
            if (hasLchild)
                stack.push(curr.left);
            parent = curr;
        }
        return minCover;
    }

    public static void main(String[] args) {
        Q_minCamera_968 solution = new Q_minCamera_968();
        int leef = TreeNode.LEEF;
        // TreeNode root = TreeNode.GenBTree(new int[] { 0, 0, leef, 0, 0, leef, leef
        // });
        TreeNode root = TreeNode.GenBTree(new int[] {
                0, leef, 0,
                leef, leef, leef, 0,
                leef, leef, leef, leef, leef, leef, leef, 0 });
        System.out.println(solution.minCameraCover(root));
    }
}
