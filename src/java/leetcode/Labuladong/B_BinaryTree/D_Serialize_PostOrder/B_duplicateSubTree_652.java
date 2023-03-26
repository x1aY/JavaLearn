package leetcode.Labuladong.B_BinaryTree.D_Serialize_PostOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.Labuladong.laCommon.TreeNode;

public class B_duplicateSubTree_652 {

    public static String nullStr = "X", splitStr = ",";
    public static int nullInt = Integer.MIN_VALUE;

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

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        Map<String, Integer> serialMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode stackTop = stack.pop();
            String nodeSerial = serialize(stackTop);
            
            int freq = serialMap.getOrDefault(nodeSerial, 0);
            if (freq == 1) nodes.add(stackTop);
            serialMap.put(nodeSerial, freq + 1);
            
            if (stackTop.right != null)
                stack.push(stackTop.right);

            if (stackTop.left != null)
                stack.push(stackTop.left);
        }
        return nodes;
    }

    public static void main(String[] args) {
        int[] valLayer = { 1, 2, 3,
                4, TreeNode.LEEF, 2, 4,
                TreeNode.LEEF, TreeNode.LEEF,
                TreeNode.LEEF, TreeNode.LEEF,
                4, TreeNode.LEEF,
                TreeNode.LEEF, TreeNode.LEEF };
        TreeNode root = TreeNode.GenBTree(valLayer);
        List<TreeNode> dup = findDuplicateSubtrees(root);
        System.out.println(dup.toString());
    }
}
