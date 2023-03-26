package leetcode.Labuladong.B_BinaryTree.D_Serialize_PostOrder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_serialize_297 {

    public static String nullStr = "X", splitStr = ",";
    public static int nullInt = Integer.MIN_VALUE;

    // 栈 先序遍历
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return null;
        StringBuilder sBuilder = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode stackTop = stack.pop();
            if (stackTop.val == nullInt) {
                sBuilder.append(nullStr);
                sBuilder.append(splitStr);
            } else {
                sBuilder.append(String.valueOf(stackTop.val));
                sBuilder.append(splitStr);
                if (stackTop.right != null)
                    stack.push(stackTop.right);
                else
                    stack.push(new TreeNode(nullInt));

                if (stackTop.left != null)
                    stack.push(stackTop.left);
                else
                    stack.push(new TreeNode(nullInt));
            }
        }
        return sBuilder.toString();
    }

    // 递归 生成树
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] dataList = data.split(splitStr);
        Queue<String> queue = new ArrayDeque<>();
        for (String datai : dataList)
            queue.add(datai);
        return GenBTree(queue);
    }

    public static TreeNode GenBTree(Queue<String> queue) {
        String firstVal = queue.poll();
        if (nullStr.equals(firstVal))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(firstVal));
        root.left = GenBTree(queue);
        root.right = GenBTree(queue);
        return root;
    }

    public static void main(String[] args) {
        int[] valLayer = { 1, 2, TreeNode.LEEF };
        TreeNode root = TreeNode.GenBTree(valLayer);
        String rootInStr = serialize(root);
        TreeNode rootSeri = deserialize(rootInStr);
        System.out.println(rootSeri);
    }

}
