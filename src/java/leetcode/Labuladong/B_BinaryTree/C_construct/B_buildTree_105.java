package leetcode.Labuladong.B_BinaryTree.C_construct;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_buildTree_105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return GenBTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public static TreeNode GenBTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight)
            return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootInIndex = findIndex(inorder, inLeft, inRight, rootVal);
        root.left = GenBTree(preorder,
                preLeft + 1, preLeft + (rootInIndex - inLeft), inorder,
                inLeft, rootInIndex - 1);
        root.right = GenBTree(preorder,
                preLeft + (rootInIndex - inLeft) + 1, preRight, inorder,
                rootInIndex+1, inRight);
        return root;
    }

    public static int findIndex(int[] nums, int left, int right, int target) {
        if (left == right) return left;
        int targetIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (target == nums[i])
                targetIndex = i;
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
