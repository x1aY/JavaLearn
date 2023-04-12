package leetcode.LeetcodeHot100.LcHotCommon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public static int LEEF = Integer.MIN_VALUE;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    /**
     * 基于层序遍历的序列，使用队列生成一棵二叉树
     */
    public static TreeNode GenTree(int[] list) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(list[0]);
        queue.add(root);

        int idx = 1, listLen = list.length;
        while (idx < listLen) {
            TreeNode curr = queue.poll();
            // 添加左子树
            if (list[idx++] != LEEF) {
                Objects.requireNonNull(curr).left = new TreeNode(list[idx - 1]);
                queue.add(curr.left);
            }
            // 添加右子树
            if (idx < listLen && list[idx++] != LEEF) {
                Objects.requireNonNull(curr).right = new TreeNode(list[idx - 1]);
                queue.add(curr.right);
            }
        }
        return root;
    }

    /**
     * valPreorder按先序遍历
     * </p>
     * 叶子节点用TreeNode.LEEF表示
     */
    public static TreeNode GenBTree(int[] valWithOrder, String order) {
        Queue<Integer> valQueue = new ArrayDeque<>();
        for (int val : valWithOrder)
            valQueue.add(val);
        return GenSubBTreePre(valQueue);
    }

    public static TreeNode GenSubBTreePre(Queue<Integer> valQueue) {
        if (valQueue.isEmpty())
            return null;
        int val = valQueue.remove();
        if (val == Integer.MIN_VALUE)
            return null;
        TreeNode root = new TreeNode(val);
        root.left = GenSubBTreePre(valQueue);
        root.right = GenSubBTreePre(valQueue);
        return root;
    }

    /**
     * Generate Binary Tree By Layer
     * </p>
     * valLayer 按每层输入，空值用TreeNode.LEEF表示
     */
    public static TreeNode GenBTree(int[] valLayer) {
        int len = valLayer.length;
        long depth = Math.round(Math.log10(len + 1) / Math.log10(2));
        if (len == 0)
            return null;
        TreeNode root = new TreeNode(valLayer[0]);
        root.left = GenSubBTree(valLayer, 1, 1, depth);
        root.right = GenSubBTree(valLayer, 2, 1, depth);
        return root;
    }

    public static TreeNode GenSubBTree(int[] valList, int currIndex, long currDepth, long depth) {
        if (currDepth == depth || valList[currIndex] == LEEF)
            return null;
        /*
         * long preLen = Math.round(Math.pow(2, currDepth)) - 1;
         * Long currDepthPreLen = currIndex - preLen;
         * Long currDepthNextLen = Math.round(Math.pow(2, currDepth)) - currDepthPreLen
         * - 1;
         * int leftIndex = currIndex + currDepthPreLen.intValue() * 2 +
         * currDepthNextLen.intValue() + 1;
         * 化简后得到这个结果
         */
        int leftIndex = 2 * currIndex + 1;
        TreeNode currNode = new TreeNode(valList[currIndex]);
        currNode.left = GenSubBTree(valList, leftIndex, currDepth + 1, depth);
        currNode.right = GenSubBTree(valList, leftIndex + 1, currDepth + 1, depth);
        return currNode;
    }

    public static void main(String[] args) {
        // int[] valList = { 4, 2, 1, LEEF, 5, LEEF, LEEF, LEEF, 7, 6, LEEF, 3, LEEF,
        // LEEF, LEEF };
        // TreeNode root = GenBTree(valList,"PreOrder");
        int[] valLayer = { 4, 2, 7, LEEF, 3, 6, LEEF };
        TreeNode root = GenBTree(valLayer);
        System.out.println(root.val);
    }
}
