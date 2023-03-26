package leetcode.Labuladong.D_BinSearchTree.A_feature;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_kthSmallest_230 {
    public static int myKthSmallest(TreeNode root, int k) {
        List<Integer> allVal = new ArrayList<>();
        inOrder(root, allVal);
        return allVal.get(k - 1);
    }

    public static void inOrder(TreeNode root, List<Integer> allVal) {
        if (root == null)
            return;
        inOrder(root.left, allVal);
        allVal.add(root.val);
        inOrder(root.right, allVal);

    }

    /*
     * *
     * 迭代中序遍历
     */
    public static int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                k--;
                if (k == 0)
                    return root.val;
                root = root.right;
            }
        }
        return -1;
    }

    /*
     * *
     * 记录子树节点数
     */
    public int kthSmallest(TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }

    class MyBst {
        TreeNode root;
        Map<TreeNode, Integer> nodeNum;

        public MyBst(TreeNode root) {
            this.root = root;
            this.nodeNum = new HashMap<TreeNode, Integer>();
            countNodeNum(root);
        }

        // 返回二叉搜索树中第k小的元素
        public int kthSmallest(int k) {
            TreeNode node = root;
            while (node != null) {
                int left = getNodeNum(node.left);
                if (left < k - 1) {
                    node = node.right;
                    k -= left + 1;
                } else if (left == k - 1) {
                    break;
                } else {
                    node = node.left;
                }
            }
            return node == null ? -1 : node.val;
        }

        // 统计以node为根结点的子树的结点数
        private int countNodeNum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
            return nodeNum.get(node);
        }

        // 获取以node为根结点的子树的结点数
        private int getNodeNum(TreeNode node) {
            return nodeNum.getOrDefault(node, 0);
        }
    }

    public static void main(String[] args) {
        int[] valLayer = { 3, 1, 4,
                TreeNode.LEEF, 2, TreeNode.LEEF, TreeNode.LEEF };
        int k = 1;
        TreeNode root = TreeNode.GenBTree(valLayer);
        System.out.println(kthSmallest1(root, k));
    }
}
