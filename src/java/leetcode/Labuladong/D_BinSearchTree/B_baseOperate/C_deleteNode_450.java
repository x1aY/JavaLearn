package leetcode.Labuladong.D_BinSearchTree.B_baseOperate;

import leetcode.Labuladong.laCommon.TreeNode;

public class C_deleteNode_450 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode currPre = root, curr = root;
        while (curr != null) {
            if (curr.val == key)
                break;
            currPre = curr;
            if (curr.val > key)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if (curr != null) {
            TreeNode rootRight = curr.right;
            if (rootRight == null) {
                if (curr == currPre)
                    root = curr.left;
                setValue(curr, currPre, curr.left);
            } else {
                if (curr == currPre)
                    root = rootRight;
                setValue(curr, currPre, rootRight);

                while (rootRight.left != null) {
                    rootRight = rootRight.left;
                }
                rootRight.left = curr.left;
            }
        }
        return root;
    }

    /**
     * 无法通过函数修改链表的引用，因为传参时相当于复制了一份，函数只在新变量名的基础上修改，原来的变量名没有修改
     */
    public static void setValue(TreeNode curr, TreeNode currPre, TreeNode currLorR) {
        // 这句不能要，另外两句能要
        // if (curr == currPre)
        // root = currLorR;
        if (currPre.val > curr.val)
            currPre.left = currLorR;
        else
            currPre.right = currLorR;
    }

    public static void main(String[] args) {
        int[] valLayer = { 5, 3, 6, 2, 4, TreeNode.LEEF, 7 };
        // int[] valLayer = { 3 };
        TreeNode root = TreeNode.GenBTree(valLayer);
        System.out.println(root.hashCode());
        TreeNode sRoot = deleteNode(root, 5);
        System.out.println(sRoot);
    }
}
