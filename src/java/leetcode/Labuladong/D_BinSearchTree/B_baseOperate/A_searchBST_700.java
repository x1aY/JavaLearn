package leetcode.Labuladong.D_BinSearchTree.B_baseOperate;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_searchBST_700 {
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(root.val==val)
                return root;
            else if(root.val>val)
                root = root.left;
            else
                root = root.right;

        }
        return null;
    }

    public static void main(String[] args) {
        int[] valLayer = {4, 2,7, 1,3,TreeNode.LEEF,TreeNode.LEEF};
        TreeNode root = TreeNode.GenBTree(valLayer);
        TreeNode sRoot = searchBST(root, 2);
        System.out.println(sRoot);
    }
}
